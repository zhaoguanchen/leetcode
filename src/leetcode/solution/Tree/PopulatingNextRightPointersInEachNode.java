package leetcode.solution.Tree;

import leetcode.Structure.Node;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 116. Populating Next Right Pointers in Each Node
 */
public class PopulatingNextRightPointersInEachNode {

    public static void main(String[] args) {
        Integer[] pArray = {1, 2, 3, 4, 5, 6, 7};
        Node p = Node.constructTree(pArray);
        System.out.println(connect(p));

    }

    public static Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node current = queue.poll();
                if (current == null) {
                    continue;
                }
                if (i < size - 1) {
                    current.next = queue.peek();
                } else {
                    current.next = null;
                }

                if (current.left != null) {
                    queue.add(current.left);
                }
                if (current.right != null) {
                    queue.add(current.right);
                }
            }
        }

        return root;
    }


    public static Node connect2(Node root) {
        if (root == null) {
            return null;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            if (current.left == null || current.right == null) {
                continue;
            }
            current.left.next = current.right;
            if (current.next != null) {
                current.right.next = current.next.left;
            }

            queue.add(current.left);
            queue.add(current.right);
        }

        return root;
    }

    public static Node connect3(Node root) {
        if (root == null) {
            return null;
        }

        Node rootLeft = root;

        Node current = rootLeft;

        while (true) {
            if (current.left == null) {
                break;
            }

            current.left.next = current.right;

            if (current.next != null) {
                current.right.next = current.next.left;
            }
            if (current.next != null) {
                current = current.next;

            } else {
                rootLeft = rootLeft.left;
                current = rootLeft;
            }
        }
        return root;
    }
}
