package com.devx.dp.lcs;

/**
 * @author I348618
 * @since 6/6/2021
 */
public class LongestCommonSubsequenceLength {

    static int lcsTabulation(char[] a, char[] b) {
        int m = a.length, n = b.length;
        int[][] dp = new int[m+1][n+1];
        for(int i=0; i<=m; i++) {
            for(int j=0; j<=n; j++) {
                if (i == 0 || j == 0)
                    dp[i][j] = 0;
                else if (a[i-1] == b[j-1]) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
        return dp[m][n];
    }

    static int lcsMemoization(char[] a, char[] b, int m, int n, int[][] dp) {
        if(dp[m][n] != 0)
            return dp[m][n];
        if (m == 0 || n == 0)
            return 0;
        else if (a[m-1] == b[n-1])
            return 1 + lcsMemoization(a, b, m-1, n-1, dp);
        else
            return Math.max(lcsMemoization(a, b, m-1, n, dp), lcsMemoization(a, b, m, n-1, dp));
    }

    static void evaluate(String a, String b) {
        int[][] dp = new int[a.length()+1][b.length()+1];
        System.out.printf("%nArray 1: %s%nArray 2: %s%nTabulation Length of LCS: %d", a, b, lcsTabulation(a.toCharArray(), b.toCharArray()));
        System.out.printf("%nMemoization Length of LCS: %d", lcsMemoization(a.toCharArray(), b.toCharArray(), a.length(), b.length(), dp));
    }

    public static void main(String[] args) {
        evaluate("AGGTAB", "GXTXAYB");
        evaluate("ABCDGH", "AEDFHR");
        evaluate("AXYT", "AYZX");
    }
}
