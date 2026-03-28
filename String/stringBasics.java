public class StringBasics {

    public static void main(String[] args) {

        String s = "Hello World";

        // 1. Length
        System.out.println("Length : " + s.length());

        // 2. charAt
        System.out.println("charAt(0) : " + s.charAt(0));

        // 3. indexOf
        System.out.println("indexOf('o') : " + s.indexOf('o'));

        // 4. substring
        System.out.println("substring(6) : " + s.substring(6));
        System.out.println("substring(0,5) : " + s.substring(0, 5));

        // 5. toUpperCase / toLowerCase
        System.out.println("toUpperCase : " + s.toUpperCase());
        System.out.println("toLowerCase : " + s.toLowerCase());

        // 6. trim
        String padded = "  hello  ";
        System.out.println("trim : " + padded.trim());

        // 7. replace
        System.out.println("replace l->r : " + s.replace('l', 'r'));

        // 8. contains
        System.out.println("contains 'World' : " + s.contains("World"));

        // 9. startsWith / endsWith
        System.out.println("startsWith 'Hello': " + s.startsWith("Hello"));
        System.out.println("endsWith 'World': " + s.endsWith("World"));

        // 10. equals
        System.out.println("equals : " + s.equals("Hello World"));

        // 11. split
        String[] words = s.split(" ");
        System.out.print("split by space : ");
        for (String word : words) {
            System.out.print(word + " ");
        }
        System.out.println();

        // 12. concat
        System.out.println("concat : " + "Hello".concat(" Java"));
    }
}
