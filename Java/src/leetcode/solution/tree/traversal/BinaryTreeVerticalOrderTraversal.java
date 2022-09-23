package leetcode.solution.tree.traversal;

import javafx.util.Pair;
import leetcode.structure.TreeNode;

import java.util.*;

/**
 * 314. Binary Tree Vertical Order Traversal
 */
public class BinaryTreeVerticalOrderTraversal {

    public static void main(String[] args) {
        Integer[] pArray = {3, 9, 8, 4, 0, 1, 7, null, null, null, 2, 5};
        TreeNode p = TreeNode.constructTree(pArray);
        BinaryTreeVerticalOrderTraversal traversal = new BinaryTreeVerticalOrderTraversal();

        List<List<Integer>> ans = traversal.verticalOrder(p);
        System.out.println(ans);
//        Output: [[4],[9,5],[3,0,1],[8,2],[7]]

    }

    public List<List<Integer>> verticalOrder(TreeNode root) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(root, 0));

        while (!queue.isEmpty()) {
            Pair<TreeNode, Integer> pair = queue.poll();
            TreeNode node = pair.getKey();
            if (node == null) {
                continue;
            }
            int col = pair.getValue();
            if (!map.containsKey(col)) {
                map.put(col, new ArrayList<>());
            }

            map.get(col).add(node.val);
            queue.add(new Pair<>(node.left, col - 1));
            queue.add(new Pair<>(node.right, col + 1));

        }
        // sort by key
        List<Integer> list = new ArrayList<>(map.keySet());
        Collections.sort(list);
        // generate result
        List<List<Integer>> ans = new ArrayList<>();
        for (int i : list) {
            ans.add(map.get(i));
        }

        return ans;
    }

}
