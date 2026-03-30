/**
 * Edit Distance (Levenshtein Distance)
 * Find the minimum number of operations (insert, delete, replace)
 * to convert string 'word1' into string 'word2'.
 *
 * Approach: Dynamic Programming
 * dp[i][j] = min operations to convert word1[0..i-1] to word2[0..j-1]
 *
 * Example: "horse" -> "ros" = 3 operations
 */
public class EditDistance {

    public static int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();

        // dp[i][j] = edit distance between first i chars of word1 and first j chars of word2
        int[][] dp = new int[m + 1][n + 1];

        // Base cases: converting to/from empty string
        for (int i = 0; i <= m; i++) dp[i][0] = i; // delete all chars of word1
        for (int j = 0; j <= n; j++) dp[0][j] = j; // insert all chars of word2

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    // Characters match — no operation needed
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(
                        dp[i - 1][j - 1], // replace
                        Math.min(
                            dp[i - 1][j],  // delete
                            dp[i][j - 1]   // insert
                        )
                    );
                }
            }
        }

        return dp[m][n];
    }

    public static void main(String[] args) {
        System.out.println(minDistance("horse", "ros"));    // 3
        System.out.println(minDistance("intention", "execution")); // 5
        System.out.println(minDistance("", "abc"));         // 3
        System.out.println(minDistance("abc", "abc"));      // 0
    }
}
