package day12;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.function.DoublePredicate;
import java.util.zip.CheckedOutputStream;

/**
 * @author zhougy
 * @create 2022-03-01 8:53
 */
public class Main {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
//        TreeNode treeNode1 = new TreeNode(1);
//        TreeNode treeNode2 = new TreeNode(2);
//        TreeNode treeNode3 = new TreeNode(3);
//        TreeNode treeNode4 = new TreeNode(4);
//        TreeNode treeNode5 = new TreeNode(5);
//        TreeNode treeNode6 = new TreeNode(6);
//        TreeNode treeNode7 = new TreeNode(7);
//        treeNode1.left = treeNode2;
//        treeNode1.right = treeNode3;
//        treeNode2.left = treeNode4;
//        treeNode2.right = treeNode5;
//        treeNode3.left = treeNode6;
//        treeNode3.right = treeNode7;
//        System.out.println(maxDepth(treeNode1));
//        int[] a = {1, 2, 3, 4, 5};
//        System.out.println(maxProfit(a));
        System.out.println(getRow(1));
    }

    public static List<Integer> getRow(int rowIndex) {
        List<List<Integer>> lists = generate(rowIndex+1);
        return lists.get(rowIndex);
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i)
                    list.add(1);
                else
                    list.add(lists.get(i - 1).get(j-1)+lists.get(i - 1).get(j));
            }
            lists.add(list);
        }
        return lists;
    }

    public static int maxProfit(int[] prices) {
        int[] dp = new int[prices.length];
        dp[0] = 0;
        int count = 0;
        for (int i = 1; i < dp.length; i++) {
            dp[i] = prices[i] > prices[i - 1] ? dp[i - 1] + (prices[i] - prices[i - 1]) : 0;
            if (dp[i] == 0 && dp[i - 1] != 0)
                count += dp[i - 1];
        }
        count += dp[dp.length - 1];
        return count;
    }

    public static boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return targetSum == root.val;
        }
        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }

    public static TreeNode invertTree(TreeNode root) {
        if (root == null)
            return null;
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.right = left;
        root.left = right;
        return root;
    }

    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = maxDepth(root.left);
        int rightHeight = maxDepth(root.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }

//    public static List<List<Integer>> levelOrder(TreeNode root) {
//        if (root == null)
//            return null;
//    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        // 迭代法（需要借助一个显式的栈）
        Stack<TreeNode> stk = new Stack<TreeNode>();
        List<Integer> list = new ArrayList<Integer>();
        // 只要节点不为空，或者 栈不为空即可进入循环
        while (root != null || !stk.isEmpty()) {
            // 先遍历到最后
            while (root != null) {
                stk.push(root);
                root = root.left;
            }
            root = stk.pop();
            list.add(root.val);
            root = root.right;
        }

        return list;
    }

    public static boolean isValid(String s) {
        if (s.length() == 0)
            return false;
        if (s.charAt(0) == ')' || s.charAt(0) == ']' || s.charAt(0) == '}')
            return false;
        Stack<Character> stack = new Stack<>();
        boolean flag = true;
        char[] chars = s.toCharArray();
        for (char i : chars) {
            if (i == '(' || i == '{' || i == '[')
                stack.push(i);
            else {
                if (stack.isEmpty()) {
                    flag = false;
                    break;
                }
                char c = stack.pop();
                if (i == ')' && c != '(') {
                    flag = false;
                    break;
                } else if (i == ']' && c != '[') {
                    flag = false;
                    break;
                } else if (i == '}' && c != '{') {
                    flag = false;
                    break;
                }
            }
        }
        if (!stack.isEmpty())
            flag = false;
        return flag;
    }

}

class MyQueue {

    Stack<Integer> stack1;
    Stack<Integer> stack2;

    public MyQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void push(int x) {
        stack1.push(x);
    }

    public int pop() {
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        int i = stack2.pop();
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
        return i;
    }

    public int peek() {
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        int i = stack2.pop();
        stack2.push(i);
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
        return i;
    }

    public boolean empty() {
        return stack1.isEmpty();
    }
}
