import java.util.HashMap;

public class SubarraySumDivisibleByK {

    public static int countDivisible(int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int prefixSum = 0, count = 0;

        for (int num : arr) {
            prefixSum += num;
            int mod = ((prefixSum % k) + k) % k;

            if (map.containsKey(mod)) {
                count += map.get(mod);
            }

            map.put(mod, map.getOrDefault(mod, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        int[] arr = {4, 5, 0, -2, -3, 1};
        System.out.println(countDivisible(arr, 5));
    }
}
