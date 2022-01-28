package day02;

import java.util.Random;

/**
 * @author zhougy
 * @create 2022-01-27 9:25
 */
public class lian {

    public static class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public static void printNode(Node p) {
        while (p != null) {
            System.out.print(p.value + " ");
            p = p.next;
        }
    }

    public static Node reverseList(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node reHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return reHead;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        Node p;
        p = head;
        for (int i = 0; i < 4; i++) {
            Node node = new Node(i + 2);
            p.next = node;
            p = node;
        }
        printNode(head);
        printNode(reverseList(head));
    }

}
