/**
 * Integer to Roman / Roman to Integer
 * Convert between integer (1–3999) and Roman numeral representations.
 *
 * Roman numerals: I=1, V=5, X=10, L=50, C=100, D=500, M=1000
 * Subtractive cases: IV=4, IX=9, XL=40, XC=90, CD=400, CM=900
 */
public class RomanNumerals {

    // --- Integer to Roman ---
    public static String intToRoman(int num) {
        int[]    values  = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < values.length; i++) {
            while (num >= values[i]) {
                sb.append(symbols[i]);
                num -= values[i];
            }
        }
        return sb.toString();
    }

    // --- Roman to Integer ---
    public static int romanToInt(String s) {
        java.util.Map<Character, Integer> map = new java.util.HashMap<>();
        map.put('I', 1); map.put('V', 5);  map.put('X', 10);
        map.put('L', 50); map.put('C', 100); map.put('D', 500); map.put('M', 1000);

        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            int curr = map.get(s.charAt(i));
            int next = (i + 1 < s.length()) ? map.get(s.charAt(i + 1)) : 0;
            // If current value is less than next, subtract (e.g. IV = 5 - 1 = 4)
            result += (curr < next) ? -curr : curr;
        }
        return result;
    }

    public static void main(String[] args) {
        // Integer to Roman
        System.out.println(intToRoman(3));    // III
        System.out.println(intToRoman(58));   // LVIII
        System.out.println(intToRoman(1994)); // MCMXCIV

        // Roman to Integer
        System.out.println(romanToInt("III"));     // 3
        System.out.println(romanToInt("LVIII"));   // 58
        System.out.println(romanToInt("MCMXCIV")); // 1994
    }
}
