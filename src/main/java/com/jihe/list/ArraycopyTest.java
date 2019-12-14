package com.jihe.list;

public class ArraycopyTest {

    public static void main(String[] args) {
        int[] a = new int[10];
        a[0] = 0;
        a[1] = 1;
        a[2] = 2;
        a[3] = 3;
        a[4] = 4;
        a[5] = 5;
        a[6] = 6;
        a[7] = 7;
        a[8] = 8;
        a[9] = 9;

        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
        /**
         * //arraycopy()方法实现数组自己复制自己
         * //elementData:源数组;index:源数组中的起始位置;  elementData：目标数组；
         *   index + 1：目标数组中的起始位置； size - index：要复制的数组元素的数量；
         */
        System.arraycopy(a, 2, a, 3, 3);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();

    }
}
