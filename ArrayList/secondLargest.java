import java.util.ArrayList;

public class SecondLargest {

    public static int findSecondLargest(ArrayList<Integer> list) {

        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for (int num : list) {

            if (num > largest) {
                secondLargest = largest;
                largest = num;
            }

            else if (num > secondLargest && num != largest) {
                secondLargest = num;
            }
        }

        return secondLargest;
    }

    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<>();

        list.add(10);
        list.add(20);
        list.add(5);
        list.add(8);

        System.out.println("Second Largest: " + findSecondLargest(list));
    }
}
