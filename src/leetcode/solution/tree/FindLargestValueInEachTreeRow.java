package leetcode.solution.tree;

import leetcode.structure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 515. Find Largest Value in Each Tree Row
 */
public class FindLargestValueInEachTreeRow {

    public static void main(String[] args) {
        Integer[] array = {1, 3, 2, 5, 3, null, 9};
        TreeNode root = TreeNode.constructTree(array);
        FindLargestValueInEachTreeRowDFSSolution dfsSolution = new FindLargestValueInEachTreeRowDFSSolution();
        List<Integer> ans = dfsSolution.largestValues(root);
        System.out.println(ans);

        FindLargestValueInEachTreeRowBFSSolution bfsSolution = new FindLargestValueInEachTreeRowBFSSolution();
        ans = bfsSolution.largestValues(root);
        System.out.println(ans);
    }


}

/**
 * @Description: DFS
 * @Author: Guanchen Zhao
 * @Date: 2022/5/18
 */
class FindLargestValueInEachTreeRowDFSSolution {

    private List<Integer> ans;

    public List<Integer> largestValues(TreeNode root) {
        ans = new ArrayList<>();
        dfs(root, 0);
        return ans;
    }

    private void dfs(TreeNode root, Integer level) {
        if (root == null) {
            return;
        }
        if (ans.size() <= level) {
            ans.add(root.val);
        } else {
            ans.set(level, Math.max(ans.get(level), root.val));
        }

        dfs(root.left, level + 1);
        dfs(root.right, level + 1);
    }

}

/**
 * @Description: BFS
 * @Author: Guanchen Zhao
 * @Date: 2022/5/18
 */
class FindLargestValueInEachTreeRowBFSSolution {

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            int currentMax = queue.peek().val;
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();

                currentMax = Math.max(currentMax, curr.val);

                if (curr.left != null) {
                    queue.add(curr.left);
                }
                if (curr.right != null) {
                    queue.add(curr.right);
                }
            }

            ans.add(currentMax);
        }
        return ans;
    }
}

