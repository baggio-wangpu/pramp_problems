import java.util.Arrays;

public class AwardBudgetCuts {

    /*
    same as https://leetcode.com/discuss/interview-question/351313/Google-or-Phone-Screen-or-Salary-Adjustment

    Input: salaries = [100, 300, 200, 400], budget = 800
    Output: 250
    Explanation: k should be 250, so the total salary after the reduction 100 + 250 + 200 + 250 is exactly equal to 800.

    Sort - [100, 200, 300, 400 ]
    Replace maximum value with k, [ 100, 200, 300, k ]
    Calculate k , k = (800-100-200-300) = 200
    If k is less than the next max, Repeat from step 2 , else done.
    2*. [100, 200, k, k ]
    3* Calculate k , k = (800-100-200)/2 = 250
    4* Done..
     */
    static double findGrantsCap(double[] grantsArray, double newBudget) {
        int len = grantsArray.length;
        Arrays.sort(grantsArray);

        double total = 0;

        for (double d : grantsArray) {
            total += d;
        }

        double prevSum = 0;
        int numOfK = 0;
        for (int i = len - 1; i >= 0; i--) {
            prevSum += grantsArray[i];
            numOfK++;
            double res = (newBudget - (total - prevSum)) / numOfK;
            if (i == 0 || res >= grantsArray[i - 1]) return res;
        }
        return 0;
    }

    public static void main(String[] args) {
        // Expected output: 47
        System.out.println(findGrantsCap(new double[]{2, 100, 50, 120, 1000}, 190));

        // Expected output: 250
        System.out.println(findGrantsCap(new double[]{100, 300, 200, 400}, 800));
    }
}
