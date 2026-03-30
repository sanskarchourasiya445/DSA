/**
 * String Compression
 * Compress a string using counts of repeated characters.
 * Example: "aaabbc" -> "a3b2c1"
 * If compressed string is not smaller, return original.
 */
public class StringCompression {

    public static String compress(String s) {
        if (s == null || s.isEmpty()) return s;

        StringBuilder sb = new StringBuilder();
        int count = 1;

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                count++;
            } else {
                sb.append(s.charAt(i - 1)).append(count);
                count = 1;
            }
        }
        // Append the last character group
        sb.append(s.charAt(s.length() - 1)).append(count);

        // Return compressed only if it's shorter
        return sb.length() < s.length() ? sb.toString() : s;
    }

    public static void main(String[] args) {
        System.out.println(compress("aaabbc"));    // a3b2c1
        System.out.println(compress("aabcccdddd")); // a2b1c3d4
        System.out.println(compress("abc"));        // abc (no compression benefit)
        System.out.println(compress("aabb"));       // aabb (same length, return original)
    }
}
