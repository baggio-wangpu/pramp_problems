import java.util.Arrays;

public class ArrayQuadruplet {

    /*
        four sum. same as https://leetcode.com/problems/4sum/
        The difference is return distinct four elements in array for Leetcode problem
     */
    static int[] findArrayQuadruplet(int[] arr, int s) {
        int[] res = new int[4];
        int len = arr.length;

        Arrays.sort(arr);
        for (int i = 0; i < len - 3; i++) {
            // if (i > 0 && arr[i] == arr[i - 1]) continue;
            for (int j = i + 1; j < len - 2; j++) {
                // if (j > 0 && arr[j] == arr[j - 1]) continue;

                int lo = j + 1;
                int hi = len - 1;
                while(lo < hi) {
                    int sum = arr[i] + arr[j] + arr[lo] + arr[hi];
                    if (sum == s) {
                        res[0] = arr[i];
                        res[1] = arr[j];
                        res[2] = arr[lo];
                        res[3] = arr[hi];
                        return res;
                    } else if (sum < s) {
                        lo++;
                        // while (lo < hi && arr[lo] == arr[lo - 1]) lo++;
                    } else {
                        hi--;
                        // while (lo < hi && arr[hi] == arr[hi - 1]) hi--;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        // Expected output: [0, 4, 7, 9]
        System.out.println(Arrays.toString(findArrayQuadruplet(new int[]{2, 7, 4, 0, 9, 5, 1, 3}, 20)));

        // Expected output: [1, 1, 3, 5]
        System.out.println(Arrays.toString(findArrayQuadruplet(new int[]{0, 1, 3, 5, 1, 10, 9, 3}, 10)));

        // Expected output: []
        System.out.println(Arrays.toString(findArrayQuadruplet(new int[]{2, 7, 4, 0, 9, 5, 1, 3}, 30)));
    }
}
