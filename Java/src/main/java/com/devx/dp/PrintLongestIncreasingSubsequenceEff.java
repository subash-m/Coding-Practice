package com.devx.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author I348618
 * @since 5/15/2021
 */
public class PrintLongestIncreasingSubsequenceEff {

    static int lis(int[] input) {
        int length = input.length;
        if(length==0)
            return 0;
        int[] activeList = new int[length];
        activeList[0] = input[0];
        int size = 1;
        List<Integer> output = Stream.of(input[0]).collect(Collectors.toList());

        for(int i=1; i<length; i++) {
            // System.out.println("ActiveList: " + Arrays.toString(activeList));
            if(input[i] > activeList[size-1]) {
                activeList[size++] = input[i];
                output.add(input[i]);
            }
            else {
                int index = Arrays.binarySearch(activeList, 0, size-1, input[i]);
                if(index < 0)
                    index = -1 * index -1;
                // System.out.println("Index: " + index);
                activeList[index] = input[i];
                if(index == size-1)
                    output.set(output.size() - 1, input[i]);
            }
        }
        System.out.println("Longest increasing Subsequence: " + output.stream().map(Object::toString).collect(Collectors.joining(", ")));

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
