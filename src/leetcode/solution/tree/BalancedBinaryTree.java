package leetcode.solution.tree;

import leetcode.structure.TreeNode;

/**
 * 101. Symmetric Tree
 * Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).
 */
public class BalancedBinaryTree {

    public static void main(String[] args) {
        System.out.println(Math.pow(2, 1));
        Integer[] array = {3, 9, 20, null, null, 15, 7};
        TreeNode root = TreeNode.constructTree(array);
        System.out.println(isBalanced(root));
//        System.out.println(isBalancedIterator(root));

    }

    private static boolean res = true;

    public static boolean isBalanced(TreeNode root) {
        if (root == null) {
            return false;
        }
        helper(root);
        return res;
    }

    public static int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (!res) {
            return -1;
        }
        int left = helper(root.left);
        int right = helper(root.right);

        if (Math.abs(left - right) > 1) {
            res = false;
        }

        return Math.max(left, right) + 1;

    }

//
//    public static boolean isBalancedIterator(TreeNode root) {
//        if (root == null) {
//            return true;
//        }
//
//        Queue<TreeNode> queue = new LinkedList<>();
//
//        List<TreeNode> list;
//        queue.add(root);
//        TreeNode node = null;
//        int minDepth = 0;
//        int depth = 0;
//
//        while (!queue.isEmpty()) {
//            list = new ArrayList<>();
//            // 本层个数
//            int num = 0;
//            while (!queue.isEmpty()) {
//                node = queue.poll();
//                num++;
//                if (node.left != null) {
//                    list.add(node.left);
//                }
//                if (node.right != null) {
//                    list.add(node.right);
//                }
//            }
//            // 找到第一个
//            if (num >= Math.pow(2, depth) - 1) {
//                System.out.println("sss");
//                minDepth++;
//            }
//            // 将子节点加入队列
//            queue.addAll(list);
//
//
//            if (depth > minDepth + 1) {
//                System.out.println("b");
//                break;
//            }
//            depth++;
//
//        }
//
//
////
////        System.out.println("depth:" + depth);
////        System.out.println("min:" + minDepth);
//
//        return depth - minDepth <= 1;
//    }


}
