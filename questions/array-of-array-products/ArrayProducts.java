import java.util.Arrays;

public class ArrayProducts {
    static int[] arrayOfArrayProducts(int[] arr) {

        if (arr.length <= 1) return new int[]{};

        int[] prefix = new int[arr.length];
        int[] suffix = new int[arr.length];
        prefix[0] = 1;
        suffix[arr.length - 1] = 1;

        int[] res = new int[arr.length];
        res[0] = 1;
        for (int i = 1; i < arr.length; i++) {
            prefix[i] = arr[i - 1] * prefix[i - 1];
            res[i] = prefix[i];
        }

        for (int i = arr.length - 2; i >= 0; i--) {
            suffix[i] = arr[i + 1] * suffix[i + 1];
            res[i] *= suffix[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr1 = {8, 10, 2};
        // Expected output: {20, 16, 80} by calculating {10*2, 8*2, 8*10}
        System.out.println(Arrays.toString(arrayOfArrayProducts(arr1)));

        int[] arr2 = {2, 7, 3, 4};
        // Expected output: {84, 24, 56, 42} by calculating {7*3*4, 2*3*4, 2*7*4, 2*7*3}
        System.out.println(Arrays.toString(arrayOfArrayProducts(arr2)));

        int[] arr3 = {};
        // Expected output: {}
        System.out.println(Arrays.toString(arrayOfArrayProducts(arr3)));

        int[] arr4 = {2};
        // Expected output: {}
        System.out.println(Arrays.toString(arrayOfArrayProducts(arr4)));
    }
}
