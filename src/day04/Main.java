package day04;

import java.beans.beancontext.BeanContext;
import java.util.Hashtable;

/**
 * @author zhougy
 * @create 2022-02-12 13:10
 */
public class Main {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
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
        node4.next = node2;
        System.out.println(detectCycle(node1).val);
    }

//    public static ListNode detectCycle(ListNode head) {
//        Hashtable<ListNode,Integer> hashtable = new Hashtable();
//        int count = 0;
//        while (head != null) {
//            if (hashtable.containsKey(head)) {
//                break;
//            }
//            hashtable.put(head,count);
//            count++;
//            head = head.next;
//        }
//        return head;
//    }

    public static ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        ListNode p = head;
        while (fast != null) {
            if (fast.next == null)
                return null;
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow)
                break;
        }
        if (fast != slow)
            return null;
        while (slow != p) {
            slow = slow.next;
            p = p.next;
        }
        return p;
    }

//    public static boolean hasCycle(ListNode head) {
//        Hashtable<Integer, ListNode> hashtable = new Hashtable<Integer, ListNode>();
//        boolean flag = false;
//        int count = 0;
//        while (head != null) {
//            if (hashtable.containsValue(head)) {
//                flag = true;
//                break;
//            }
//            hashtable.put(count, head);
//            count++;
//            head = head.next;
//        }
//        return flag;
//    }

//    public static boolean hasCycle(ListNode head) {
//        boolean flag = false;
//        ListNode kuai = head;
//        ListNode man = head;
//        while (kuai != null) {
//            if (kuai.next == null)
//                break;
//            kuai = kuai.next.next;
//            man = man.next;
//            if (kuai == man) {
//                flag = true;
//                break;
//            }
//        }
//        return flag;
//    }

}
