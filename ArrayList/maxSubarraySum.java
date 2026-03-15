import java.util.ArrayList;

public class MaxSubarraySum {

    public static int maxSubArray(ArrayList<Integer> list) {

        int maxSum = Integer.MIN_VALUE;
        int currentSum = 0;

        for (int num : list) {

            currentSum += num;

            if (currentSum > maxSum) {
                maxSum = currentSum;
            }

            if (currentSum < 0) {
                currentSum = 0;
            }
        }

        return maxSum;
    }

    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<>();

        list.add(-2);
        list.add(1);
        list.add(-3);
        list.add(4);
        list.add(-1);
        list.add(2);
        list.add(1);
        list.add(-5);
        list.add(4);

        System.out.println("Maximum Subarray Sum: " + maxSubArray(list));
    }
}
