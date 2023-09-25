package com.itheima.test;

import java.util.Random;

public class Test {
    public static void main(String[] args) {
        int[] arr1 = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
        Random r = new Random();
        for(int i = 0;i<arr1.length;i++) {
            int index = r.nextInt(arr1.length);  //代表着生成一个范围在 0 ~ arr.length 内的任意正整数
            int temp = arr1[i];
            arr1[i] = arr1[index];
            arr1[index] = temp;
        }
        for(int i = 0;i<arr1.length;i++) {
            System.out.print(arr1[i] + " " );
        }
        System.out.println();

        int[][] date = new int [4][4];
        int index = 0;
        for(int i = 0;i<arr1.length;i++) {
            date[i/4][i%4] = arr1[index];
        }
    }
}
