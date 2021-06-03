package com.devx.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author I348618
 * @since 5/15/2021
 */
public class LongestIncreasingSubsequenceEff {
    static int ceil(int[] arr, int high, int key) {
        int low = -1;
        while (high - low > 1) {
            int mid = low + ((high - low) / 2);
            if (arr[mid] >= key) {
                high = mid;
            } else {
                low = mid;
            }
        }
        return high;
    }

    static int lis(int[] input) {
        int length = input.length;
        if(length==0)
            return 0;
        int[] activeList = new int[length];
        activeList[0] = input[0];
        int size = 1;

        for(int i=1; i<length; i++) {
            if(input[i] > activeList[size-1]) {
                activeList[size++] = input[i];
            }
            else {
                int index = ceil(activeList, size-1, input[i]);
                activeList[index] = input[i];
            }
        }
        return size;
    }

    public static void main(String[] args) {
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
