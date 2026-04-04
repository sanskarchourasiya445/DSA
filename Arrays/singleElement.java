public class SingleElement {

    public static int findSingle(int[] arr) {
        int xor = 0;

        for (int num : arr) {
            xor ^= num;
        }

        return xor;
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 5, 4, 5, 3, 4};
        System.out.println("Single Element: " + findSingle(arr));
    }
}
