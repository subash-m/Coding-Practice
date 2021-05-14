package com.devx.array;

import java.util.Scanner;

/**
 * @author I348618
 * @since 5/14/2021
 */
public class ReverseArray {

    public static String print(int[] arr, int n) {
        String result = "[";
        for (int i = 0; i < n; i++) {
            result += arr[i] + ",";
        }
        return result + "]";
    }

    public static void reverse(int[] arr, int low, int high) {
        int temp;
        while(low< high) {
            temp = arr[high];
            arr[high] = arr[low];
            arr[low] = temp;
            low++;
            high--;
        }
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
        System.out.println("\nArray: " + print(arr, n));
        reverse(arr, 0, n-1);
        System.out.println("After reverse: " + print(arr, n));
    }
}
