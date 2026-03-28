public class CountVowelsConsonants {

    static void usingLoop(String s) {
        int vowels = 0, consonants = 0;
        String v = "aeiou";
        for (char c : s.toLowerCase().toCharArray()) {
            if (Character.isLetter(c)) {
                if (v.indexOf(c) != -1) vowels++;
                else consonants++;
            }
        }
        System.out.println("Loop    → Vowels: " + vowels + ", Consonants: " + consonants);
    }

    public static void main(String[] args) {
        String s = "Hello World";

        usingLoop(s);
    }
}
