public class OptimisedBubbleSort {

    // Function to perform optimized bubble sort
    public static void bubbleSort(int array[]) {

        // Outer loop for passes
        for (int turn = 0; turn < array.length - 1; turn++) {

            boolean swapped = false; // tracks if any swap happens

            // Inner loop for adjacent comparison
            for (int i = 0; i < array.length - 1 - turn; i++) {

                // Compare adjacent elements
                if (array[i] > array[i + 1]) {

                    // Swap elements
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;

                    swapped = true; // mark swap happened
                }
            }

            // If no swap in this pass, array is already sorted
            if (!swapped) {
                break; // optimization
            }
        }
    }

    public static void main(String args[]) {

        int array[] = {5, 3, 2, 1, 4};

        bubbleSort(array);

        // Print sorted array
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
}
