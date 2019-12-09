package com.concurrent.synchronizedDemo;

public class SynchronizedDemo implements Runnable{
    private static int count = 0;

    public static void main(String[] args) {
        for (int i=0; i<10; i++){
            Thread thread = new Thread(new SynchronizedDemo());
            thread.start();
        }

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("count="+count);
    }

    @Override
    public void run() {
        System.out.println("thread name="+Thread.currentThread().getName());
        for (int i=0; i<10000; i++){
            count++;
        }
    }
}
