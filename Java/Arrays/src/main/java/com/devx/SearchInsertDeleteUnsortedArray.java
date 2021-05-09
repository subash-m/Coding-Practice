package com.devx;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author I348618
 * @since 5/9/2021
 */
public class SearchInsertDeleteUnsortedArray {

    public static int searchArray(int[] arr, int n, int key) {
        for (int i = 0; i < n; i++) {
            if (arr[i] == key) {
                return i;
            }
        }
        return -1;
    }

    public static void search(int[] arr, int n, int key) {
        System.out.println("Array: " + print(arr, n));
        int index = searchArray(arr, n, key);
        if (index == -1) {
            System.out.println(String.format("[%d] not found in array", key));
        } else {
            System.out.println(String.format("[%d] found in index: [%d]", key, index));
        }
    }

    public static int insert(int[] arr, int n, int key) {
        System.out.println("Before insert: " + print(arr, n));
        if (n >= arr.length) {
            System.out.println("Array is already at maximum capacity");
            return n;
        }
        arr[n] = key;
        System.out.println("After insert: " + print(arr, n + 1));
        return n + 1;
    }

    public static String print(int[] arr, int n) {
        String result = "[";
        for (int i = 0; i < n; i++) {
            result += arr[i] + ",";
        }
        return result + "]";
    }

    public static int delete(int[] arr, int n, int key) {
        int index = searchArray(arr, n, key);
        if (index == -1) {
            System.out.println(String.format("Element [%d] not found in the array", key));
            return n;
        }
        System.out.println("Before Delete: " + print(arr, n));
        for (int i = index; i < n - 1; i++) {
            arr[i] = arr[i + 1];
        }
        System.out.println("After Delete: " + print(arr, n - 1));
        return n - 1;
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

    public static void chooseList(int choice, int input, List<Integer> arr) {
        switch (choice) {
        case 1:
            int index = arr.indexOf(input);
            System.out.println(String.format("[%d] found in [%d]", input, index));
            break;
        case 2:
            System.out.println("Before insert: " + arr.toString());
            arr.add(input);
            System.out.println("After insert: " + arr.toString());
            break;
        case 3:
            System.out.println("Before delete: " + arr.toString());
            arr.remove(new Integer(input));
            System.out.println("Before delete: " + arr.toString());
            break;
        case 4:
            System.out.println("Exiting the program");
            break;
        default:
            System.out.println("Invalid choice");
        }
    }

    public static void menuBoilerCodeUsingList() {
        List<Integer> arr = Stream.of(1, 2, 3, 4, 5, 6).collect(Collectors.toList());

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
                chooseList(choice, input, arr);
            }
        } while (choice != 4);
    }

    public static void main(String[] args) {
        menuBoilerCodeUsingList();
    }
}
