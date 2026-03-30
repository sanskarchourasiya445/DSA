/**
 * Palindromic Substrings
 * Count the total number of palindromic substrings in a string.
 *
 * Approach: Expand Around Center (same idea as Longest Palindromic Substring)
 * Every expansion that succeeds is a valid palindrome — count it.
 * O(n^2) time, O(1) space.
 *
 * Example: "aaa" -> "a","a","a","aa","aa","aaa" = 6
 */
public class PalindromicSubstrings {

    public static int countSubstrings(String s) {
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            // Odd-length palindromes
            count += expand(s, i, i);
            // Even-length palindromes
            count += expand(s, i, i + 1);
        }

        return count;
    }

    // Returns how many palindromes can be formed expanding from (left, right)
    private static int expand(String s, int left, int right) {
        int count = 0;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            count++;
            left--;
            right++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(countSubstrings("abc"));  // 3  ("a","b","c")
        System.out.println(countSubstrings("aaa"));  // 6  ("a","a","a","aa","aa","aaa")
        System.out.println(countSubstrings("aba"));  // 4  ("a","b","a","aba")
        System.out.println(countSubstrings("racecar")); // 10
    }
}
