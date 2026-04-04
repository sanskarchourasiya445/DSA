import java.util.HashSet;

public class PairSum {

    // Brute force
    public static void bruteForce(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == target) {
                    System.out.println(arr[i] + " " + arr[j]);
                }
            }
        }
    }

    // Optimized using HashSet
    public static void usingHashSet(int[] arr, int target) {
        HashSet<Integer> set = new HashSet<>();

        for (int num : arr) {
            int complement = target - num;
            if (set.contains(complement)) {
                System.out.println(complement + " " + num);
            }
            set.add(num);
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 4, 5, 6, 3, 2};
        int target = 7;

        System.out.println("Brute Force:");
        bruteForce(arr, target);

        System.out.println("Using HashSet:");
        usingHashSet(arr, target);
    }
}
