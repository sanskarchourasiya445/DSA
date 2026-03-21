import java.util.ArrayList;
import java.util.Collections;

public class ArrayListExample {

    public static void main(String[] args) {

        // 1. Create ArrayList
        ArrayList<String> list = new ArrayList<>();

        // 2. Add elements
        list.add("Apple");
        list.add("Banana");
        list.add("Mango");
        list.add("Orange");

        System.out.println("Initial List: " + list);

        // 3. Add element at specific index
        list.add(1, "Grapes");
        System.out.println("After adding at index 1: " + list);

        // 4. Access elements
        System.out.println("Element at index 2: " + list.get(2));

        // 5. Update element
        list.set(2, "Pineapple");
        System.out.println("After updating index 2: " + list);

        // 6. Remove element
        list.remove("Banana");
        System.out.println("After removing Banana: " + list);

        // 7. Size of list
        System.out.println("Size of list: " + list.size());

        // 8. Check if element exists
        System.out.println("Contains Apple? " + list.contains("Apple"));

        // 9. Loop through list
        System.out.println("Using for-each loop:");
        for (String fruit : list) {
            System.out.println(fruit);
        }

        // 10. Sort the list
        Collections.sort(list);
        System.out.println("Sorted List: " + list);

        // 11. Clear all elements
        list.clear();
        System.out.println("After clearing: " + list);
    }
}
