public class ShiftArraySearch {
    /*
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
    */

    private static int searchPeak(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] < nums[i]) return i; // find rotated point
        }
        return nums.length - 1;
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

    /* method1. find peak and then binary search each part
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
    */

    // method2, directly use binary search to find in shifted array
    static int shiftedArrSearch(int[] shiftArr, int num) {
        if (shiftArr.length == 0) return -1;

        int first = shiftArr[0];
        int l = 0, r = shiftArr.length - 1;
        while (l <= r) {
           int mid = l + (r - l) / 2;
           if (shiftArr[mid] == num) return mid;
           else if (shiftArr[mid] >= shiftArr[l]) {
               if (num > shiftArr[mid] || num < shiftArr[l]) { // check whether left side(left side is ordered) can be dropped
                   l = mid + 1;
               } else {
                   r = mid - 1;
               }
           } else {
               if (num < shiftArr[mid] || num > shiftArr[r]) { // check whether right side(right side is ordered) can be dropped
                   r = mid - 1;
               } else {
                   l = mid + 1;
               }
           }
        }
        return -1;
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

        // case 10 Expected output: -1
        System.out.println(shiftedArrSearch(new int[]{17}, 17));
        System.out.println(shiftedArrSearch(new int[]{17}, 1));
        System.out.println(shiftedArrSearch(new int[]{17}, 18));
        System.out.println(shiftedArrSearch(new int[]{1, 2}, 1));
        System.out.println(shiftedArrSearch(new int[]{1, 2}, 2));
        System.out.println(shiftedArrSearch(new int[]{1, 2}, 3));
        System.out.println(shiftedArrSearch(new int[]{1, 2}, 0));
    }
}
