package com.devx.dp;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author I348618
 * @since 5/14/2021
 */
public class FibonacciBottomUp {

    public static int fibonacci(int n) {
        int[] mem = new int[n+1];
        mem[0] = 0;
        mem[1] = 1;
        for(int i=2; i<=n; i++) {
            mem[i] = mem[i-1] + mem[i-2];
        }
        return mem[n];
    }

    public static void main(String[] args) {
        System.out.println("Enter the input for Fibonacci: ");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        System.out.println("The Fibonacci number is " + fibonacci(n));
    }
}
