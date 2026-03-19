import java.util.*;

public class SlidingWindowMax {

    public static ArrayList<Integer> maxInWindow(ArrayList<Integer> list, int k) {

        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i <= list.size() - k; i++) {

            int max = list.get(i);

            for (int j = i; j < i + k; j++) {
                if (list.get(j) > max) {
                    max = list.get(j);
                }
            }

            result.add(max);
        }

        return result;
    }

    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1,3,-1,-3,5,3,6,7));

        System.out.println(maxInWindow(list, 3));
    }
}
