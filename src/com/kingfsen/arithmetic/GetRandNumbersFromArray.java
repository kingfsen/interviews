package com.kingfsen.arithmetic;

import java.util.Arrays;
import java.util.Random;

/**
 * author:SUNJINFU
 * date:2019/3/13
 * description: Get some numbers from one given int array, can not get same number.
 */
public class GetRandNumbersFromArray {


    public static int[] get(int[] array, int num) {
        int[] res = new int[num];
        if (array == null || array.length == 0 || num <= 0) {
            return res;
        }
        boolean[] used = new boolean[array.length];

        int i = 0;
        int seq = 0;
        Random r = new Random();
        while(i < num) {
            System.out.println(seq++);
            int index = r.nextInt(array.length);
            if (!used[index]) {
                used[index] = true;
                res[i] = array[index];
                i++;
            }
        }
        return res;
    }

    public static int[] optimizeGet(int[] array, int num) {
        int[] res = new int[num];
        if (array == null || array.length == 0 || num <= 0) {
            return res;
        }
        Random r = new Random();
        for (int i=0;i<num;i++) {
            int index = r.nextInt(array.length - i);
            res[i] = array[index];
            array[index] = array[array.length - i - 1];
            array[array.length - i - 1] = res[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 15, 16, 17, 18, 19, 20};
        int[] res = get(array, 19);
        Arrays.sort(res);
        System.out.println(Arrays.toString(res));
    }

}
