public class CountingSort {

    public static void countingSort(int arr[]) {

        // Step 1: Find the largest element
        int largest = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            largest = Math.max(largest, arr[i]);
        }

        // Step 2: Create count (frequency) array
        int count[] = new int[largest + 1];

        // Step 3: Store frequency of each element
        for (int i = 0; i < arr.length; i++) {
            count[arr[i]]++;
        }

        // Step 4: Reconstruct the sorted array
        int j = 0; // index for original array
        for (int i = 0; i < count.length; i++) {

            while (count[i] > 0) {
                arr[j] = i;   // place element
                count[i]--;  // decrease frequency
                j++;         // move to next index
            }
        }
    }

    public static void main(String args[]) {

        int arr[] = {1, 4, 1, 3, 2, 4, 3, 7};

        countingSort(arr);

        // Print sorted array
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
