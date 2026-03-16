import java.util.ArrayList;

public class MissingNumber {

    public static int findMissing(ArrayList<Integer> list, int n) {

        int sum = n * (n + 1) / 2;

        int actualSum = 0;

        for (int num : list) {
            actualSum += num;
        }

        return sum - actualSum;
    }

    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<>();

        list.add(1);
        list.add(2);
        list.add(4);
        list.add(5);

        System.out.println(findMissing(list, 5));
    }
}
