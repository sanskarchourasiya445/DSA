import java.util.*;

/**
 * First Non-Repeating Character in a String
 *
 * Approach: Use a LinkedHashMap to preserve insertion order while counting frequencies.
 * Then iterate to find the first character with frequency 1.
 *
 * Time Complexity:  O(n)
 * Space Complexity: O(1) — at most 26 lowercase letters
 */
public class FirstNonRepeatingChar {

    // Returns the first non-repeating character, or '\0' if none exists
    public static char firstNonRepeating(String s) {
        if (s == null || s.isEmpty()) return '\0';

        // LinkedHashMap preserves insertion order
        Map<Character, Integer> freq = new LinkedHashMap<>();

        for (char c : s.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        for (Map.Entry<Character, Integer> entry : freq.entrySet()) {
            if (entry.getValue() == 1) return entry.getKey();
        }

        return '\0'; // No non-repeating character found
    }

    // Returns the index of the first non-repeating character, or -1 if none
    public static int firstNonRepeatingIndex(String s) {
        if (s == null || s.isEmpty()) return -1;

        int[] freq = new int[26];

        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        for (int i = 0; i < s.length(); i++) {
            if (freq[s.charAt(i) - 'a'] == 1) return i;
        }

        return -1;
    }

    // Stream-based approach (Java 8+)
    public static char firstNonRepeatingStream(String s) {
        return s.chars()
                .mapToObj(c -> (char) c)
                .filter(c -> s.indexOf(c) == s.lastIndexOf(c))
                .findFirst()
                .orElse('\0');
    }

    public static void main(String[] args) {
        String[] testCases = {"aabbcde", "aabb", "leetcode", "abcabc", "z"};

        System.out.println("=== First Non-Repeating Character ===\n");

        for (String s : testCases) {
            char result  = firstNonRepeating(s);
            int  index   = firstNonRepeatingIndex(s);
            char stream  = firstNonRepeatingStream(s);

            System.out.println("Input   : \"" + s + "\"");
            System.out.println("Result  : " + (result == '\0' ? "None" : "'" + result + "'"));
            System.out.println("Index   : " + (index  == -1   ? "Not found" : String.valueOf(index)));
            System.out.println("Stream  : " + (stream == '\0' ? "None" : "'" + stream + "'"));
            System.out.println("---");
        }
    }
}
