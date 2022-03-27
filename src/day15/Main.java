package day15;

import java.util.function.DoublePredicate;

/**
 * @author zhougy
 * @create 2022-03-04 13:51
 */
public class Main {

    public static void main(String[] args) {

    }

    public static int minFallingPathSum(int[][] matrix) {
        int[][] a = {{-1, -1}, {-1, 0}, {-1, 1}};
        int min;
        int minValue = Integer.MAX_VALUE;
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                min = Integer.MAX_VALUE;
                for (int k = 0; k < 3; k++) {
                    int new_x = i + a[k][0];
                    int new_y = j + a[k][1];
                    if (new_x >= 0 && new_x < matrix.length && new_y >= 0 && new_y < matrix[0].length && matrix[new_x][new_y] < min)
                        min = matrix[new_x][new_y];
                }
                matrix[i][j] += min;
                if (i == matrix.length - 1) {
                    if (matrix[i][j] < minValue)
                        minValue = matrix[i][j];
                }
            }
        }
        return minValue;
    }

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid[0][0] == 1)
            return 0;
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = 1;
        for (int i = 1; i < m; i++) {
            if (obstacleGrid[i][0] == 1) {
                while (i < m) {
                    dp[i][0] = 0;
                    i++;
                }
            } else {
                dp[i][0] = 1;
            }
        }
        for (int i = 1; i < n; i++) {
            if (obstacleGrid[0][i] == 1) {
                while (i < n) {
                    dp[0][i] = 0;
                    i++;
                }
            } else {
                dp[0][i] = 1;
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m - 1][n - 1];
    }

    public static int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0 || i == 0) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m - 1][n - 1];
    }

}
