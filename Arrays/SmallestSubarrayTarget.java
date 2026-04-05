public class SmallestSubarrayTarget {

    public static int minSubarrayLen(int target, int[] arr) {
        int left = 0, sum = 0;
        int minLen = Integer.MAX_VALUE;

        for (int right = 0; right < arr.length; right++) {
            sum += arr[right];

            while (sum >= target) {
                minLen = Math.min(minLen, right - left + 1);
                sum -= arr[left++];
            }
        }

        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 2, 4, 3};
        System.out.println(minSubarrayLen(7, arr));
    }
}
