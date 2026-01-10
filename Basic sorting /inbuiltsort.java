import java.util.Arrays;

public class InbuiltSort {

    public static void main(String[] args) {

        // ---------- FULL ARRAY SORT ----------
        int arr[] = {5, 3, 2, 1, 4};

        Arrays.sort(arr);  // sorts entire array

        System.out.println("Inbuilt sort (full array):");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

        System.out.println();


        // ---------- RANGE SORT ----------
        int arr2[] = {5, 4, 3, 2, 1};

        // sorts elements from index 0 (inclusive) to 3 (exclusive)
        Arrays.sort(arr2, 0, 3);

        System.out.println("Inbuilt sort (specific range):");
        for (int i = 0; i < arr2.length; i++) {
            System.out.print(arr2[i] + " ");
        }
    }
}
