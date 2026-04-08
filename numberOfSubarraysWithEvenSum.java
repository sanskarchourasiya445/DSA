public class NumberOfSubarraysWithEvenSum {

    public static int countEvenSumSubarrays(int[] nums) {
        int evenCount = 1;
        int oddCount = 0;
        int prefixSum = 0;
        int result = 0;

        for (int num : nums) {
            prefixSum += num;

            if (prefixSum % 2 == 0) {
                result += evenCount;
                evenCount++;
            } else {
                result += oddCount;
                oddCount++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        System.out.println(countEvenSumSubarrays(nums));
    }
}
