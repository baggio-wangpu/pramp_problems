import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindTheDuplicates {

    /*
        arr1 = [1, 2, 3, 5, 6, 7], arr2 = [3, 6, 7, 8, 20]
     */
    static int[] findDuplicates(int[] arr1, int[] arr2) {
        int p1 = 0, p2 = 0;
        List<Integer> res = new ArrayList<>();
        while(p1 < arr1.length && p2 < arr2.length) {
            if (arr1[p1] < arr2[p2]) {
                p1++;
            } else if (arr1[p1] > arr2[p2]) {
                p2++;
            } else {
                res.add(arr1[p1]);
                p1++;
                p2++;
            }
        }

        int[] array = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            array[i] = res.get(i);
        }
        return array;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 5, 6, 7};
        int[] arr2 = {3, 6, 7, 8, 20};
        // Expected output: [3, 6, 7] since only these three values are both in arr1 and arr2
        System.out.println(Arrays.toString(findDuplicates(arr1, arr2)));
    }
}
