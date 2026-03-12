import java.util.ArrayList;

public class RemoveDuplicates {

    public static ArrayList<Integer> removeDuplicates(ArrayList<Integer> list) {

        ArrayList<Integer> result = new ArrayList<>();

        for (int num : list) {
            if (!result.contains(num)) {
                result.add(num);
            }
        }

        return result;
    }

    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<>();

        list.add(1);
        list.add(2);
        list.add(2);
        list.add(3);
        list.add(3);
        list.add(4);

        System.out.println(removeDuplicates(list));
    }
}
