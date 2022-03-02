package leetcode.solution.Tree;

import leetcode.Structure.NNode;

/**
 * 543. Diameter of Binary Tree
 */
public class DiameterOfNAryTree {

    public static void main(String[] args) {
        Integer[] pArray = {1, null, 3, 2, 4, null, 5, 6};
        NNode p = NNode.constructTree(pArray);
        System.out.println(diameter(p));

    }

    private static int max = 0;

    public static int diameter(NNode root) {
        helper(root);
        return max;
    }

    private static int helper(NNode root) {
        if (root == null) {
            return 0;
        }
        // 最大值
        int top1 = 0;
        // 次大值
        int top2 = 0;

        for (int i = 0; i < root.children.size(); i++) {
            int current = helper(root.children.get(i));
            // 值得注意的是，更新top1的同时，也要更新top2
            if (current > top1) {
                top2 = top1;
                top1 = current;
            } else if (current > top2) {
                top2 = current;
            }
        }

        int current = top1 + top2;
        // 记录最长直径
        max = Math.max(max, current);
        // 返回当前节点左子和右子中较长的路径长度，提供给上一节点
        return top1 + 1;

    }
}
