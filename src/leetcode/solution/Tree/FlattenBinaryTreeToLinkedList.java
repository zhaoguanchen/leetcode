package leetcode.solution.Tree;

import leetcode.structure.TreeNode;

/**
 * 226. Invert Binary Tree
 */
public class FlattenBinaryTreeToLinkedList {

    public static void main(String[] args) {
        Integer[] pArray = {1, 2, 3, 4, 5};
        TreeNode p = TreeNode.constructTree(pArray);
        flatten(p);

    }

    public static void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode cur = root;

        while (cur != null) {
            if (cur.left != null) {
                // 找到左子树的最右节点
                TreeNode leftRight = cur.left;
                while (leftRight.right != null) {
                    leftRight = leftRight.right;
                }

                // 将右子树接到最右节点
                leftRight.right = cur.right;
                // 将左子树移到右边
                cur.right = cur.left;
                cur.left = null;
                // 完成后该层只有右子树
            }
            // 操作下一节点，也就是原左子节点
            cur = cur.right;
        }


    }


    public static void flatten1(TreeNode root) {
        if (root == null) {
            return;
        }

        flatten1(root.left);
        flatten1(root.right);

        if (root.left != null) {
            // 找到左子树的最右节点
            TreeNode leftRight = root.left;
            while (leftRight.right != null) {
                leftRight = leftRight.right;
            }

            // 将右子树接到最右节点
            leftRight.right = root.right;
            // 将左子树移到右边
            root.right = root.left;
            root.left = null;
            // 完成后该层只有右子树
        }



    }

    private static void helper(TreeNode root) {
        // 到达叶子节点，返回
        if (root == null) {
            return;
        }


        // 递归子节点
        helper(root.left);
        helper(root.right);


    }
}
