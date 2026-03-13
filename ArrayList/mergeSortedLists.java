import java.util.ArrayList;

public class MergeSortedLists {

    public static ArrayList<Integer> merge(ArrayList<Integer> a, ArrayList<Integer> b) {

        ArrayList<Integer> result = new ArrayList<>();

        int i = 0;
        int j = 0;

        while (i < a.size() && j < b.size()) {

            if (a.get(i) < b.get(j)) {
                result.add(a.get(i));
                i++;
            } else {
                result.add(b.get(j));
                j++;
            }
        }

        while (i < a.size()) {
            result.add(a.get(i));
            i++;
        }

        while (j < b.size()) {
            result.add(b.get(j));
            j++;
        }

        return result;
    }

    public static void main(String[] args) {

        ArrayList<Integer> a = new ArrayList<>();
        ArrayList<Integer> b = new ArrayList<>();

        a.add(1);
        a.add(3);
        a.add(5);

        b.add(2);
        b.add(4);
        b.add(6);

        System.out.println(merge(a, b));
    }
}
