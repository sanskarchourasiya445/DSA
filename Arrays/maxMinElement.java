public class MaxMinElement {
    public static void findMaxMin(int[] arr) {
        int max = arr[0];
        int min = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
            if (arr[i] < min) {
                min = arr[i];
            }
        }

        System.out.println("Maximum: " + max);
        System.out.println("Minimum: " + min);
    }

    public static void main(String[] args) {
        int[] arr = {4, 2, 9, 1, 7, 5};
        findMaxMin(arr);
    }
}
