public class BinarySearch {

    public static int iterativeBS(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) return mid;
            else if (nums[mid] < target) left = mid + 1;
            else right = mid - 1;
        }

        return -1;
    }

    public static int recursiveBS(int[] nums, int left, int right, int target) {
        if (left > right) return -1;

        int mid = left + (right - left) / 2;

        if (nums[mid] == target) return mid;
        if (nums[mid] < target) return recursiveBS(nums, mid + 1, right, target);

        return recursiveBS(nums, left, mid - 1, target);
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};

        System.out.println(iterativeBS(nums, 4));
        System.out.println(recursiveBS(nums, 0, nums.length - 1, 4));
    }
}
