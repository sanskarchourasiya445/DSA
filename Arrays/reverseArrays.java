public class ReverseArray {

    // In-place reverse
    public static void reverseInPlace(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }

    // Reverse using extra space
    public static int[] reverseWithExtraSpace(int[] arr) {
        int[] reversed = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            reversed[i] = arr[arr.length - 1 - i];
        }

        return reversed;
    }

    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};

        System.out.println("Original Array:");
        printArray(arr);

        reverseInPlace(arr);
        System.out.println("After In-place Reverse:");
        printArray(arr);

        int[] newReversed = reverseWithExtraSpace(arr);
        System.out.println("Using Extra Space:");
        printArray(newReversed);
    }
}
