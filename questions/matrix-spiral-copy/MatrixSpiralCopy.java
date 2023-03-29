import java.util.Arrays;

public class MatrixSpiralCopy {

    static int[] spiralCopy(int[][] inputMatrix) {
        int m = inputMatrix.length, n = inputMatrix[0].length;
        int rowUp = 0;
        int rowDown = m - 1;
        int colLeft = 0;
        int colRight = n - 1;

        int[] res = new int[m * n];
        int index = 0;
        while (rowUp <= rowDown && colLeft <= colRight) {
            // 处理行->列的正向元素遍历（这个必然存在）
            for (int i = colLeft; i <= colRight; i++) {
                res[index++] = inputMatrix[rowUp][i];
            }
            rowUp++;

            if (rowUp <= rowDown && colLeft <= colRight) { // 这个可能不存在，需要加上判断条件
                for (int j = rowUp; j <= rowDown; j++) {
                    res[index++] = inputMatrix[j][colRight];
                }
                colRight--;
            }
            // 处理反向元素遍历。 这个可能不存在，需要加上判断条件
            if (rowUp <= rowDown && colLeft <= colRight) {
                for (int i = colRight; i >= colLeft; i--) {
                    res[index++] = inputMatrix[rowDown][i];
                }
                rowDown--;
            }

            if (rowUp <= rowDown && colLeft <= colRight) {
                for (int j = rowDown; j >= rowUp; j--) {
                    res[index++] = inputMatrix[j][colLeft];
                }
                colLeft++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] inputMatrix1  = {{1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20}};
        // Expected output: {1, 2, 3, 4, 5, 10, 15, 20, 19, 18, 17, 16, 11, 6, 7, 8, 9, 14, 13, 12}
        System.out.println(Arrays.toString(spiralCopy(inputMatrix1)));

        int[][] inputMatrix2  = {{1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}};
        // Expected output: {1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7}
        System.out.println(Arrays.toString(spiralCopy(inputMatrix2)));

        int[][] inputMatrix3  = {{1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};
        // Expected output: {1, 2, 3, 6, 9, 8, 7, 4, 5}
        System.out.println(Arrays.toString(spiralCopy(inputMatrix3)));
    }
}
