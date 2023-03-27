
public class BusiestTimeInTheMall {
    static int findBusiestPeriod(int[][] data) {
        int peakTime = 0;
        int maxCount = 0;

        int currCount = -1;
        for (int i = 0; i < data.length; i++) {
            if (data[i][2] == 1) {
                currCount += data[i][1];
            } else {
                currCount -= data[i][1];
            }

            if (i == data.length - 1 || data[i][0] != data[i + 1][0]) {
                if (currCount > maxCount) {
                    peakTime = data[i][0];
                    maxCount = currCount;
                }
            }
        }
        return peakTime;
    }

    public static void main(String[] args) {
        int[][] data = {{1487799425, 14, 1},
                {1487799425, 4, 0},
                {1487799425, 2, 0},
                {1487800378, 10, 1},
                {1487801478, 18, 0},
                {1487801478, 18, 1},
                {1487901013, 1, 0},
                {1487901211, 7, 1},
                {1487901211, 7, 0}};
        // Expected output: 1487800378
        System.out.println(findBusiestPeriod(data));
    }
}
