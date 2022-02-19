package day07;

import com.sun.corba.se.spi.orbutil.threadpool.NoSuchWorkQueueException;
import com.sun.org.apache.xerces.internal.dom.PSVIAttrNSImpl;

import java.awt.font.NumericShaper;
import java.util.Arrays;

/**
 * @author zhougy
 * @create 2022-02-19 9:41
 */
public class Main {

    public static void main(String[] args) {
        int[] a = {0};
        int[] b = {1};
        merge(a,0,b,1);
        System.out.println(Arrays.toString(a));
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int pos = nums1.length - 1;
        m--;
        n--;
        while (m >= 0 && n >= 0) {
            nums1[pos] = nums1[m] >= nums2[n] ? nums1[m--] : nums2[n--];
            pos--;
        }
        while (n>=0){
            nums1[pos] = nums2[n--];
            pos--;
        }
    }

    public static int minCostClimbingStairs(int[] cost) {
        if (cost.length == 1)
            return cost[0];
        int[] dp = new int[cost.length];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i = 2; i < cost.length; i++) {
            dp[i] = Math.min(dp[i - 1], dp[i - 2]) + cost[i];
        }
        return Math.min(dp[cost.length - 1], dp[cost.length - 2]);
    }

    public static void rotate(int[] nums, int k) {
        k = k % nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }

//    public static void rotate(int[] nums, int k) {
//        if (k == 0 || nums.length == 1)
//            return;
//        if (k > nums.length)
//            k = k % nums.length;
//        int[] a = new int[nums.length];
//        int i = nums.length - k;
//        int pos = 0;
//        while (pos != nums.length) {
//            a[pos] = nums[i];
//            i++;
//            i %= nums.length;
//            pos++;
//        }
//        for (int j = 0; j < nums.length; j++) {
//            nums[j] = a[j];
//        }
//        System.out.println(Arrays.toString(nums));
//    }

    public static void reverse(int[] arr, int a, int b) {
        while (a < b) {
            swap(arr, a, b);
            a++;
            b--;
        }
    }

    public static int[] sortedSquares(int[] nums) {
        int[] ans = new int[nums.length];
        int right = nums.length - 1;
        int left = 0;
        int pos = right;
        while (pos >= 0) {
            if (Math.abs(nums[left]) > Math.abs(nums[right])) {
                ans[pos] = nums[left] * nums[left];
                pos--;
                left++;
            } else if (Math.abs(nums[left]) <= Math.abs(nums[right])) {
                ans[pos] = nums[right] * nums[right];
                pos--;
                right--;
            }
        }
        return ans;
    }

    public static void swap(int[] nums, int a, int b) {
        nums[a] = nums[a] ^ nums[b];
        nums[b] = nums[a] ^ nums[b];
        nums[a] = nums[a] ^ nums[b];
    }

}
