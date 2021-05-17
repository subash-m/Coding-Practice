package com.devx.dp;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author I348618
 * @since 5/15/2021
 */
public class LongestIncreasingSubsequenceDP {

    public static int lis(int[] input) {
        int[] mem = new int[input.length];
        Arrays.fill(mem, 1);
        int output=0;
        for(int i=1; i<input.length; i++) {
            for(int j=0; j<i; j++) {
                if(input[j] < input[i]) {
                    mem[i] = mem[i] <= mem[j] ? mem[j] + 1 : mem[i];
                }
            }
            output = output < mem[i] ? mem[i] : output;
        }
        return output;
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

        System.out.println("The Longest increasing subsequence is " + lis(input));
    }
}
