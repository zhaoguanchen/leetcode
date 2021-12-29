package Structure;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Definition for a list node.
 */
public class Node {

    public int val;
    public Node left;
    public Node right;
    public Node next;


    public Node() {
    }

    public Node(int val) {
        this.val = val;
    }

    public Node(int val, Node next) {
        this.val = val;
        this.next = next;
    }


    /**
     * generate by array
     *
     * @param array
     * @return
     */
    public static Node constructTree(Integer[] array) {
        if (array == null || array.length == 0 || array[0] == null) {
            return null;
        }

        int index = 0;
        int length = array.length;

        Node root = new Node(array[0]);
        Deque<Node> nodeQueue = new LinkedList<>();
        nodeQueue.offer(root);
        Node currNode;
        while (true) {
            index++;
            if (index >= length) {
                return root;
            }
            currNode = nodeQueue.poll();
            if (currNode == null) {
                break;
            }
            Integer leftChild = array[index];
            if (leftChild != null) {
                currNode.left = new Node(leftChild);
                nodeQueue.offer(currNode.left);
            }
            index++;
            if (index >= length) {
                return root;
            }
            Integer rightChild = array[index];
            if (rightChild != null) {
                currNode.right = new Node(rightChild);
                nodeQueue.offer(currNode.right);
            }
        }

        return root;
    }

}
