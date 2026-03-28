public class ReverseString {

    // Approach 1: Loop
    static String usingLoop(String s) {
        char[] ch = s.toCharArray();
        int left = 0, right = ch.length - 1;
        while (left < right) {
            char temp = ch[left];
            ch[left] = ch[right];
            ch[right] = temp;
            left++;
            right--;
        }
        return new String(ch);
    }

    // Approach 2: StringBuilder
    static String usingStringBuilder(String s) {
        return new StringBuilder(s).reverse().toString();
    }

    // Approach 3: Recursion
    static String recursion(String s) {
        if (s.isEmpty()) return s;
        return recursion(s.substring(1)) + s.charAt(0);
    }

    public static void main(String[] args) {
        String s = "hello";

        System.out.println("Loop          : " + usingLoop(s));
        System.out.println("StringBuilder : " + usingStringBuilder(s));
        System.out.println("Recursion     : " + recursion(s));
    }
}
