package leetcode.solution.tree;

import leetcode.structure.NNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 559. Maximum Depth of N-ary Tree
 */
public class MaximumDepthOfNaryTree {

    public static void main(String[] args) {
        Integer[] array = {1, null, 2, 3, 4, 5, null, null, 6, 7, null, 8, null, 9, 10, null, null, 11, null, 12, null, 13, null, null, 14};
        NNode root = NNode.constructTree(array);

        MaximumDepthOfNaryTree max = new MaximumDepthOfNaryTree();
        int ans = max.maxDepth(root);
        System.out.println(ans);
        ans = max.maxDepthBFS(root);
        System.out.println(ans);
        // 5

    }

    public int maxDepth(NNode root) {
        if (root == null) {
            return 0;
        }
        // 根结点
        int ans = 1;
        for (NNode node : root.children) {
            ans = Math.max(ans, maxDepth(node) + 1);
        }

        return ans;
    }


    public int maxDepthBFS(NNode root) {
        if (root == null) {
            return 0;
        }

        Queue<NNode> queue = new LinkedList<>();
        queue.add(root);
        int depth = 0;
        while (!queue.isEmpty()) {
            depth++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                NNode node = queue.poll();
                if (node.children == null) {
                    continue;
                }
                queue.addAll(node.children);
            }
        }

        return depth;
    }
}
