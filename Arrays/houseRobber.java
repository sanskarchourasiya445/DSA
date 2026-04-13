public class HouseRobber {

    public static int rob(int[] nums) {
        int prev1 = 0; // dp[i-1]
        int prev2 = 0; // dp[i-2]

        for (int num : nums) {
            int take = num + prev2;
            int skip = prev1;

            int current = Math.max(take, skip);

            prev2 = prev1;
            prev1 = current;
        }

        return prev1;
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 9, 3, 1};
        System.out.println("Maximum robbed = " + rob(nums));
    }
}
