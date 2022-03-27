package day17;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author zhougy
 * @create 2022-03-09 18:33
 */
public class Main {

    public static void main(String[] args) {
//        int[][] a = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        int[][] a = {{1, 3}};
        System.out.println(searchMatrix(a, 3));
    }

    public static int[][] generateMatrix(int n) {
        int[][] a = new int[n][n];
        for (int i = 0; i < n; i++){

        }
        return a;
    }

    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[(nums.length - 1) / 2];
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        boolean flag = false;
        if (target < matrix[0][0] || target > matrix[matrix.length - 1][matrix[0].length - 1])
            return flag;
        int highRow = 0;
        int lowRow = matrix.length - 1;
        int midRow = (highRow + lowRow) / 2;
        while (highRow < lowRow) {
            midRow = (highRow + lowRow) / 2;
            if (matrix[midRow][0] > target) {
                lowRow = midRow - 1;
            } else if (matrix[midRow][0] < target) {
                highRow = midRow + 1;
            } else {
                return true;
            }
        }
        if (matrix[midRow][0] > target)
            midRow--;
        int left = 0;
        int right = matrix[0].length - 1;
        int mid = (left + right) / 2;
        while (left < right) {
            mid = (left + right) / 2;
            if (matrix[midRow][mid] > target) {
                right = mid - 1;
            } else if (matrix[midRow][mid] < target) {
                left = mid + 1;
            } else {
                return true;
            }
        }
        if (matrix[midRow][mid] < target)
            mid++;
        if (matrix[midRow][mid] == target)
            flag = true;
        return flag;
    }

}
