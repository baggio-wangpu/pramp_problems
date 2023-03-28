import java.util.HashSet;
import java.util.Set;

public class GettingADifferentNumber {

    static int getDifferentNumber(int[] arr) {
        // O(n)
        int len = arr.length;
        Set<Integer> set = new HashSet<>();
        for (int i : arr) {
            set.add(i);
        }

        for (int i = 0; i < len; i++) {
            if (!set.contains(i)) return i;
        }
        return len;
    }

    public static void main(String[] args) {
        int[] arr1 = {0, 1, 2, 3};
        // Expected output: 4
        System.out.println(getDifferentNumber(arr1));

        int[] arr2 = {0, 5, 1, 2};
        // Expected output: 3
        System.out.println(getDifferentNumber(arr2));

        int[] arr3 = {10, 100, 1, 3, 0};
        // Expected output: 2
        System.out.println(getDifferentNumber(arr3));

        int[] arr4 = {1, 10, 29, 3, 5, 8, 7};
        // Expected output: 0
        System.out.println(getDifferentNumber(arr4));
    }
}
