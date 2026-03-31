import java.util.*;

/**
 * String Permutations
 *
 * Problem: Print / return all permutations of a given string.
 *          Handle duplicate characters gracefully.
 *
 * Approaches covered:
 *   1. Backtracking with swap  — O(n * n!)
 *   2. Backtracking with used[]— O(n * n!), handles duplicates via sorting
 *   3. Iterative (insert method)
 *
 * Time Complexity:  O(n * n!)  — n! permutations, each of length n
 * Space Complexity: O(n)       — recursion stack depth
 */
public class StringPermutations {

    /* Approach 1 : Backtracking with in-place swapping (no duplicates)    */

    public static List<String> permuteSwap(String s) {
        List<String> result = new ArrayList<>();
        char[] arr = s.toCharArray();
        backtrackSwap(arr, 0, result);
        return result;
    }

    private static void backtrackSwap(char[] arr, int start, List<String> result) {
        if (start == arr.length) {
            result.add(new String(arr));
            return;
        }
        for (int i = start; i < arr.length; i++) {
            swap(arr, start, i);
            backtrackSwap(arr, start + 1, result);
            swap(arr, start, i); // backtrack
        }
    }

    private static void swap(char[] arr, int i, int j) {
        char tmp = arr[i];
        arr[i]   = arr[j];
        arr[j]   = tmp;
    }

    /* Approach 2 : Backtracking with boolean used[] — handles duplicates  */
    public static List<String> permuteUnique(String s) {
        List<String> result = new ArrayList<>();
        char[] arr = s.toCharArray();
        Arrays.sort(arr);                          // sort to group duplicates
        backtrackUsed(arr, new boolean[arr.length], new StringBuilder(), result);
        return result;
    }

    private static void backtrackUsed(char[] arr, boolean[] used,
                                      StringBuilder current, List<String> result) {
        if (current.length() == arr.length) {
            result.add(current.toString());
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if (used[i]) continue;
            // Skip duplicate: same char as previous, and previous not yet used
            if (i > 0 && arr[i] == arr[i - 1] && !used[i - 1]) continue;

            used[i] = true;
            current.append(arr[i]);
            backtrackUsed(arr, used, current, result);
            current.deleteCharAt(current.length() - 1);
            used[i] = false;
        }
    }

    /* Approach 3 : Iterative — insert each char at every position         */
    public static List<String> permuteIterative(String s) {
        List<String> result = new ArrayList<>();
        result.add("");                            // start with empty string

        for (char c : s.toCharArray()) {
            List<String> newResult = new ArrayList<>();
            for (String perm : result) {
                for (int i = 0; i <= perm.length(); i++) {
                    newResult.add(perm.substring(0, i) + c + perm.substring(i));
                }
            }
            result = newResult;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println("=== String Permutations ===\n");

        // Test 1: no duplicates
        String s1 = "abc";
        System.out.println("Input            : \"" + s1 + "\"");
        System.out.println("Swap approach    : " + permuteSwap(s1));
        System.out.println("Iterative        : " + permuteIterative(s1));
        System.out.println("Total count      : " + permuteSwap(s1).size());
        System.out.println("---");

        // Test 2: with duplicates
        String s2 = "aab";
        System.out.println("Input            : \"" + s2 + "\"  (has duplicates)");
        System.out.println("Unique perms     : " + permuteUnique(s2));
        System.out.println("Total count      : " + permuteUnique(s2).size());
        System.out.println("---");

        // Test 3: single character
        String s3 = "a";
        System.out.println("Input            : \"" + s3 + "\"");
        System.out.println("Swap approach    : " + permuteSwap(s3));
        System.out.println("---");

        // Test 4: two characters
        String s4 = "ab";
        System.out.println("Input            : \"" + s4 + "\"");
        System.out.println("Swap approach    : " + permuteSwap(s4));
    }
}
