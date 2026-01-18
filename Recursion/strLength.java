public class length_string {

    public static void main(String args[]) {
        String str = "Hello, World!";
        int len = length(str); // Call the recursive method
        System.out.println("Length of the string: " + len);
    }

    // Recursive method to find string length
    public static int length(String str) {
        if (str.equals("")) { // Base case: empty string
            return 0;
        } else {
            // Recursive call: 1 + length of substring excluding first character
            return 1 + length(str.substring(1));
        }
    }
}
