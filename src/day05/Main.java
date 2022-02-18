package day05;

/**
 * @author zhougy
 * @create 2022-02-13 19:11
 */
public class Main {

    public static void main(String[] args) {
        System.out.println(climbStairs(5));
    }

    public static int climbStairs(int n) {
        if (n == 1)
            return 1;
        if (n == 2)
            return 2;
        int p = 1;
        int q = 2;
        int r = p + q;
        for (int i = 3; i < n; i++) {
            p = q;
            q = r;
            r = p+q;
        }
        return r;
    }

//    public static int climbStairs(int n) {
//        if (n == 1)
//            return 1;
//        if (n == 2)
//            return 2;
//        int[] dp = new int[n];
//        dp[0] = 1;
//        dp[1] = 2;
//        int i = 2;
//        while (i != n) {
//            dp[i] = dp[i - 1] + dp[i-2];
//            i++;
//        }
//        return dp[n-1];
//    }

}
