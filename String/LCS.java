/**
 * Longest Common Subsequence (LCS)
 * Find the length of the longest subsequence common to two strings.
 * Characters do NOT need to be contiguous, but must be in order.
 *
 * Approach: Dynamic Programming
 * dp[i][j] = LCS length of text1[0..i-1] and text2[0..j-1]
 *
 * Example: "abcde" and "ace" -> LCS = "ace" -> length 3
 */
public class LongestCommonSubsequence {

    public static int lcs(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    // Characters match — extend the subsequence
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    // Take the best from skipping one char in either string
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[m][n];
    }

    // Bonus: also reconstruct the actual LCS string
    public static String lcsString(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++)
            for (int j = 1; j <= n; j++)
                dp[i][j] = (text1.charAt(i - 1) == text2.charAt(j - 1))
                    ? dp[i - 1][j - 1] + 1
                    : Math.max(dp[i - 1][j], dp[i][j - 1]);

        // Backtrack to find the actual subsequence
        StringBuilder sb = new StringBuilder();
        int i = m, j = n;
        while (i > 0 && j > 0) {
            if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                sb.append(text1.charAt(i - 1));
                i--; j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(lcs("abcde", "ace"));        // 3
        System.out.println(lcs("abc", "abc"));          // 3
        System.out.println(lcs("abc", "def"));          // 0

        System.out.println(lcsString("abcde", "ace"));  // "ace"
        System.out.println(lcsString("AGGTAB", "GXTXAYB")); // "GTAB"
    }
}
