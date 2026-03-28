public class PalindromeCheck {

    // Approach 1: Two Pointers
    static boolean twoPointers(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }

    // Approach 2: StringBuilder
    static boolean usingStringBuilder(String s) {
        String rev = new StringBuilder(s).reverse().toString();
        return s.equals(rev);
    }

    // Approach 3: Recursion
    static boolean recursion(String s, int left, int right) {
        if (left >= right) return true;
        if (s.charAt(left) != s.charAt(right)) return false;
        return recursion(s, left + 1, right - 1);
    }

    public static void main(String[] args) {
        String s = "madam";

        System.out.println("Two Pointers  : " + twoPointers(s));
        System.out.println("StringBuilder : " + usingStringBuilder(s));
        System.out.println("Recursion     : " + recursion(s, 0, s.length() - 1));
    }
}
