/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.lovin.java8.stream;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @version $Id: Streams.java, v 0.1 2019年02月15日 10:14 lovin Exp $
 */
public class Streams {

    private enum Status{
        OPEN,CLOSE
    }

    private static final class Task{
        private final Status status;
        private final Integer points;

        public Task(Status status, Integer points) {
            this.status = status;
            this.points = points;
        }

        public Status getStatus() {
            return status;
        }

        public Integer getPoints() {
            return points;
        }

        @Override
        public String toString() {
            return String.format( "[%s, %d]", status, points );
        }
    }

    public static void main(String[] args) {
        final Collection< Task > tasks = Arrays.asList(
                new Task(Status.OPEN,5),
                new Task(Status.CLOSE,18),
                new Task(Status.OPEN,27)
        );

        //计算所有状态为open的分数和
        final long totalPointsOfOpenStatus = tasks.stream().filter(task -> task.getStatus() == Status.OPEN ).mapToInt(Task::getPoints).sum();
        System.out.println("Open status points:"+totalPointsOfOpenStatus);

        //并行处理，计算所有任务的点数之和
        final double  totalPoints =  tasks.stream().parallel().map(task -> task.getPoints()).reduce(0,Integer::sum);
        System.out.println("Total points:"+totalPoints);

        //对于一个集合，经常需要根据某些条件对其中的元素分组
        final Map<Status, List<Task>> map = tasks.stream().collect(Collectors.groupingBy(Task::getStatus));
        System.out.println(map);

        //如何计算集合中每个任务的点数在集合中所占的比重
        final Collection<String> result = tasks.stream()
                                            .mapToInt(Task::getPoints)
                                            .asLongStream()
                                            .mapToDouble(points -> points/totalPoints)
                                            .boxed()   //装箱，包装
                                            .mapToLong(weight ->(long)(weight * 100))
                                            .mapToObj(percentage -> percentage + "%")
                                            .collect(Collectors.toList());
        System.out.println(result);

    }
}