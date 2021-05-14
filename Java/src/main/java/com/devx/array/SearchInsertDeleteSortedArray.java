package com.devx.array;

import java.util.Scanner;

/**
 * @author I348618
 * @since 5/14/2021
 */
public class SearchInsertDeleteSortedArray {

    public static int binarySearch(int[] arr, int key, int low, int high) {
        if (high < low) {
            return -1;
        }
        int mid = low + (high - low) / 2;
        if (key == arr[mid]) {
            return mid;
        }
        if (key > arr[mid]) {
            return binarySearch(arr, key, mid + 1, high);
        }
        return binarySearch(arr, key, low, mid - 1);
    }

    public static void search(int[] arr, int n, int key) {
        System.out.println("Array: " + print(arr, n));
        int index = binarySearch(arr, key, 0, n - 1);
        if (index == -1) {
            System.out.println(key + " is not found in the array");
        } else {
            System.out.println(key + " is found in index: [" + index + "]");
        }
    }

    public static int insert(int[] arr, int n, int key) {
        System.out.println("Before insert: " + print(arr, n));
        if (n >= arr.length) {
            System.out.println("Array is full");
            return n;
        }
        int i = 0;
        for (i = n - 1; i >= 0 && arr[i] > key; i--) {
            arr[i + 1] = arr[i];
        }
        arr[i + 1] = key;
        System.out.println("After insert: " + print(arr, n + 1));
        return n + 1;
    }

    public static int delete(int[] arr, int n, int key) {
        System.out.println("Before delete: " + print(arr, n));
        int index = binarySearch(arr, key, 0, n - 1);
        if (index == -1) {
            System.out.println(key + " not found to delete");
            return n;
        }

        if (n - 1 - index >= 0)
            System.arraycopy(arr, index + 1, arr, index, n - 1 - index);

        System.out.println("After delete: " + print(arr, n - 1));
        return n - 1;
    }

    public static String print(int[] arr, int n) {
        String result = "[";
        for (int i = 0; i < n; i++) {
            result += arr[i] + ",";
        }
        return result + "]";
    }

    public static int choose(int choice, int input, int[] arr, int n) {
        switch (choice) {
        case 1:
            search(arr, n, input);
            return -1;
        case 2:
            return insert(arr, n, input);
        case 3:
            return delete(arr, n, input);
        case 4:
            System.out.println("Exiting the program");
            return -1;
        default:
            System.out.println("Invalid choice");
            return -1;
        }
    }

    public static void menuBoilerCode() {
        int[] arr = new int[20];
        int n = 6;
        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }

        String menu = "\t\tMenu\n\t1) Search\n\t2) Insert\n\t3) Delete\n\t4) Exit\n";
        int choice;
        int input;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println(menu);
            System.out.print("Enter the choice: ");
            choice = scanner.nextInt();
            if (choice > 0 && choice < 4) {
                System.out.print("\nEnter the input: ");
                input = scanner.nextInt();
                int result = choose(choice, input, arr, n);
                if (choice == 2 || choice == 3) {
                    n = result;
                }
            }
        } while (choice != 4);
    }

    public static void main(String[] args) {
        menuBoilerCode();
    }
}
