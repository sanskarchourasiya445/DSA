public class FindSubstring {
    public static int findSubstring(String text, String pattern) {
        return text.indexOf(pattern);
    }
    
    public static void main(String[] args) {
        System.out.println(findSubstring("hello", "ll")); // 2
    }
}
