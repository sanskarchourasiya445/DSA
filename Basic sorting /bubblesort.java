public class BubbleSort {

    // Function to perform bubble sort
    public static void bubbleSort(int array[]) {

        // Outer loop for number of passes
        for (int turn = 0; turn < array.length - 1; turn++) {

            // Inner loop for adjacent comparison
            for (int j = 0; j < array.length - 1 - turn; j++) {

                // Compare adjacent elements
                if (array[j] > array[j + 1]) {

                    // Swap
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String args[]) {

        int array[] = {5, 4, 1, 3, 2};

        bubbleSort(array);

        // Print sorted array
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
}
