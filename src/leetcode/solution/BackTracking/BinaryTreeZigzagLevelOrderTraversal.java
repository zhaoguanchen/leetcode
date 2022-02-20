package leetcode.solution.BackTracking;

import leetcode.Structure.TreeNode;

import java.util.*;

/**
 * 103. Binary Tree Zigzag Level Order Traversal
 * Given the root of a binary tree, return the zigzag level order traversal of its nodes' values. (i.e., from left to right, then right to left for the next level and alternate between).
 */
public class BinaryTreeZigzagLevelOrderTraversal {

    public static void main(String[] args) {
        Integer[] array = {3, 9, 20, null, null, 15, 7};
//        Integer[] array = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};

        TreeNode root = TreeNode.constructTree(array);
        System.out.println(zigzagLevelOrder(root));
        System.out.println(zigzagLevelOrderDFS(root));
        System.out.println(zigzagLevelOrderNormal(root));
    }

    /**
     * BFS方式
     */
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        // 当前层是否从左到右， 以此判断左右子节点的添加顺序
        boolean currentOrder = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> levelList = new ArrayList<>();
            Deque<TreeNode> temp = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode currentNode = queue.pollLast();
                levelList.add(currentNode.val);
                if (currentOrder) {
                    if (currentNode.left != null) {
                        temp.add(currentNode.left);
                    }
                    if (currentNode.right != null) {
                        temp.add(currentNode.right);
                    }
                } else {
                    if (currentNode.right != null) {
                        temp.add(currentNode.right);
                    }
                    if (currentNode.left != null) {
                        temp.add(currentNode.left);
                    }
                }


            }

            queue.addAll(temp);
            currentOrder = !currentOrder;

            result.add(levelList);
        }
        return result;
    }

    /**
     * 常规BFS
     * 层序遍历改进
     *
     * @param root
     * @return
     */
    public static List<List<Integer>> zigzagLevelOrderNormal(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        // 当前层是否从左到右， 以此判断该层节点的添加顺序
        boolean currentOrder = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            LinkedList<Integer> levelList = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode currentNode = queue.poll();
                if (currentOrder) {
                    levelList.add(currentNode.val);
                } else {
                    levelList.addFirst(currentNode.val);
                }
                if (currentNode.left != null) {
                    queue.add(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.add(currentNode.right);
                }

            }
            currentOrder = !currentOrder;
            result.add(levelList);
        }
        return result;
    }


    /**
     * DFS方式
     */
    private static final List<List<Integer>> result = new LinkedList<>();

    public static List<List<Integer>> zigzagLevelOrderDFS(TreeNode root) {
        if (root == null) {
            return result;
        }
        helper(root, 0);
        return result;
    }

    public static void helper(TreeNode root, Integer level) {
        if (root == null) {
            return;
        }
        List<Integer> currentLevelList;
        if (result.size() <= level) {
            currentLevelList = new LinkedList<>();
            result.add(level, currentLevelList);
        } else {
            currentLevelList = result.get(level);
        }
        if (currentLevelList.size() == 0) {
            currentLevelList.add(root.val);
        } else {
            // 偶数层为正向，从左到右
            // 奇数层为负向，从右到左
            if (level % 2 == 0) {
                currentLevelList.add(root.val);
            } else {
                currentLevelList.add(0, root.val);
            }
        }
        helper(root.left, level + 1);
        helper(root.right, level + 1);

    }

}