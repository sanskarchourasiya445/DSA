public class CheckSorted {

    public static boolean isAscending(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1]) return false;
        }
        return true;
    }

    public static boolean isDescending(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[i - 1]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] arr = {9, 7, 5, 3, 1};
        System.out.println("Ascending: " + isAscending(arr));
        System.out.println("Descending: " + isDescending(arr));
    }
}
