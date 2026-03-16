import java.util.ArrayList;

public class UnionArrayList {

    public static ArrayList<Integer> union(ArrayList<Integer> a, ArrayList<Integer> b) {

        ArrayList<Integer> result = new ArrayList<>();

        for (int num : a) {
            if (!result.contains(num)) {
                result.add(num);
            }
        }

        for (int num : b) {
            if (!result.contains(num)) {
                result.add(num);
            }
        }

        return result;
    }

    public static void main(String[] args) {

        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();

        list1.add(1);
        list1.add(2);
        list1.add(3);

        list2.add(3);
        list2.add(4);
        list2.add(5);

        System.out.println(union(list1, list2));
    }
}
