import java.util.*;

/**
 * Group Anagrams
 *
 * Problem: Given an array of strings, group the anagrams together.
 *          Two strings are anagrams if one is a rearrangement of the other.
 *
 * Approaches covered:
 *   1. Sort-as-key   — O(n * k log k) where k = max string length
 *   2. Count-as-key  — O(n * k), avoids sorting using character frequency as key
 *
 * Space Complexity: O(n * k) for the HashMap storage
 */
public class GroupAnagrams {

    /* Approach 1 : Sorted string as HashMap key                           */
    public static List<List<String>> groupBySorting(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);          // sorted form is the key

            map.computeIfAbsent(key, k -> new ArrayList<>()).add(s);
        }

        return new ArrayList<>(map.values());
    }

    /* Approach 2 : Character frequency array as key (faster for long strings) */
    public static List<List<String>> groupByFrequency(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            int[] count = new int[26];
            for (char c : s.toCharArray()) {
                count[c - 'a']++;
            }

            // Build a unique key like "1#0#0#2#..." from frequency array
            StringBuilder keyBuilder = new StringBuilder();
            for (int freq : count) {
                keyBuilder.append(freq).append('#');
            }
            String key = keyBuilder.toString();

            map.computeIfAbsent(key, k -> new ArrayList<>()).add(s);
        }

        return new ArrayList<>(map.values());
    }

    /* Helper: print grouped anagrams neatly                               */
    private static void printGroups(List<List<String>> groups) {
        for (int i = 0; i < groups.size(); i++) {
            List<String> group = groups.get(i);
            Collections.sort(group); // sort within group for consistent output
            System.out.println("  Group " + (i + 1) + ": " + group);
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Group Anagrams ===\n");

        // Test 1: classic LeetCode example
        String[] test1 = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println("Input           : " + Arrays.toString(test1));
        System.out.println("Sort-key method :");
        printGroups(groupBySorting(test1));
        System.out.println("Freq-key method :");
        printGroups(groupByFrequency(test1));
        System.out.println("---");

        // Test 2: all same
        String[] test2 = {"abc", "bca", "cab"};
        System.out.println("Input           : " + Arrays.toString(test2));
        System.out.println("Sort-key method :");
        printGroups(groupBySorting(test2));
        System.out.println("---");

        // Test 3: no anagrams
        String[] test3 = {"dog", "car", "bun"};
        System.out.println("Input           : " + Arrays.toString(test3));
        System.out.println("Sort-key method :");
        printGroups(groupBySorting(test3));
        System.out.println("---");

        // Test 4: empty string edge case
        String[] test4 = {""};
        System.out.println("Input           : " + Arrays.toString(test4));
        System.out.println("Sort-key method :");
        printGroups(groupBySorting(test4));
        System.out.println("---");

        // Test 5: single chars
        String[] test5 = {"a"};
        System.out.println("Input           : " + Arrays.toString(test5));
        System.out.println("Sort-key method :");
        printGroups(groupBySorting(test5));
    }
}
