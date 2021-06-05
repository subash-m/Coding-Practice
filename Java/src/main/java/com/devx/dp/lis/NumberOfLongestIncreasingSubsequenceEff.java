package com.devx.dp.lis;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author I348618
 * @since 6/3/2021
 */
public class NumberOfLongestIncreasingSubsequenceEff {

    static int lis(int[] nums) {
        int[] tail = new int[nums.length];
        TreeMap<Integer, Integer>[] dp = new TreeMap[nums.length];
        for (int i = 0; i < nums.length; i++)
            dp[i] = new TreeMap<>();
        int size = 0;
        for (int n : nums) {
            int l = 0, h = size;
            while (l < h) {
                int m = l + (h - l) / 2;
                if (tail[m] < n)
                    l = m + 1;
                else
                    h = m;
            }
            tail[l] = n;
            Map.Entry<Integer, Integer> firstEntry = dp[l].firstEntry();
            int curChoices = firstEntry == null ? 0 : firstEntry.getValue();
            if (l > 0) {
                int prevChoices = dp[l-1].firstEntry().getValue();
                Map.Entry<Integer, Integer> ceilingEntry = dp[l - 1].ceilingEntry(n);
                prevChoices -= ceilingEntry == null ? 0 : ceilingEntry.getValue();
                dp[l].put(n, curChoices + prevChoices);
            } else {
                dp[l].put(n, curChoices + 1);
            }
            if (l == size)
                size++;
        }
        return dp[size-1].firstEntry().getValue();
    }

    public static void main(String[] arg) {

        int[] arr = new int[] { 1, 2, 4, 3, 5, 4, 7 };
        System.out.printf("%nArray: %s %nNumber of LIS: [%d]%nCorrect Solution: %s%n", Arrays.toString(arr), lis(arr), lis(arr)==3);
        arr = new int[] { 1, 4, 3, 2, 5, 9, 8, 7, 10 };
        System.out.printf("%nArray: %s %nNumber of LIS: [%d]%nCorrect Solution: %s%n", Arrays.toString(arr), lis(arr), lis(arr)==9);
    }
}
