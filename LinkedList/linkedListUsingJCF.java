import java.util.LinkedList;
import java.util.Collections;

public class LinkedListExample {

    public static void main(String[] args) {

        // 1. Create LinkedList
        LinkedList<String> list = new LinkedList<>();

        // 2. Add elements
        list.add("Apple");
        list.add("Banana");
        list.add("Mango");
        list.add("Orange");

        System.out.println("Initial List: " + list);

        // 3. Add element at specific index
        list.add(1, "Grapes");
        System.out.println("After adding at index 1: " + list);

        // 4. Add first and last
        list.addFirst("FirstFruit");
        list.addLast("LastFruit");
        System.out.println("After addFirst & addLast: " + list);

        // 5. Access elements
        System.out.println("Element at index 2: " + list.get(2));
        System.out.println("First Element: " + list.getFirst());
        System.out.println("Last Element: " + list.getLast());

        // 6. Update element
        list.set(2, "Pineapple");
        System.out.println("After updating index 2: " + list);

        // 7. Remove elements
        list.remove("Banana");
        list.removeFirst();
        list.removeLast();
        System.out.println("After removals: " + list);

        // 8. Size of list
        System.out.println("Size of list: " + list.size());

        // 9. Check if element exists
        System.out.println("Contains Apple? " + list.contains("Apple"));

        // 10. Loop through list
        System.out.println("Using for-each loop:");
        for (String fruit : list) {
            System.out.println(fruit);
        }

        // 11. Sort the list
        Collections.sort(list);
        System.out.println("Sorted List: " + list);

        // 12. Clear all elements
        list.clear();
        System.out.println("After clearing: " + list);
    }
}
