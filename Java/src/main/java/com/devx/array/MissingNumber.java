package com.devx.array;

import java.util.Scanner;

/**
 * @author I348618
 * @since 5/30/2021
 */
public class MissingNumber {

    static int missingNumber(int[] arr) {
        int total=0;
        for(int i=0; i<arr.length; i++) {
            total += (i+1) - arr[i];
        }
        total += arr.length+1;
        return total;
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
        System.out.println("Missing number: " + missingNumber(arr));
    }
}
