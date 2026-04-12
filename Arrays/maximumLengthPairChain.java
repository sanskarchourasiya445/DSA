import java.util.Arrays;

public class MaximumLengthPairChain {

    public static int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a, b) -> a[1] - b[1]);

        int count = 1;
        int end = pairs[0][1];

        for (int i = 1; i < pairs.length; i++) {
            if (pairs[i][0] > end) {
                count++;
                end = pairs[i][1];
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[][] pairs = {{1,2},{2,3},{3,4}};
        System.out.println("Max chain = " + findLongestChain(pairs));
    }
}
