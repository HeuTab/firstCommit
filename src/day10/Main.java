package day10;

import java.util.Arrays;
import java.util.FormatFlagsConversionMismatchException;
import java.util.Hashtable;

/**
 * @author zhougy
 * @create 2022-02-22 9:12
 */
public class Main {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        int[][] a = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        zero(a, 0, 0);
        System.out.println(Arrays.toString(a));
    }

    public static int maxSubarraySumCircular(int[] nums) {
        return 1;
    }

    public static int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = dp[0];
        for (int i =1;i<nums.length;i++){
            dp[i] = Math.max(dp[i-1]+nums[i],nums[i]);
            max = Math.max(max,dp[i]);
        }
        return max;
    }

    public static void setZeroes(int[][] matrix) {

    }

    public static void zero(int[][] matrix, int a, int b) {
        for (int i = 0; i < matrix[a].length && i != b; i++) {
            if (matrix[a][i] == 0) {
//                for ()
            }
            matrix[a][i] = 0;
        }
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][b] = 0;
        }
    }

    public static ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null) {
            if (fast.next == null)
                break;
            else if (fast.next.next == null) {
                slow = slow.next;
                break;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

}
