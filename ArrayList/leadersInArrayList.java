import java.util.ArrayList;

public class LeadersInArrayList {

    public static void findLeaders(ArrayList<Integer> list) {

        int maxFromRight = list.get(list.size() - 1);

        System.out.print(maxFromRight + " ");

        for (int i = list.size() - 2; i >= 0; i--) {

            if (list.get(i) > maxFromRight) {
                maxFromRight = list.get(i);
                System.out.print(maxFromRight + " ");
            }
        }
    }

    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<>();

        list.add(16);
        list.add(17);
        list.add(4);
        list.add(3);
        list.add(5);
        list.add(2);

        findLeaders(list);
    }
}
