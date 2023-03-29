import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MergingTwoPackages {

    static int[] getIndicesOfItemWeights(int[] arr, int limit) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (!map.containsKey(arr[i])) {
                map.put(limit - arr[i], i);
            } else {
                return new int[]{i, map.get(arr[i])};
            }
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        int[] arr = {4, 6, 10, 15, 16};

        // Expected output: [3, 1]
        // since these are the indices of the weights 6 and 15 whose sum equals to 21
        System.out.println(Arrays.toString(getIndicesOfItemWeights(arr, 21)));
        System.out.println(Arrays.toString(getIndicesOfItemWeights(arr, 16)));
        System.out.println(Arrays.toString(getIndicesOfItemWeights(arr, 20)));
    }
}
