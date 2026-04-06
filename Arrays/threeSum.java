import java.util.*;

public class ThreeSumIndices {

    public static List<Integer> threeSumIndices(int[] nums, int target) {
        int n = nums.length;

        for (int i = 0; i < n - 2; i++) {
            HashMap<Integer, Integer> map = new HashMap<>();

            for (int j = i + 1; j < n; j++) {
                int needed = target - nums[i] - nums[j];

                if (map.containsKey(needed)) {
                    return Arrays.asList(i, map.get(needed), j);
                }

                map.put(nums[j], j);
            }
        }

        return new ArrayList<>();
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        int target = 9;

        System.out.println(threeSumIndices(nums, target));
    }
}
