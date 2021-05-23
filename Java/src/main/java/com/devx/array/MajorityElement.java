package com.devx.array;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author I348618
 * @since 5/22/2021
 */
public class MajorityElement {

    static int findCandidate(int[] arr) {
        int majIndex = 0;
        int count = 1;
        for(int i=1; i<arr.length; i++) {
            if(arr[majIndex] == arr[i])
                count++;
            else
                count--;
            if(count==0) {
                majIndex = i;
                count = 1;
            }
        }
        return majIndex;
    }

    static void isMajority(int[] arr, int x) {
        long count = Arrays.stream(arr)
                .filter(a -> a == arr[x])
                .count();
        if(count > arr.length/2)
            System.out.println("Majority is " + arr[x]);
        else
            System.out.println("No Majority found");
    }

    public static void main(String[] args) {
        int n;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the array size: ");
        n = scanner.nextInt();
        int[] arr = new int[n];
        System.out.print("Enter the array elements: ");
        for(int i=0; i<n; i++) {
            arr[i] = scanner.nextInt();
        }
        isMajority(arr, findCandidate(arr));
    }
}
