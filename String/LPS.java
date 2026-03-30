/**
 * Longest Palindromic Substring
 * Find the longest palindromic substring in a given string.
 *
 * Approach: Expand Around Center
 * For each character (and each gap between characters), expand outward
 * as long as characters match. O(n^2) time, O(1) space.
 */
public class LongestPalindromicSubstring {

    public static String longestPalindrome(String s) {
        if (s == null || s.length() < 2) return s;

        int start = 0, maxLen = 1;

        for (int i = 0; i < s.length(); i++) {
            // Odd length palindromes (single center character)
            int len1 = expand(s, i, i);
            // Even length palindromes (center between two characters)
            int len2 = expand(s, i, i + 1);

            int len = Math.max(len1, len2);
            if (len > maxLen) {
                maxLen = len;
                start = i - (len - 1) / 2;
            }
        }

        return s.substring(start, start + maxLen);
    }

    // Expand from center and return length of palindrome
    private static int expand(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));   // "bab" or "aba"
        System.out.println(longestPalindrome("cbbd"));    // "bb"
        System.out.println(longestPalindrome("racecar")); // "racecar"
        System.out.println(longestPalindrome("a"));       // "a"
    }
}
