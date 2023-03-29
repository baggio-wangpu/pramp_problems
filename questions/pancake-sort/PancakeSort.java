import java.util.Arrays;

public class PancakeSort {

    static void flip(int[] arr, int k) {
        int l = 0, r = k - 1;
        while (l < r) {
            int tmp = arr[l];
            arr[l] = arr[r];
            arr[r] = tmp;
            l++;
            r--;
        }
    }

    static int findLargest(int[] arr, int end) {
        int largest = Integer.MIN_VALUE;
        int res = -1;
        for (int i = 0; i <= end; i++) {
            if (arr[i] > largest) {
                res = i;
                largest = arr[i];
            }
        }
        return res;
    }

    // find the largest in the arr, flip it to the right place
    static int[] pancakeSort(int[] arr) {
        int ordered_index = 0;
        while (ordered_index < arr.length) {
            for (int i = 0; i < arr.length; i++) {
                int largest = findLargest(arr, arr.length - 1 - ordered_index);
                flip(arr, largest + 1);
                flip(arr, arr.length - ordered_index);
                ordered_index++;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(pancakeSort(new int[]{1, 5, 4, 3, 2})));
        System.out.println(Arrays.toString(pancakeSort(new int[]{3, 2, 4, 1})));
        System.out.println(Arrays.toString(pancakeSort(new int[]{6, 2, 3, 4, 5, 1})));
    }
}
