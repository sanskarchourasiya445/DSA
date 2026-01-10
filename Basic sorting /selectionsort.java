public class SelectionSorting {

    // Function to perform selection sort
    public static void sort(int array[]) {

        // Loop for selecting position
        for (int i = 0; i < array.length - 1; i++) {

            int minPosition = i; // assume current index has minimum

            // Find minimum element in unsorted part
            for (int j = i + 1; j < array.length; j++) {

                // For descending order, change > to <
                if (array[minPosition] > array[j]) {
                    minPosition = j;
                }
            }

            // Swap minimum element with current position
            int temp = array[minPosition];
            array[minPosition] = array[i];
            array[i] = temp;
        }
    }

    public static void main(String args[]) {

        int array[] = {5, 4, 1, 3, 2, 9, 8, 7, 6, 0};

        sort(array);

        // Print sorted array
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
}
