import java.util.ArrayList;

public class IntersectionArrayList {

    public static ArrayList<Integer> intersection(ArrayList<Integer> a, ArrayList<Integer> b) {
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < a.size(); i++) {
            if (b.contains(a.get(i)) && !result.contains(a.get(i))) {
                result.add(a.get(i));
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
        list1.add(4);

        list2.add(3);
        list2.add(4);
        list2.add(5);

        System.out.println(intersection(list1, list2));
    }
}
