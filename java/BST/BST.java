package BST;

import basicDS.MyQueue;
import basicDS.MyStack;

import java.util.Comparator;
import java.util.Queue;
import java.util.Stack;

public class BST {
    static class Node {
        private int value;
        private Node left;
        private Node right;

        public Node(int value) {
            this.value = value;
            this.left = this.right = null;
        }

        public void visit() {
            System.out.println(this.value);
        }

    }

    public void insert(Node root, int value) {
        if (value < root.value) {
            if (root.left != null) insert(root.left, value);
            else root.left = new Node(value);
        }
        if (value > root.value) {
            if (root.right != null) insert(root.right, value);
            else root.right = new Node(value);
        }
    }

    public void iterInsert(Node root, int value) {
        Node curr = root;
        Node parent = root;
        while (curr != null) {
            parent = curr;
            if (value < curr.value) curr = curr.left;
            else if (value > curr.value) curr = curr.right;
            else System.err.println(value + " is already present");
        }
        if (value < parent.value) parent.left = new Node(value);
        else parent.right = new Node(value);
    }

    public void preOrder(Node root) {
        if (root != null) {
            System.out.println(root.value);
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    public void inOrder(Node root) {
        if (root != null) {
            inOrder(root.left);
            System.out.println(root.value);
            inOrder(root.right);
        }
    }

    public void postOrder(Node root) {
        if (root != null) {
            postOrder(root.left);
            postOrder(root.right);
            System.out.println(root.value);
        }
    }

    public void levelOrder(Node root) {
        MyQueue<Node> q = new MyQueue<>();
        if (root != null) q.enqueue(root);
        while (!q.isEmpty()) {
            Node curr = q.dequeue();
            curr.visit();
            if (curr.left != null) q.enqueue(curr.left);
            if (curr.right != null) q.enqueue(curr.right);
        }
    }

    public void iterPreOrder(Node root) {
        MyStack<Node> s = new MyStack<>();
        s.push(root);

        while (!s.isEmpty()) {
            root = s.pop();
            root.visit();
            if (root.right != null) s.push(root.right);
            if (root.left != null) s.push(root.left);
        }
    }

    public void iterInOrder(Node root) {
        Stack<Node> s = new Stack<>();
        s.push(root);

        while (!s.isEmpty()) {
            root = s.pop();
            while (root != null) {
                s.push(root);
                root = root.left;
            }

            if (!s.isEmpty()) {
                root = s.pop();
                root.visit();
                s.push(root.right);
            }
        }
    }

    public void iterPostOrder(Node root) {
        MyStack<Node> sn = new MyStack<>();
        MyStack<Boolean> sb = new MyStack<>();
        Boolean f;

        if (root != null) {
            sn.push(root);
            sb.push(true);
        }

        while (!sn.isEmpty()) {
            root = sn.pop();
            f = sb.pop();
            if (f == true) {
                sn.push(root);
                sb.push(false);
                if (root.right != null) {
                    sn.push(root.right);
                    sb.push(true);
                }
                if (root.left != null) {
                    sn.push(root.left);
                    sb.push(true);
                }
            } else {
                root.visit();
            }
        }
    }

    public static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    public static void main(String[] args) {
        Node root = new Node(5);
        BST bst = new BST();
        bst.insert(root, 3);
        bst.insert(root, 2);
        bst.insert(root, 4);
        bst.insert(root, 1);
        bst.insert(root, 8);
        bst.insert(root, 7);
        bst.insert(root, 6);
        System.out.println("\n- Pre order: ");
        bst.preOrder(root);
        System.out.println("\n- In order: ");
        bst.inOrder(root);
        System.out.println("\n- Post order: ");
        bst.postOrder(root);
        System.out.println("\n- Level order: ");
        bst.levelOrder(root);
        System.out.println("\n- Pre order iterative: ");
        bst.iterPreOrder(root);
        System.out.println("\n- In order iterative: ");
        bst.iterInOrder(root);
        System.out.println("\n- less: " + less(2, 3));

        System.out.println("\n- Post order iterative: ");
        bst.iterPostOrder(root);
    }
}
