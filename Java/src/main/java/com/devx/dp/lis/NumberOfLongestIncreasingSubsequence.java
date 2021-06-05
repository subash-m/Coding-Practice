package com.devx.dp.lis;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author I348618
 * @since 6/3/2021
 */
public class NumberOfLongestIncreasingSubsequence {

    public static int lis(int[] input) {
        int[] mem = new int[input.length];
        Arrays.fill(mem, 1);
        int[] count = new int[input.length];
        Arrays.fill(count, 1);
        int output=0;
        for(int i=1; i<input.length; i++) {
            for(int j=0; j<i; j++) {
                if(input[j] < input[i]) {
                    if(mem[j] + 1 > mem[i]) {
                        mem[i] = mem[j] + 1;
                        count[i] = count[j];
                    } else if(mem[j] + 1 == mem[i]) {
                        count[i] += count[j];
                    }
                }
            }
            output = Math.max(output, mem[i]);
        }
        // System.out.println(output+ "  "+Arrays.toString(mem)+"  " + Arrays.toString(count));
        int result=0;
        for(int i=0; i<input.length; i++) {
            if(mem[i] == output)
                result+=count[i];
        }
        return result;
    }

    public static void main(String[] arg) {
        int[] arr = new int[] { 1, 2, 4, 3, 5, 4, 7 };
        System.out.printf("%nArray: %s %nNumber of LIS: [%d]%nCorrect Solution: %s%n", Arrays.toString(arr), lis(arr), lis(arr)==3);
        arr = new int[] { 1, 4, 3, 2, 5, 9, 8, 7, 10 };
        System.out.printf("%nArray: %s %nNumber of LIS: [%d]%nCorrect Solution: %s%n", Arrays.toString(arr), lis(arr), lis(arr)==9);
    }
}
