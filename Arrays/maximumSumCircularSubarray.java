public class MaximumSumCircularSubarray {

    public static int maxSubarraySumCircular(int[] nums) {
        int totalSum = 0;
        int maxKadane = nums[0];
        int currentMax = 0;

        int minKadane = nums[0];
        int currentMin = 0;

        for (int num : nums) {
            currentMax = Math.max(num, currentMax + num);
            maxKadane = Math.max(maxKadane, currentMax);

            currentMin = Math.min(num, currentMin + num);
            minKadane = Math.min(minKadane, currentMin);

            totalSum += num;
        }

        if (maxKadane < 0) return maxKadane;

        return Math.max(maxKadane, totalSum - minKadane);
    }

    public static void main(String[] args) {
        int[] nums = {5, -3, 5};
        System.out.println("Maximum Circular Sum = " + maxSubarraySumCircular(nums));
    }
}
