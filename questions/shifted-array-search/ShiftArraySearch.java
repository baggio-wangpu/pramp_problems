public class ShiftArraySearch {

    // find peak. same as https://leetcode.com/problems/find-peak-element
    static int searchPeak(int[] nums) {
        int l = 0, r = nums.length - 1;
        while(l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] > nums[mid + 1]) {
                r = mid;
            } else if (nums[mid] < nums[mid + 1]) {
                l = mid + 1;
            }
        }
        return l;
    }

    // normal binary search
    static int binarySearch(int[] nums, int lo, int hi, int num) {
        int l = lo, r = hi;
        while(l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == num) return mid;
            else if (nums[mid] > num) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }

    static int shiftedArrSearch(int[] shiftArr, int num) {
        int highest = searchPeak(shiftArr);
        // System.out.println("peak index: " + highest);
        if (shiftArr[highest] == num) return highest;

        if (shiftArr[0] == num) return 0;
        else if (num > shiftArr[0]) { // two increasing parts, if num larger than index 0, search in first part
            return binarySearch(shiftArr, 0, highest, num);
        } else { // if num smaller than index 0, search in second parts
            return binarySearch(shiftArr, highest + 1, shiftArr.length - 1, num);
        }
    }

    public static void main(String[] args) {
        // case 1 Expected output: 3
        System.out.println(shiftedArrSearch(new int[]{9, 12, 17, 2, 4, 5}, 2));

        // case 2 Expected output: 0
        System.out.println(shiftedArrSearch(new int[]{2, 4, 5, 9, 12, 17}, 2));

        // case 3 Expected output: 5
        System.out.println(shiftedArrSearch(new int[]{2, 4, 5, 9, 12, 17}, 17));

        // case 4 Expected output: 1
        System.out.println(shiftedArrSearch(new int[]{9, 12, 17, 2, 4, 5}, 12));

        // case 5 Expected output: 5
        System.out.println(shiftedArrSearch(new int[]{9, 12, 17, 2, 4, 5}, 5));

        // case 6 Expected output: 4
        System.out.println(shiftedArrSearch(new int[]{4, 5, 9, 12, 17, 2}, 17));

        // case 7 Expected output: 5
        System.out.println(shiftedArrSearch(new int[]{4, 5, 9, 12, 17, 2}, 2));

        // case 8 Expected output: 0
        System.out.println(shiftedArrSearch(new int[]{17, 2, 4, 5, 9, 12}, 17));

        // case 9 Expected output: -1
        System.out.println(shiftedArrSearch(new int[]{17, 2, 4, 5, 9, 12}, 3));

        // case 10 Expected output: -1
        System.out.println(shiftedArrSearch(new int[]{17, 2, 4, 5, 9, 12}, 18));
    }
}
