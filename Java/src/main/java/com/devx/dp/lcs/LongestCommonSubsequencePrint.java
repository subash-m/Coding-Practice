package com.devx.dp.lcs;

/**
 * @author I348618
 * @since 6/6/2021
 */
public class LongestCommonSubsequencePrint {

    static int lcsTabulation(char[] a, char[] b) {
        int m = a.length, n = b.length;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0)
                    dp[i][j] = 0;
                else if (a[i - 1] == b[j - 1]) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        printLCS(a, b, dp, m, n);
        return dp[m][n];
    }

    static void printLCS(char[] a, char[] b, int[][] dp, int m, int n) {
        StringBuilder ans = new StringBuilder();
        while (m > 0 && n > 0) {
            if (a[m - 1] == b[n - 1]) {
                ans.append(a[m - 1]);
                m--;
                n--;
            } else if (dp[m][n - 1] < dp[m - 1][n])
                m--;
            else
                n--;
        }
        System.out.println("Longest Common Subsequence: " + ans.reverse());
    }

    static void evaluate(String a, String b) {
        System.out.printf("Array 1: %s%nArray 2: %s%n", a, b);
        System.out.printf("Tabulation Length of LCS: %d%n%n", lcsTabulation(a.toCharArray(), b.toCharArray()));
    }

    public static void main(String[] args) {
        evaluate("AGGTAB", "GXTXAYB");
        evaluate("ABCDGH", "AEDFHR");
        evaluate("AXYT", "AYZX");
    }
}
