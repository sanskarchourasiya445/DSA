public class AnagramCheck {

    public static void main(String[] args) {
        String s1 = "listen";
        String s2 = "silent";

        boolean isAnagram = true;

        if (s1.length() != s2.length()) {
            isAnagram = false;
        } else {
            String temp = s2;
            for (int i = 0; i < s1.length(); i++) {
                char c = s1.charAt(i);
                int idx = temp.indexOf(c);
                if (idx == -1) {
                    isAnagram = false;
                    break;
                }
                temp = temp.substring(0, idx) + temp.substring(idx + 1);
            }
        }

        System.out.println(s1 + " & " + s2 + " → Anagram: " + isAnagram);
    }
}
