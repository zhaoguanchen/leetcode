package leetcode.solution.tree;

import javafx.util.Pair;
import leetcode.structure.TreeNode;

/**
 * 2265. Count Nodes Equal to Average of Subtree
 */
public class CountNodesEqualToAverageOfSubtree {

    public static void main(String[] args) {

        Integer[] arr = {4, 8, 5, 0, 1, null, 6};
        TreeNode root = TreeNode.constructTree(arr);
        CountNodesEqualToAverageOfSubtree count = new CountNodesEqualToAverageOfSubtree();
        int ans = count.averageOfSubtree(root);
        System.out.println(ans);
    }


    private int count;

    public int averageOfSubtree(TreeNode root) {
        count = 0;
        helper(root);
        return count;
    }

     /**
      * @Description: DFS | Postorder traverse
      * @Author: Guanchen Zhao
      * @Date: 2022/5/9  
      */
    private Pair<Integer, Integer> helper(TreeNode root) {
        if (root == null) {
            return new Pair<>(0, 0);
        }

        // calculate left subtree
        Pair<Integer, Integer> left = helper(root.left);
        int leftSum = left.getKey();
        int leftCount = left.getValue();
        // calculate right subtree
        Pair<Integer, Integer> right = helper(root.right);
        int rightSum = right.getKey();
        int rightCount = right.getValue();

        // sum
        int sum = leftSum + rightSum + root.val;
        int count = leftCount + rightCount + 1;
        // get one of result
        if (sum / count == root.val) {
            count++;
        }
        return new Pair<>(sum, count);
    }

}
