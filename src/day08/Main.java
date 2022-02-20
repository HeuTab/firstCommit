package day08;

import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.awt.font.NumericShaper;
import java.util.Arrays;
import java.util.Hashtable;

/**
 * @author zhougy
 * @create 2022-02-20 8:42
 */
public class Main {

    public static void main(String[] args) {
        int[] a = {2,3,2};
//        System.out.println(Arrays.copyOfRange(a,0,1));
//        System.out.println(Arrays.toString(Arrays.copyOfRange(a,0,1)));
        System.out.println(rob2(a));
    }

    public static int rob2(int[] nums) {
        if (nums.length == 1)
            return nums[0];
        if (nums.length == 2)
            return Math.max(nums[0], nums[1]);
        int max1 = rob(Arrays.copyOfRange(nums, 1, nums.length));
        int max2 = rob(Arrays.copyOfRange(nums, 0, nums.length - 1));
        return Math.max(max1, max2);
    }

    public static int rob(int[] nums) {
        if (nums.length == 1)
            return nums[0];
        if (nums.length == 2)
            return Math.max(nums[0], nums[1]);
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        int max = Math.max(dp[0], dp[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
            max = Math.max(dp[i], max);
        }
        return max;
    }

    public static int deleteAndEarn(int[] nums) {
        int max = 0;
        for (int num : nums) {
            max = num > max ? num : max;
        }
        int[] a = new int[max + 1];
        for (int num : nums) {
            a[num] += num;
        }
        return rob(a);
    }

//    public static int rob(int[] nums) {
//        if (nums.length == 1)
//            return nums[0];
//        if (nums.length == 2)
//            return Math.max(nums[0], nums[1]);
//        int[] dp = new int[nums.length];
//        dp[0] = nums[0];
//        dp[1] = Math.max(nums[0], nums[1]);
//        int max = Math.max(dp[0], dp[1]);
//        for (int i = 2; i < nums.length; i++) {
//            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
//            max = dp[i] > max ? dp[i] : max;
//        }
//        return max;
//    }

    public static int maxProfit(int[] prices) {
        int[] dp = new int[prices.length];
        int[] count = new int[prices.length];
        dp[0] = prices[0];
        count[0] = 0;
        int i = 1;
        int max = 0;
        while (i < prices.length) {
            dp[i] = Math.min(dp[i - 1], prices[i]);
            count[i] = prices[i] - dp[i];
            max = count[i] > max ? count[i] : max;
            i++;
        }
        return max;
    }

    public static int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int point1 = 0;
        int point2 = 0;
        int pos = 0;
        int[] a = new int[Math.max(nums1.length, nums2.length)];
        while (point1 != nums1.length && point2 != nums2.length) {
            if (nums1[point1] == nums2[point2]) {
                a[pos] = nums1[point1];
                pos++;
                point1++;
                point2++;
                continue;
            }
            if (nums1[point1] > nums2[point2]) {
                point2++;
                continue;
            }
            if (nums1[point1] < nums2[point2])
                point1++;
        }
        return Arrays.copyOfRange(a, 0, pos);
    }

    public static int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        while (numbers[left] + numbers[right] != target && left != right) {
            if (numbers[left] + numbers[right] > target)
                right--;
            if (numbers[left] + numbers[right] < target)
                left++;
        }
        if (numbers[left] + numbers[right] != target)
            return null;
        int[] a = {left + 1, right + 1};
        return a;
    }

    public static void moveZeroes(int[] nums) {
        int n = nums.length, left = 0, right = 0;
        while (right < n) {
            if (nums[right] != 0) {
                swap(nums, left, right);
                left++;
            }
            right++;
        }
    }

    public static void swap(int[] arr, int a, int b) {
        arr[a] = arr[a] ^ arr[b];
        arr[b] = arr[a] ^ arr[b];
        arr[a] = arr[a] ^ arr[b];
    }

}
