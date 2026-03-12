import java.util.ArrayList;

public class MinElement {

    public static int findMin(ArrayList<Integer> list) {
        int min = list.get(0);

        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) < min) {
                min = list.get(i);
            }
        }

        return min;
    }

    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<>();

        list.add(5);
        list.add(3);
        list.add(9);
        list.add(1);

        System.out.println("Minimum element: " + findMin(list));
    }
}
