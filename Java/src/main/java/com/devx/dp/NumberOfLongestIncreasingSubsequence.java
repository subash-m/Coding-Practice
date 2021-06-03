package com.devx.dp;

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
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of items: ");
        int n = scanner.nextInt();
        int[] input = new int[n];
        System.out.print("Enter the items: ");
        for(int i=0; i<n; i++) {
            input[i] = scanner.nextInt();
        }

        System.out.println("The Number of Longest increasing subsequence is " + lis(input));
    }
}
