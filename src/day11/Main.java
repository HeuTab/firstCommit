package day11;

import javax.sound.midi.Soundbank;
import java.awt.font.ImageGraphicAttribute;
import java.time.chrono.IsoChronology;
import java.util.*;
import java.util.concurrent.CountDownLatch;

/**
 * @author zhougy
 * @create 2022-02-28 10:02
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
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(6);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(4);
        ListNode node6 = new ListNode(5);
        ListNode node7 = new ListNode(6);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        ListNode head = reverseList(node1);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

    public static ListNode reverseList(ListNode head) {
//        Stack<Integer> stack = new Stack<Integer>();
//        ListNode p1 = head;
//        ListNode p2 = head;
//        while (p1 != null) {
//            stack.push(p1.val);
//            p1 = p1.next;
//        }
//        while (p2!=null){
//            int i = stack.pop();
//            p2.val = i;
//            p2 = p2.next;
//        }
//        return head;

        if (head == null || head.next == null)
            return head;
        ListNode pre = null;
        ListNode curr = head;
        ListNode next = null;
        while (curr!=null){
            next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }

    public static ListNode removeElements(ListNode head, int val) {
        if (head == null)
            return null;
        while (head != null && head.val == val) {
            head = head.next;
        }
        ListNode p = head;
        while (p != null && p.next != null) {
            if (p.next.val == val) {
                p.next = p.next.next;
            } else {
                p = p.next;
            }
        }
        return head;
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode first = head;
        while (l1 != null && l2 != null) {
            if (l1.val >= l2.val) {
                head.next = l2;
                head = l2;
                l2 = l2.next;
            } else {
                head.next = l1;
                head = l1;
                l1 = l1.next;
            }
        }
        while (l1 != null) {
            head.next = l1;
            head = l1;
            l1 = l1.next;
        }
        while (l2 != null) {
            head.next = l2;
            head = l2;
            l2 = l2.next;
        }
        return first.next;
    }

    public static int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] != 0) {
                    int i1 = floodFill(grid, i, j, 0);
                    if (i1 > max)
                        max = i1;
                }
            }
        }
        return max;
    }

    public static int floodFill(int[][] image, int sr, int sc, int newColor) {
        int count = 0;
        int[] dx = {1, 0, 0, -1};
        int[] dy = {0, 1, -1, 0};
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{sr, sc});
        image[sr][sc] = newColor;
        count++;
        while (!queue.isEmpty()) {
            int[] a = queue.poll();
            int x = a[0];
            int y = a[1];
            for (int j = 0; j < 4; j++) {
                x = a[0] + dx[j];
                y = a[1] + dy[j];
                if (x >= 0 && x < image.length && y >= 0 && y < image[0].length && image[x][y] == 1) {
                    queue.add(new int[]{x, y});
                    image[x][y] = newColor;
                    count++;
                }
            }
        }
        return count;
    }

    public static boolean checkInclusion(String s1, String s2) {
        int l1 = s1.length();
        int l2 = s2.length();
        if (l1 > l2)
            return false;
        int[] a = new int[26];
        int[] b = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            a[s1.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s1.length(); i++) {
            b[s2.charAt(i) - 'a']++;
        }
        if (Arrays.equals(a, b))
            return true;
        for (int i = 1; i <= l2 - l1; i++) {
            b[s2.charAt(i + s1.length() - 1) - 'a']++;
            b[s2.charAt(i - 1) - 'a']--;
            if (Arrays.equals(a, b))
                return true;
        }
        return false;
    }

//    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
//        int[] dx = {1, 0, 0, -1};
//        int[] dy = {0, 1, -1, 0};
//        int i = image[sr][sc];
//        if (i == newColor)
//            return image;
//        Queue<int[]> queue = new LinkedList<>();
//        queue.add(new int[]{sr, sc});
//        while (!queue.isEmpty()) {
//            int[] a = queue.poll();
//            int x = a[0];
//            int y = a[1];
//            image[x][y] = newColor;
//            for (int j = 0; j < 4; j++) {
//                x = a[0] + dx[j];
//                y = a[1] + dy[j];
//                if (x >= 0 && x < image.length && y >= 0 && y < image[0].length && image[x][y] == i) {
//                    queue.add(new int[]{x, y});
//                }
//            }
//        }
//        return image;
//    }

}
