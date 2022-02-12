package day02;

/**
 * @author zhougy
 * @create 2022-01-29 16:18
 */
public class tree {

    public static class Node{
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
    }
}
