package com.devx.array;

import java.util.Scanner;

/**
 * @author I348618
 * @since 5/30/2021
 */
public class SearchInSortedRotatedArray {

    static int modifiedBinarySearch(int[] arr, int l, int h, int key) {
        if(l>h)
            return -1;
        int mid = l + (h-l)/2;
        if(arr[mid] == key)
            return mid;
        if(arr[l] < arr[mid-1]) {
            if(key>=arr[l] && key<=arr[mid-1])
                return modifiedBinarySearch(arr, l, mid-1, key);
            return modifiedBinarySearch(arr, mid+1, h, key);
        } else {
            if(key>=arr[mid+1] && key<=arr[h])
                return modifiedBinarySearch(arr, mid+1, h, key);
            return modifiedBinarySearch(arr, l, mid-1, key);
        }
    }

    public static void main(String[] args) {
        int n, key;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the array size: ");
        n = scanner.nextInt();
        int[] arr = new int[n];
        System.out.print("Enter the array elements: ");
        for(int i=0; i<n; i++) {
            arr[i] = scanner.nextInt();
        }
        System.out.print("Enter the element to search: ");
        key = scanner.nextInt();
        int index = modifiedBinarySearch(arr, 0, arr.length-1, key);
        if(index==-1)
            System.out.printf("%n%s is not found in the array", key);
        else
            System.out.printf("%nKey [%s] is found at index: [%s]%n", key, index);
    }
}
