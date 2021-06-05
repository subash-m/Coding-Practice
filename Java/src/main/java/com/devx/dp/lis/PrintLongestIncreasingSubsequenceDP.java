package com.devx.dp.lis;

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
public class PrintLongestIncreasingSubsequenceDP {
    public static List<Integer> lis(int[] input) {
        if(input.length < 2) {
            return Arrays.stream(input).boxed().collect(Collectors.toList());
        }
        List<Integer>[] mem = new List[input.length];
        for(int i=0; i<input.length; i++) {
            mem[i] = new ArrayList<>();
        }
        mem[0].add(input[0]);
        List<Integer> output = new ArrayList<>();
        for(int i=1; i<input.length; i++) {
            for(int j=0; j<i; j++) {
                if(input[j] < input[i] && mem[j].size() >= mem[i].size()) {
                    mem[i] = new ArrayList<>(mem[j]);
                }
            }
            mem[i].add(input[i]);
            output = output.size() < mem[i].size() ? mem[i] : output;
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
