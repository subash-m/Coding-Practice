package com.devx.array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * @author I348618
 * @since 5/22/2021
 */
public class FindPairWithSumX {

    static void pairWithSumX(int[] arr, int x) {
        Set<Integer> dict = new HashSet<>();
        boolean isFound=false;
        for(int i=0; i<arr.length; i++) {
            int temp = x - arr[i];
            if(dict.contains(temp)) {
                System.out.println(String.format("Pair is [%d, %d] which sums to %d", temp, arr[i], x));
                isFound = true;
            }
            dict.add(arr[i]);
        }
        if(!isFound)
            System.out.printf("No pair is found with sum "+ x);
    }

    public static void main(String[] args) {
        int n, x;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the array size: ");
        n = scanner.nextInt();
        int[] arr = new int[n];
        System.out.print("Enter the array elements: ");
        for(int i=0; i<n; i++) {
            arr[i] = scanner.nextInt();
        }
        System.out.print("Enter the element x: ");
        x = scanner.nextInt();
        pairWithSumX(arr, x);
    }
}
