package solution.Tree;

import Structure.TreeNode;
import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 1022. Sum of Root To Leaf Binary Numbers
 */
public class SumOfRootToLeafBinaryNumbers {

    public static void main(String[] args) {
        Integer[] pArray = {1, null, 0, 1};
        TreeNode p = TreeNode.constructTree(pArray);
        System.out.println(sumRootToLeaf(p));
        System.out.println(sumRootToLeafIterator(p));

    }

    private static int rootToLeaf = 0;

    public static void preorder(TreeNode r, int currNumber) {
        if (r != null) {
            currNumber = (currNumber << 1) | r.val;
            // if it's a leaf, update root-to-leaf sum
            if (r.left == null && r.right == null) {
                rootToLeaf += currNumber;
            }
            preorder(r.left, currNumber);
            preorder(r.right, currNumber);
        }
    }

    public static int sumRootToLeaf(TreeNode root) {
        preorder(root, 0);
        return rootToLeaf;
    }


    public static int sumRootToLeafIterator(TreeNode root) {
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(root, 0));

        int sum = 0;

        while (!queue.isEmpty()) {
            Pair<TreeNode, Integer> curPair = queue.poll();
            TreeNode curNode = curPair.getKey();
            Integer currNumber = curPair.getValue();
            currNumber = (currNumber << 1) | curNode.val;
            // if it's a leaf, update root-to-leaf sum
            if (curNode.left == null && curNode.right == null) {
                sum += currNumber;
            }

            if (curNode.left != null) {
                queue.add(new Pair<>(curNode.left, currNumber));
            }
            if (curNode.right != null) {
                queue.add(new Pair<>(curNode.right, currNumber));
            }
        }
        return sum;
    }

}
