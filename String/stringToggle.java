public class ToggleCase {

    public static void main(String[] args) {
        String s = "Hello World";
        String result = "";

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isUpperCase(c)) result += Character.toLowerCase(c);
            else if (Character.isLowerCase(c)) result += Character.toUpperCase(c);
            else result += c;
        }

        System.out.println("Before : " + s);
        System.out.println("After  : " + result);
    }
}
