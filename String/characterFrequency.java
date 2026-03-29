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


// import java.util.HashMap;

// public class CharacterFrequency {

//     public static void main(String[] args) {
//         String s = "hello world";
//         HashMap<Character, Integer> map = new HashMap<>();

//         for (char c : s.toCharArray()) {
//             map.put(c, map.getOrDefault(c, 0) + 1);
//         }

//         for (char c : s.toCharArray()) {
//             if (map.containsKey(c)) {
//                 System.out.println("'" + c + "' = " + map.get(c));
//                 map.remove(c);
//             }
//         }
//     }
// }
