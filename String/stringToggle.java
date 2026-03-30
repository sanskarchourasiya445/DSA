
/**
 * Toggle Case
 *
 * PROBLEM:
 * Convert every uppercase letter to lowercase and every lowercase letter
 * to uppercase in a given string. Non-letter characters (spaces, digits,
 * punctuation) are left unchanged.
 *
 * EXAMPLE:
 *   Input  : "Hello World"
 *   Output : "hELLO wORLD"
 *
 * APPROACH:
 * Iterate over each character one by one. For each character:
 *   - If it is UPPERCASE → convert to lowercase
 *   - If it is LOWERCASE → convert to uppercase
 *   - Otherwise (space, digit, symbol) → keep it as-is
 * Append every processed character to a result string.
 */
public class ToggleCase {

    public static void main(String[] args) {

        String s = "Hello World"; // Original input string
        String result = "";       // Will hold the toggled output (built character by character)

        // Loop through every character in the string using its index
        for (int i = 0; i < s.length(); i++) {

            char c = s.charAt(i); // Extract the character at position i

            if (Character.isUpperCase(c)) {
                /*
                 * Character is UPPERCASE (e.g. 'H', 'W')
                 * → Convert to its lowercase equivalent and append
                 * 'H' becomes 'h', 'W' becomes 'w'
                 */
                result += Character.toLowerCase(c);

            } else if (Character.isLowerCase(c)) {
                /*
                 * Character is LOWERCASE (e.g. 'e', 'l', 'o')
                 * → Convert to its uppercase equivalent and append
                 * 'e' becomes 'E', 'l' becomes 'L'
                 */
                result += Character.toUpperCase(c);

            } else {
                /*
                 * Character is NOT a letter — could be a space ' ', digit '3',
                 * punctuation '!', etc.
                 * → No conversion needed, append it unchanged
                 */
                result += c;
            }
        }

        // Print original and toggled strings for comparison
        System.out.println("Before : " + s);       // Hello World
        System.out.println("After  : " + result);  // hELLO wORLD
    }
}
