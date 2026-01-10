public class InsertionSorting {

    public static void sort(int array[]) {

        int n = array.length;

        // Loop starts from index 1 because first element is already "sorted"
        for (int i = 1; i < n; i++) {

            int current = array[i];   // element to be inserted
            int previous = i - 1;     // index of previous element

            // Shift elements greater than current to the right
            while (previous >= 0 && array[previous] > current) {
                array[previous + 1] = array[previous];
                previous--;
            }

            // Insert current element at correct position
            array[previous + 1] = current;

            // Print array after each pass (for understanding)
            for (int j = 0; j < array.length; j++) {
                System.out.print(array[j] + " ");
            }
            System.out.println("------");
        }
    }

    public static void main(String args[]) {

        int array[] = {1, 2, 3, 5, 4};

        // Initial array
        for (int j = 0; j < array.length; j++) {
            System.out.print(array[j] + " ");
        }
        System.out.println("------");

        sort(array);
    }
}
