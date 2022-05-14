package leetcode.solution.tree;

import leetcode.structure.TreeLinkNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 116. Populating Next Right Pointers in Each Node
 */
public class PopulatingNextRightPointersInEachNode {

    public static void main(String[] args) {
        Integer[] pArray = {1, 2, 3, 4, 5, 6, 7};
        TreeLinkNode p = TreeLinkNode.constructTree(pArray);
        System.out.println(connect(p));

    }

    public static TreeLinkNode connect(TreeLinkNode root) {
        if (root == null) {
            return null;
        }
        Queue<TreeLinkNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeLinkNode current = queue.poll();
                if (current == null) {
                    continue;
                }
                if (i < size - 1) {
                    current.next = queue.peek();
                } else {
                    current.next = null;
                }

                if (current.left != null) {
                    queue.add(current.left);
                }
                if (current.right != null) {
                    queue.add(current.right);
                }
            }
        }

        return root;
    }


    public static TreeLinkNode connect2(TreeLinkNode root) {
        if (root == null) {
            return null;
        }
        Queue<TreeLinkNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeLinkNode current = queue.poll();
            if (current.left == null || current.right == null) {
                continue;
            }
            current.left.next = current.right;
            if (current.next != null) {
                current.right.next = current.next.left;
            }

            queue.add(current.left);
            queue.add(current.right);
        }

        return root;
    }

    /**
     * 在树中遍历
     *
     * @param root
     * @return
     */
    public static TreeLinkNode connect3(TreeLinkNode root) {
        if (root == null) {
            return null;
        }

        // 每一层的最左侧节点
        TreeLinkNode rootLeft = root;
        // 当前层游标
        TreeLinkNode current = rootLeft;

        // 层序遍历
        while (current.left != null) {
            // 连接左右子节点
            current.left.next = current.right;
            // 连接右子节点与后继节点的左子节点
            if (current.next != null) {
                current.right.next = current.next.left;
            }

            // 本层还有节点，后移
            if (current.next != null) {
                current = current.next;
            } else {
                // 移到下一层
                rootLeft = rootLeft.left;
                current = rootLeft;
            }
        }
        return root;
    }


    // 主函数
    public static TreeLinkNode connect4(TreeLinkNode root) {
        if (root == null) return null;
        connectTwoNode(root.left, root.right);
        return root;
    }

    // 辅助函数
    private static void connectTwoNode(TreeLinkNode node1, TreeLinkNode node2) {
        if (node1 == null || node2 == null) {
            return;
        }
        // 将传入的两个节点连接
        node1.next = node2;

        // 连接相同父节点的两个子节点
        connectTwoNode(node1.left, node1.right);
        connectTwoNode(node2.left, node2.right);
        // 连接跨越父节点的两个子节点
        connectTwoNode(node1.right, node2.left);
    }

}
