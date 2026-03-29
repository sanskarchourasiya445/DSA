public class RemoveDuplicates {

    public static void main(String[] args) {
        String s = "programming";
        String result = "";

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (result.indexOf(c) == -1) {
                result += c;
            }
        }

        System.out.println("Before : " + s);
        System.out.println("After  : " + result);
    }
}

// import java.util.LinkedHashSet;

// public class RemoveDuplicates {

//     public static void main(String[] args) {
//         String s = "programming";
//         LinkedHashSet<Character> set = new LinkedHashSet<>();

//         for (char c : s.toCharArray()) {
//             set.add(c);
//         }

//         String result = "";
//         for (char c : set) result += c;

//         System.out.println("Before : " + s);
//         System.out.println("After  : " + result);
//     }
// }
