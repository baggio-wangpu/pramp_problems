import java.util.Arrays;

public class TimePlanner {

    /*
        input:  slotsA = [[10, 50], [60, 120], [140, 210]]
                slotsB = [[0, 15], [60, 70]]
                dur = 8
        output: [60, 68]

        input:  slotsA = [[10, 50], [60, 120], [140, 210]]
                slotsB = [[0, 15], [60, 70]]
                dur = 12
        output: null
     */
    // TC: O(max(n, m))
    static int[] meetingPlanner(int[][] slotsA, int[][] slotsB, int dur) {
        int lenA = slotsA.length, lenB = slotsB.length;
        int indexA = 0, indexB = 0;

        while (indexA < lenA && indexB < lenB) {

            /*
            两个intervals([start1, end1] 和 [start2, end2])，不管是否排序，或者相对位置怎样。他们是否overlap，只需要判断max(start1, start2) < min(end1, end2)。
            如果它们存在overlap，那么overlap的距离长度：[max(start1, start2), min(end1, end2)].
             */
            int start = Math.max(slotsA[indexA][0], slotsB[indexB][0]);
            int end = Math.min(slotsA[indexA][1], slotsB[indexB][1]);

            if (end - start >= dur) { // overlap and satisfied
                return new int[]{start, start + dur};
            }

            if (slotsA[indexA][1] > slotsB[indexB][1]) { // keep later end time slot
                indexB++;
            } else {
                indexA++;
            }
        }
        return null;
    }

    public static void main(String[] args) {

        // case1
        int[][] slotsA = {{10, 50}, {60, 120}, {140, 210}};
        int[][] slotsB = {{0, 15}, {60, 70}};
        int dur = 8;
        // Expected output: [60, 68]
        int[] output = meetingPlanner(slotsA, slotsB, dur);
        for (int i : output) {
            System.out.print(i + " ");
        }
        System.out.println("Case 1 end.");

        // case2
        // Expected output: [30, 40]
        slotsA = new int[][]{{0, 10}, {15, 20}, {25, 28}, {30, 40}};
        slotsB = new int[][]{{8, 15}, {16, 18}, {20, 22}, {23, 50}};
        dur = 10;
        // Expected output: [30, 40]
        output = meetingPlanner(slotsA, slotsB, dur);
        for (int i : output) {
            System.out.print(i + " ");
        }
        System.out.println("Case 2 end.");

        slotsA = new int[][]{{10, 50}, {60, 120}, {140, 210}};
        slotsB = new int[][]{{0, 15}, {60, 70}};
        dur = 12;
        // Expected output: []
        // since there is no common slot whose duration is 12
        System.out.print(Arrays.toString(meetingPlanner(slotsA, slotsB, dur)));
        System.out.println(" Case 3 end.");
    }
}
