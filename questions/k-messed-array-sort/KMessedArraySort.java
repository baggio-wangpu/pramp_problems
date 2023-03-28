import java.util.Arrays;

public class KMessedArraySort {

    // insertion sort(插入排序/洗牌算法)
    static int[] sortKMessedArray(int[] arr, int k) {
        for (int i = 1; i < arr.length; i++) {
            int tmp = arr[i];
            int j = i - 1; // prev
            while (j > 0 && arr[j] > tmp) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = tmp;
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {1, 4, 5, 2, 3, 7, 8, 6, 10, 9};
        int k = 2;
        // Expected output: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
        // since this is the number of islands in binaryMatrix
        System.out.println(Arrays.toString(sortKMessedArray(arr, k)));
    }
}
