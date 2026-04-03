public class MoveZerosToEnd {

    public static void moveZeros(int[] arr) {
        int index = 0;

        // Move non-zero elements forward
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                arr[index] = arr[i];
                index++;
            }
        }

        // Fill remaining places with 0
        while (index < arr.length) {
            arr[index] = 0;
            index++;
        }
    }

    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 3, 12};

        System.out.println("Before:");
        printArray(arr);

        moveZeros(arr);

        System.out.println("After:");
        printArray(arr);
    }
}
