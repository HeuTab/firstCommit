package day09;

import java.io.BufferedReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

/**
 * @author zhougy
 * @create 2022-02-21 8:20
 */
public class Main {

    public static void main(String[] args) {
        int[] a = {2, 3, 1, 1, 4};
        System.out.println(jump(a));
    }

    public static int jump(int[] nums) {
        int position = nums.length - 1;
        int steps = 0;
        while (position > 0) {
            for (int i = 0; i < position; i++) {
                if (i + nums[i] >= position) {
                    position = i;
                    steps++;
                    break;
                }
            }
        }
        return steps;
    }

//    public static int jump(int[] nums) {
//        if (nums.length == 1)
//            return 0;
//        int count = 0;
//        int[][] dp = new int[nums.length][nums.length];
//        for (int i = nums.length - 2; i >= 0; i--) {
//            count = nums[i];
//            int j = i;
//            while (j < nums.length - 1 && count > 0) {
//                j++;
//                dp[i][j] = 1;
//                count--;
//            }
//            if (count == 0 && j < nums.length - 1) {
//                while (j < nums.length - 1) {
//                    j++;
//                    int min = 0;
//                    int flag = 0;
//                    for (int k = i + 1; k < j; k++) {
//                        if (dp[i][k] != 0 && dp[k][j] != 0) {
//                            min = flag == 0 ? dp[i][k] + dp[k][j] : Math.min(dp[i][k] + dp[k][j], min);
//                            flag++;
//                        }
//                    }
//                    dp[i][j] = min;
//                }
//            }
//        }
//        return dp[0][nums.length - 1];
//    }

    public static boolean canJump(int[] nums) {
        if (nums.length == 1)
            return true;
        boolean flag = false;
        int max = nums[0];
        for (int i = 1; i <= max; i++) {
            max = Math.max(i + nums[i], max);
            if (max >= nums.length - 1) {
                flag = true;
                break;
            }
        }
        return flag;
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i)
                    list.add(1);
                else
                    list.add(lists.get(i - 1).get(j - 1) + lists.get(i - 1).get(j));
            }
            lists.add(list);
        }
        return lists;
    }

    public static int[][] matrixReshape(int[][] mat, int r, int c) {
        if (mat.length * mat[0].length != r * c) {
            return mat;
        }
        int[][] matlab = new int[r][c];
        int pointr = 0;
        int pointc = 0;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                matlab[pointr][pointc] = mat[i][j];
                if (pointc == c - 1) {
                    pointc = 0;
                    pointr += 1;
                    continue;
                }
                pointc++;
            }
        }
        return matlab;
    }

    public static String reverseWords(String s) {
        int left = 0;
        int right = 0;
        while (left < s.length() && right < s.length()) {
            while (s.charAt(right) != ' ') {
                if (right < s.length() - 1)
                    right++;
                else {
                    right++;
                    break;
                }
            }
            String s1 = s.substring(0, left);
            String s2 = s.substring(left, right);
            String s3 = s.substring(right, s.length());
            char[] chars = s2.toCharArray();
            reverseString(chars);
            String ss = "";
            for (char c : chars) {
                ss += c;
            }
            s = s1.concat(ss);
            s = s.concat(s3);
            left = right + 1;
            while (left < s.length() && s.charAt(left) == ' ') {
                left++;
            }
            right = left;
        }
        return s;
    }

    public static void reverse(String s, int left, int right) {
        String s1 = s.substring(0, left);
        String s2 = s.substring(left, right);
        String s3 = s.substring(right, s.length());
        char[] chars = s2.toCharArray();
        reverseString(chars);
        String ss = "";
        for (char c : chars) {
            ss += c;
        }
        s = s1.concat(ss);
        s = s.concat(s3);
    }

    public static void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;
        while (left < right) {
            swap(s, left, right);
            left++;
            right--;
        }
    }

    public static void swap(char[] s, int a, int b) {
        char c;
        c = s[a];
        s[a] = s[b];
        s[b] = c;
    }

}
