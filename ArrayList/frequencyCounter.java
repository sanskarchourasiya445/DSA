import java.util.ArrayList;

public class FrequencyCounter {

    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<>();

        list.add(1);
        list.add(2);
        list.add(2);
        list.add(3);
        list.add(3);
        list.add(3);

        for (int i = 0; i < list.size(); i++) {

            int count = 1;

            if (list.get(i) == -1)
                continue;

            for (int j = i + 1; j < list.size(); j++) {

                if (list.get(i).equals(list.get(j))) {
                    count++;
                    list.set(j, -1);
                }
            }

            System.out.println(list.get(i) + " -> " + count);
        }
    }
