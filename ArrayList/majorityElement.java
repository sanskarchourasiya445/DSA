import java.util.*;

public class MajorityElement {

    public static int findMajority(ArrayList<Integer> list) {

        int candidate = list.get(0);
        int count = 1;

        for (int i = 1; i < list.size(); i++) {

            if (list.get(i) == candidate) {
                count++;
            } else {
                count--;
            }

            if (count == 0) {
                candidate = list.get(i);
                count = 1;
            }
        }

        return candidate;
    }

    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(2,2,1,1,2,2,2));

        System.out.println(findMajority(list));
    }
}
