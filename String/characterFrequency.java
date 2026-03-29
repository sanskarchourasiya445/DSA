public class CharacterFrequency {

    public static void main(String[] args) {
        String s = "hello world";
        String visited = "";

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (visited.indexOf(c) == -1) {
                int count = 0;
                for (int j = 0; j < s.length(); j++) {
                    if (s.charAt(j) == c) count++;
                }
                System.out.println("'" + c + "' = " + count);
                visited += c;
            }
        }
    }
}
