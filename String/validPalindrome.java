public class ValidPalindromeII {
    public static boolean validPalindrome(String s) {
        return check(s, 0, s.length() - 1, false);
    }
    
    private static boolean check(String s, int left, int right, boolean usedSkip) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                if (usedSkip) return false;
                return check(s, left + 1, right, true) || 
                       check(s, left, right - 1, true);
            }
            left++;
            right--;
        }
        return true;
    }
    
    public static void main(String[] args) {
        System.out.println(validPalindrome("abca")); // true
    }
}
