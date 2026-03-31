import java.util.*;

/**
 * Decode String
 *
 * Problem: Given an encoded string like "3[a2[bc]]", decode it to "abcbcabcbcabcbc".
 *          The encoding rule is: k[encoded_string] → repeat encoded_string k times.
 *          k is always a positive integer. Input is always valid.
 *
 * Approaches covered:
 *   1. Stack-based  — O(n * maxK) time, O(n) space
 *   2. Recursive    — O(n * maxK) time, O(n) stack depth
 *
 * Time Complexity:  O(n * maxK) where maxK is the largest repeat factor
 * Space Complexity: O(n)
 */
public class DecodeString {

    /* Approach 1 : Stack-based (iterative)                                */
    public static String decodeStack(String s) {
        Deque<Integer>       countStack  = new ArrayDeque<>();
        Deque<StringBuilder> stringStack = new ArrayDeque<>();
        StringBuilder        current     = new StringBuilder();
        int                  k           = 0;

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                k = k * 10 + (c - '0');           // handle multi-digit numbers

            } else if (c == '[') {
                countStack.push(k);               // save current repeat count
                stringStack.push(current);        // save current string so far
                current = new StringBuilder();    // start fresh for inner part
                k = 0;

            } else if (c == ']') {
                int repeat       = countStack.pop();
                StringBuilder decoded = stringStack.pop();
                for (int i = 0; i < repeat; i++) {
                    decoded.append(current);      // append inner string `repeat` times
                }
                current = decoded;                // decoded becomes the new current

            } else {
                current.append(c);                // regular character
            }
        }

        return current.toString();
    }

    /* Approach 2 : Recursive                                              */
    private static int index = 0; // global pointer across recursive calls

    public static String decodeRecursive(String s) {
        index = 0;
        return decode(s);
    }

    private static String decode(String s) {
        StringBuilder result = new StringBuilder();
        int k = 0;

        while (index < s.length()) {
            char c = s.charAt(index);

            if (Character.isDigit(c)) {
                k = k * 10 + (c - '0');
                index++;

            } else if (c == '[') {
                index++;                           // skip '['
                String inner = decode(s);          // recurse into bracket
                for (int i = 0; i < k; i++) {
                    result.append(inner);
                }
                k = 0;

            } else if (c == ']') {
                index++;                           // skip ']', return to caller
                return result.toString();

            } else {
                result.append(c);
                index++;
            }
        }

        return result.toString();
    }
  
    public static void main(String[] args) {
        System.out.println("=== Decode String ===\n");

        String[][] testCases = {
            {"3[a]2[bc]",      "aaabcbc"},
            {"3[a2[c]]",       "accaccacc"},
            {"2[abc]3[cd]ef",  "abcabccdcdcdef"},
            {"10[a]",          "aaaaaaaaaa"},
            {"abc",            "abc"},              // no encoding
            {"2[3[a]b]",       "aaabaaab"}
        };

        for (String[] tc : testCases) {
            String input    = tc[0];
            String expected = tc[1];
            String stack    = decodeStack(input);
            String recur    = decodeRecursive(input);

            System.out.println("Input     : \"" + input + "\"");
            System.out.println("Expected  : \"" + expected + "\"");
            System.out.println("Stack     : \"" + stack + "\" " + (stack.equals(expected)    ? "✓" : "✗"));
            System.out.println("Recursive : \"" + recur + "\" " + (recur.equals(expected)    ? "✓" : "✗"));
            System.out.println("---");
        }
    }
}
