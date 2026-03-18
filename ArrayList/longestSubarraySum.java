import java.util.*;

public class longestSubarraySum {

    public static int longestSubarray(ArrayList<Integer> list, int k) {

        int maxLength = 0;

        for (int i = 0; i < list.size(); i++) {

            int sum = 0;

            for (int j = i; j < list.size(); j++) {

                sum += list.get(j);

                if (sum == k) {
                    maxLength = Math.max(maxLength, j - i + 1);
                }
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1,2,3,1,1,1,1));

        System.out.println(longestSubarray(list, 3));
    }
}
