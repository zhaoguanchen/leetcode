package leetcode.solution.tree.bst;

import leetcode.structure.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 173. Binary Search Tree Iterator
 */
public class BinarySearchTreeIterator {

    public static void main(String[] args) {
        Integer[] inorder = {7, 3, 15, null, null, 9, 20};
        TreeNode treeNode = TreeNode.constructTree(inorder);

        BSTIteratorII bSTIterator = new BSTIteratorII(treeNode);
        int ans = bSTIterator.next();    // return 3
        System.out.println(ans);
        bSTIterator.next();    // return 7
        bSTIterator.hasNext(); // return True
        bSTIterator.next();    // return 9
        bSTIterator.hasNext(); // return True
        ans = bSTIterator.next();    // return 15
        System.out.println(ans);
        bSTIterator.hasNext(); // return True
        bSTIterator.next();    // return 20
        bSTIterator.hasNext(); // return False

    }

}

/**
 * solution 1 -- using List
 *
 * Time complexity O(1)
 * Space complexity O(n)
 */
class BSTIterator {

    List<Integer> list;

    int index;

    public BSTIterator(TreeNode root) {
        list = new ArrayList<>();
        index = 0;
        construct(root);
    }


    private void construct(TreeNode root) {
        if (root == null) {
            return;
        }

        construct(root.left);
        list.add(root.val);
        construct(root.right);
    }

    public int next() {
        int ans = list.get(index);
        index++;
        return ans;
    }

    public boolean hasNext() {
        return index < list.size();
    }
}

/**
 * solution 2 -- using Stack
 *
 * Time complexity O(1)
 * Space complexity O(h), h is the height of the tree.
 */
class BSTIteratorII {

    Stack<TreeNode> stack;

    public BSTIteratorII(TreeNode root) {
        stack = new Stack<>();
        construct(root);
    }


    private void construct(TreeNode root) {
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }

    public int next() {
        TreeNode node = stack.pop();
        if (node.right != null) {
            TreeNode root = node.right;
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
        }

        return node.val;

    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }
}

