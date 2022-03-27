package day14;

import day01.merge;
import sun.reflect.generics.tree.Tree;

import java.util.*;

/**
 * @author zhougy
 * @create 2022-03-03 9:26
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

    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    public static void main(String[] args) {

    }

    public static void flatten(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        TreeNode treeNode;
        while (!stack.isEmpty()) {
            treeNode = stack.pop();
            if (treeNode.right!=null){
                stack.push(treeNode.right);
            }
            if (treeNode.left!=null){
                stack.push(treeNode.left);
            }
            if (stack.isEmpty())
                treeNode.right = null;
            else
                treeNode.right = stack.peek();
        }
    }

    public static int singleNumber(int[] nums) {
        int ls = nums[0];
        for (int i = 1; i < nums.length; i++) {
            ls ^= nums[i];
        }
        return ls;
    }

    public static Node connect(Node root) {
        if (root == null)
            return null;
        Queue<merge> queue = new ArrayDeque<>();
        merge merge = new merge(root, 0);
        queue.add(merge);
        while (!queue.isEmpty()) {
            merge = queue.poll();
            if (queue.isEmpty() || queue.peek().i != merge.i) {
                merge.node.next = null;
            } else {
                merge.node.next = queue.peek().node;
            }
            if (merge.node.left != null) {
                queue.add(new merge(merge.node.left, merge.i + 1));
            }
            if (merge.node.right != null) {
                queue.add(new merge(merge.node.right, merge.i + 1));
            }
        }
        return root;
    }

    public static class merge {
        Node node;
        Integer i;

        public merge() {
        }

        public merge(Node node, Integer i) {
            this.node = node;
            this.i = i;
        }
    }

    public static TreeNode searchBST(TreeNode root, int val) {
        Queue<TreeNode> treeNodeQueue = new LinkedList<>();
        treeNodeQueue.add(root);
        while (!treeNodeQueue.isEmpty()) {
            TreeNode treeNode = treeNodeQueue.poll();
            if (treeNode.val == val) {
                return treeNode;
            } else {
                if (treeNode.left != null)
                    treeNodeQueue.add(treeNode.left);
                if (treeNode.right != null)
                    treeNodeQueue.add(treeNode.right);
            }
        }
        return null;
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        Queue<la> queue = new LinkedList<>();
        queue.add(new la(root, 0));
        List<List<Integer>> lists = new LinkedList<>();
        while (!queue.isEmpty()) {
            List<Integer> list = new LinkedList<>();
            la la = queue.poll();
            if (la.treeNode == null)
                continue;
            list.add(la.treeNode.val);
            queue.add(new la(la.treeNode.left, la.i + 1));
            queue.add(new la(la.treeNode.right, la.i + 1));
            while (queue.peek().i == la.i) {
                la = queue.poll();
                if (la.treeNode == null)
                    continue;
                list.add(la.treeNode.val);
                queue.add(new la(la.treeNode.left, la.i + 1));
                queue.add(new la(la.treeNode.right, la.i + 1));
            }
            lists.add(list);
        }
        return lists;
    }

    public static class la {
        TreeNode treeNode;
        Integer i;

        public la() {
        }

        public la(TreeNode treeNode, Integer i) {
            this.treeNode = treeNode;
            this.i = i;
        }
    }

    public static boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode first = queue.poll();
            TreeNode second = queue.poll();
            if (first == null && second == null)
                continue;
            if ((first != null && second == null) || (first == null && second != null) || (first.val != second.val))
                return false;

            if (first == root && second == root) {
                queue.add(first.left);
                queue.add(second.right);
                continue;
            }
            queue.add(first.left);
            queue.add(second.right);

            queue.add(first.right);
            queue.add(second.left);
        }
        return true;
    }

    public static TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null)
            return root2;
        if (root2 == null)
            return root1;
        TreeNode treeNode = new TreeNode(root1.val + root2.val);
        treeNode.left = mergeTrees(root1.left, root2.left);
        treeNode.right = mergeTrees(root1.right, root2.right);
        return treeNode;
    }

}
