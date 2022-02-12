package day03;

//import java.awt.*;

import javax.swing.tree.TreeNode;
import java.util.*;
import java.lang.*;

/**
 * @author zhougy
 * @create 2022-02-07 14:28
 */
public class solution {

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
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        ListNode n = swapPairs(node1);
        while (n!=null){
            System.out.println(n.val);
            n = n.next;
        }
    }

    public static ListNode swapPairs(ListNode head) {
        ListNode root = head;
        ListNode res = head.next;
        while (res!=null){
            head.next = res.next;
            res.next = head;
            head = head.next;
            res = head.next;
        }
        return root;
    }


}
