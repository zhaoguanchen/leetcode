package leetcode.Structure;

import java.util.*;

/**
 * Definition for a binary tree node.
 */
public class TreeNode {

    public int val;
    public TreeNode left;

    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }


    /**
     * generate by array
     *
     * @param array
     * @return
     */
    public static TreeNode constructTree(Integer[] array) {
        if (array == null || array.length == 0 || array[0] == null) {
            return null;
        }

        int index = 0;
        int length = array.length;

        TreeNode root = new TreeNode(array[0]);
        Deque<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.offer(root);
        TreeNode currNode;
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
                currNode.left = new TreeNode(leftChild);
                nodeQueue.offer(currNode.left);
            }
            index++;
            if (index >= length) {
                return root;
            }
            Integer rightChild = array[index];
            if (rightChild != null) {
                currNode.right = new TreeNode(rightChild);
                nodeQueue.offer(currNode.right);
            }
        }

        return root;
    }


    public static List<Integer> print(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();

            if (current != null) {
                res.add(current.val);
            } else {
                res.add(null);
                continue;
            }

            if (current.left != null) {
                queue.add(current.left);
            } else {
                queue.add(null);
            }
            if (current.right != null) {
                queue.add(current.right);
            } else {
                queue.add(null);
            }

        }
        return res;

    }

}
