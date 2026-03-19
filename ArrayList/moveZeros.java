import java.util.*;

public class MoveZeros {

    public static void move(ArrayList<Integer> list) {

        int index = 0;

        for (int i = 0; i < list.size(); i++) {

            if (list.get(i) != 0) {
                int temp = list.get(i);
                list.set(i, list.get(index));
                list.set(index, temp);
                index++;
            }
        }
    }

    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(0,1,0,3,12));

        move(list);

        System.out.println(list);
    }
}
