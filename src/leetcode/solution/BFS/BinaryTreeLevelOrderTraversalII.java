package leetcode.solution.BFS;

import leetcode.Structure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 107. BinaryTreeLevelOrderTraversalII
 */
public class BinaryTreeLevelOrderTraversalII {

    public static void main(String[] args) {
        Integer[] pArray = {3, 9, 20, null, null, 15, 7};
        TreeNode p = TreeNode.constructTree(pArray);
        System.out.println(levelOrderBottom(p));

    }

    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        // LinkedList便于往列表头部添加数据
        LinkedList<List<Integer>> result = new LinkedList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();
                list.add(current.val);
                if (current.left != null) queue.add(current.left);
                if (current.right != null) queue.add(current.right);
            }
            // 将结果加入头部，形成倒序
            result.addFirst(list);
        }
        return result;

    }
}
