public class RemoveWhitespaces {

    public static void main(String[] args) {
        String s = "Hello World Java";

        String result = s.replaceAll("\\s", "");

        System.out.println("Before : " + s);
        System.out.println("After  : " + result);
    }
}