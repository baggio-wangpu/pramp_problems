public class IslandCount {

    static int getNumberOfIslands(int[][] binaryMatrix) {
        int count = 0;
        int m = binaryMatrix.length, n = binaryMatrix[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (binaryMatrix[i][j] == 1) {
                    count++;
                    dfs(binaryMatrix, m, n, i, j, new boolean[m][n]);
                }
            }
        }
        return count;
    }

    private static void dfs(int[][] binaryMatrix, int m, int n, int i, int j, boolean[][] isVisited) {
        if (i < 0 || i >= m || j < 0 || j >= n || isVisited[i][j] || binaryMatrix[i][j] == 0) return;

        binaryMatrix[i][j] = 0;
        isVisited[i][j] = true;
        dfs(binaryMatrix, m, n, i + 1, j, isVisited);
        dfs(binaryMatrix, m, n, i - 1, j, isVisited);
        dfs(binaryMatrix, m, n, i, j + 1, isVisited);
        dfs(binaryMatrix, m, n, i, j - 1, isVisited);
    }

    public static void main(String[] args) {
        int[][] binaryMatrix1 = {{0,    1,    0,    1,    0},
                                {0,    0,    1,    1,    1},
                                {1,    0,    0,    1,    0},
                                {0,    1,    1,    0,    0},
                                {1,    0,    1,    0,    1}};
        // Expected output: 6
        System.out.println(getNumberOfIslands(binaryMatrix1));

        int[][] binaryMatrix2 = {{0,    0,    0,    0,    0},
                                 {0,    0,    1,    1,    1},
                                 {1,    1,    0,    1,    0},
                                 {0,    1,    1,    0,    0},
                                 {1,    0,    1,    1,    1}};
        // Expected output: 3
        System.out.println(getNumberOfIslands(binaryMatrix2));
    }
}
