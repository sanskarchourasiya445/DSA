/**
 * Reverse String
 *
 * PROBLEM:
 * Reverse the characters of a given string.
 *
 * EXAMPLE:
 *   Input  : "hello"
 *   Output : "olleh"
 *
 * THREE APPROACHES covered here:
 *   1. Two-Pointer Loop  — most efficient, O(n) time, O(n) space (for char array)
 *   2. StringBuilder     — cleanest/most idiomatic in Java, O(n) time & space
 *   3. Recursion         — elegant but O(n) call stack depth, not ideal for long strings
 */
public class ReverseString {

    // ─────────────────────────────────────────────
    // APPROACH 1: Two-Pointer Loop
    //
    // IDEA:
    // Convert the string to a char array (strings are immutable in Java, so we
    // need a mutable structure to swap in place). Place one pointer at the start
    // (left) and one at the end (right). Swap the characters at both pointers,
    // then move them toward each other. Stop when they meet in the middle.
    //
    // VISUAL ("hello"):
    //   [h, e, l, l, o]
    //    ^           ^     swap h ↔ o  →  [o, e, l, l, h]
    //       ^     ^        swap e ↔ l  →  [o, l, l, e, h]
    //          ^           left == right, stop (middle char 'l' stays)
    //
    // TIME  : O(n) — each character is visited once
    // SPACE : O(n) — char array copy of the string
    // ─────────────────────────────────────────────
    static String usingLoop(String s) {

        char[] ch = s.toCharArray(); // Convert to char array so we can swap in place
        int left  = 0;               // Pointer starting at the first character
        int right = ch.length - 1;   // Pointer starting at the last character

        while (left < right) {       // Keep swapping until the two pointers meet

            // Swap characters at left and right using a temp variable
            char temp  = ch[left];
            ch[left]   = ch[right];
            ch[right]  = temp;

            left++;   // Move left pointer one step toward the center
            right--;  // Move right pointer one step toward the center
        }

        return new String(ch); // Convert char array back to a String and return
    }

    // ─────────────────────────────────────────────
    // APPROACH 2: StringBuilder
    //
    // IDEA:
    // Java's StringBuilder class has a built-in reverse() method that handles
    // everything internally. This is the most concise and idiomatic Java solution.
    //
    // HOW IT WORKS (internally same as Approach 1):
    //   new StringBuilder("hello")  →  StringBuilder holding ['h','e','l','l','o']
    //   .reverse()                  →  StringBuilder holding ['o','l','l','e','h']
    //   .toString()                 →  "olleh"
    //
    // TIME  : O(n) — reverse() iterates through the characters once
    // SPACE : O(n) — StringBuilder internally holds a copy of the string
    // ─────────────────────────────────────────────
    static String usingStringBuilder(String s) {
        return new StringBuilder(s) // Wrap the string in a mutable StringBuilder
                   .reverse()       // Reverse it in place
                   .toString();     // Convert back to an immutable String
    }

    // ─────────────────────────────────────────────
    // APPROACH 3: Recursion
    //
    // IDEA:
    // Peel off the first character, recursively reverse the rest of the string,
    // then place the first character at the very end.
    //
    // RECURRENCE:
    //   reverse(s) = reverse(s[1..end]) + s[0]
    //
    // CALL STACK for "hello":
    //   recursion("hello")
    //     recursion("ello") + 'h'
    //       recursion("llo") + 'e'
    //         recursion("lo") + 'l'
    //           recursion("o") + 'l'
    //             recursion("") + 'o'
    //             returns ""          ← BASE CASE: empty string, nothing to reverse
    //           returns "" + 'o' = "o"
    //         returns "o" + 'l' = "ol"
    //       returns "ol" + 'l' = "oll"
    //     returns "oll" + 'e' = "olle"
    //   returns "olle" + 'h' = "olleh"  ← final answer
    //
    // TIME  : O(n)  — n recursive calls, one per character
    // SPACE : O(n)  — n frames on the call stack simultaneously
    //
    // ⚠ NOTE: Not recommended for very long strings — deep recursion can cause
    //          a StackOverflowError in Java (default stack depth ~500–1000 frames).
    // ─────────────────────────────────────────────
    static String recursion(String s) {
        if (s.isEmpty()) return s; // BASE CASE: empty string is already reversed

        // Recursive step:
        //   s.substring(1)  → everything after the first character
        //   s.charAt(0)     → the first character, placed at the end after recursion
        return recursion(s.substring(1)) + s.charAt(0);
    }
    
    public static void main(String[] args) {
        String s = "hello"; // Input string to reverse

        // All three should print "olleh"
        System.out.println("Loop          : " + usingLoop(s));          // olleh
        System.out.println("StringBuilder : " + usingStringBuilder(s)); // olleh
        System.out.println("Recursion     : " + recursion(s));          // olleh
    }
}
