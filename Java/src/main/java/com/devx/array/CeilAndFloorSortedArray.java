package com.devx.array;

import java.util.Arrays;

/**
 * @author I348618
 * @since 5/16/2021
 */
public class CeilAndFloorSortedArray {

    static int floor(int[] arr, int key) {
        if (arr.length == 0 || arr[0] > key)
            return -1;
        if (arr[arr.length - 1] <= key) {
            return arr.length - 1;
        }
        int low = 0;
        int high = arr.length - 1;
        while (high - low > 1) {
            int mid = low + ((high - low) / 2);
            if (arr[mid] <= key) {
                low = mid;
            } else {
                high = mid;
            }
        }
        return low;
    }

    static int ceil(int[] arr, int key) {
        if (arr.length == 0 || arr[arr.length - 1] < key)
            return -1;
        if (arr[0] >= key) {
            return 0;
        }
        int low = 0;
        int high = arr.length - 1;
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

    public static void main(String[] args) {
        int[] arr = new int[] { 1, 4, 6, 8, 9 };

        System.out.println("Array: " + Arrays.toString(arr));
        for (int i = 0; i < 11; i++) {
            int ceil = ceil(arr, i);
            int floor = floor(arr, i);
            System.out.println(String.format("Number %d --> Ceil is %d, floor is %d", i, ceil == -1 ? -1 : arr[ceil], floor==-1?-1:arr[floor]));
        }
    }
}
