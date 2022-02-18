package day06;

import java.util.Stack;

/**
 * @author zhougy
 * @create 2022-02-18 14:49
 */
public class CQueue {

    Stack stack1;
    Stack stack2;

    public static void main(String[] args) {
        CQueue cQueue = new CQueue();
        cQueue.appendTail(1);
        cQueue.print();
    }

    public CQueue() {
        stack1 = new Stack();
        stack2 = new Stack();
    }

    public void appendTail(int value) {
        stack1.push(value);
    }

    public int deleteHead() {
//        while (stack1!=null){
//            stack2.push(stack1.pop());
//        }
//        int a = stack2.
        return 0;
    }

    public void print() {
        while (stack1 != null) {
            System.out.print(stack1.peek() + " ");
        }
    }

}
