import java.util.*;

public class FindArrayGivenSubsetSums {

    public static List<Integer> recoverArray(int n, int[] sums) {
        Arrays.sort(sums);
        List<Integer> result = new ArrayList<>();

        recover(n, sums, result);
        return result;
    }

    private static void recover(int n, int[] sums, List<Integer> result) {
        if (n == 0) return;

        int diff = sums[1] - sums[0];

        List<Integer> withDiff = new ArrayList<>();
        List<Integer> withoutDiff = new ArrayList<>();

        HashMap<Integer, Integer> count = new HashMap<>();
        for (int sum : sums) {
            count.put(sum, count.getOrDefault(sum, 0) + 1);
        }

        for (int sum : sums) {
            if (count.get(sum) == 0) continue;

            withoutDiff.add(sum);
            withDiff.add(sum + diff);

            count.put(sum, count.get(sum) - 1);
            count.put(sum + diff, count.get(sum + diff) - 1);
        }

        result.add(diff);
    }

    public static void main(String[] args) {
        int[] sums = {0, 1, 3, 4};
        System.out.println(recoverArray(2, sums));
    }
}
