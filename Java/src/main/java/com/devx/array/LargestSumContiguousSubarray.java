package com.devx.array;

import java.util.Scanner;

/**
 * @author I348618
 * @since 5/23/2021
 */
public class LargestSumContiguousSubarray {

    static int largestSumSubArray(int[] nums) {
         // Working code with sub-array

         int currentMax = nums[0];
         int maxSoFar = nums[0];
         int start=0, end=0, s=0, t=0;
         for(int i=1; i<nums.length; i++) {
             if(nums[i] > currentMax+nums[i]) {
                 currentMax = nums[i];
                 start = i;
             } else {
                 currentMax = currentMax + nums[i];
                 end = i;
             }
             if(maxSoFar < currentMax) {
                 maxSoFar = currentMax;
                 s=start;
                 t=end;
             }
         }
        System.out.print("Largest Sum Subarray: ");
         for(;s<=t;s++) {
             System.out.print(nums[s] + " ");
         }
         return maxSoFar;
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
        System.out.println("\nLargest Sum: " + largestSumSubArray(arr));
    }
}
