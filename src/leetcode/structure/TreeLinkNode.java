package leetcode.structure;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Definition for a list node.
 */
public class TreeLinkNode {

    public int val;
    public TreeLinkNode left;
    public TreeLinkNode right;
    public TreeLinkNode next;


    public TreeLinkNode() {
    }

    public TreeLinkNode(int val) {
        this.val = val;
    }

    public TreeLinkNode(int val, TreeLinkNode next) {
        this.val = val;
        this.next = next;
    }


    /**
     * generate by array
     *
     * @param array
     * @return
     */
    public static TreeLinkNode constructTree(Integer[] array) {
        if (array == null || array.length == 0 || array[0] == null) {
            return null;
        }

        int index = 0;
        int length = array.length;

        TreeLinkNode root = new TreeLinkNode(array[0]);
        Deque<TreeLinkNode> nodeQueue = new LinkedList<>();
        nodeQueue.offer(root);
        TreeLinkNode currNode;
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
                currNode.left = new TreeLinkNode(leftChild);
                nodeQueue.offer(currNode.left);
            }
            index++;
            if (index >= length) {
                return root;
            }
            Integer rightChild = array[index];
            if (rightChild != null) {
                currNode.right = new TreeLinkNode(rightChild);
                nodeQueue.offer(currNode.right);
            }
        }

        return root;
    }

}
