public class ArrayIndexAndElement {

    static int indexEqualsValueSearch(int[] arr) {
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] == mid && (mid == 0 || arr[mid - 1] != mid - 1)) return mid; // find the lowest elements
            else if (arr[mid] >= mid) {
                r = mid - 1;
            } else l = mid + 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        // expected output: 2
        System.out.println(indexEqualsValueSearch(new int[]{-8, 0, 2, 5}));

        // expected output: -1
        System.out.println(indexEqualsValueSearch(new int[]{-1, 0, 3, 6}));

        // expected output: 4
        System.out.println(indexEqualsValueSearch(new int[]{-3, -2, 1, 2, 4, 5, 10}));

        // expected output: 4
        System.out.println(indexEqualsValueSearch(new int[]{-3, -2, 1, 2, 4, 5, 6}));

        // expected output: 0
        System.out.println(indexEqualsValueSearch(new int[]{0, 1, 2, 3, 4, 5, 6}));
    }
}
