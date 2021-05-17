package com.devx.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author I348618
 * @since 5/14/2021
 */
public class FibonacciTopDown {

    private static Long NULL = -1l;
    private static Long[] mem;

    public static Long fibonacci(int n) {
        if (mem[n] == NULL) {
            if (n < 2)
                mem[n] = new Long(n);
            else
                mem[n] = fibonacci(n - 1) + fibonacci(n - 2);
        }
        return mem[n];
    }

    public static void main(String[] args) {
        System.out.println("Enter the input for Fibonacci: ");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        mem = new Long[n+1];
        Arrays.fill(mem, -1l);

        System.out.println("The Fibonacci number is " + fibonacci(n));
    }
}
