package leetcode.solution.Tree;

import leetcode.structure.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 297. Serialize and Deserialize Binary Tree
 */
public class SerializeAndDeserializeBinaryTree {

    public static void main(String[] args) {
        Integer[] nums = {1, 2, 3, null, null, 4, 5};
        TreeNode root = TreeNode.constructTree(nums);
        TreeNode.print(root);
        System.out.println("层序遍历");

        BFS bfs = new BFS();
        String str = bfs.serialize(root);
        System.out.println(str);
        TreeNode newRoot = bfs.deserialize(str);
        System.out.println(TreeNode.print(newRoot));
        System.out.println("前序遍历");

        Preorder preorder = new Preorder();
        String str1 = preorder.serialize(root);
        System.out.println(str1);
        TreeNode newRoot1 = preorder.deserialize(str1);
        System.out.println(TreeNode.print(newRoot1));

        System.out.println("后序遍历");

        Postorder postorder = new Postorder();
        String str2 = postorder.serialize(root);
        System.out.println(str2);
        TreeNode newRoot2 = postorder.deserialize(str2);
        System.out.println(TreeNode.print(newRoot2));

    }

}

/**
 * 前序遍历
 */
class Preorder {

    private final String splitStr = ",";
    private final String nullStr = "#";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializeHelper(root, sb);
        return sb.toString();
    }

    private void serializeHelper(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append(nullStr);
            sb.append(splitStr);
            return;
        }
        sb.append(root.val);
        sb.append(splitStr);

        serializeHelper(root.left, sb);
        serializeHelper(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] strings = data.split(splitStr);
        LinkedList<String> list = new LinkedList<>(Arrays.asList(strings));
        return deserializeHelper(list);
    }

    private TreeNode deserializeHelper(LinkedList<String> list) {
        if (list.isEmpty()) {
            return null;
        }
        String s = list.pollFirst();
        if (s.equals(nullStr)) {
            return null;
        }
        int value = Integer.parseInt(s);
        TreeNode root = new TreeNode(value);
        root.left = deserializeHelper(list);
        root.right = deserializeHelper(list);

        return root;
    }

}


/**
 * 后序遍历
 */
class Postorder {

    private final String splitStr = ",";
    private final String nullStr = "#";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializeHelper(root, sb);
        return sb.toString();
    }

    private void serializeHelper(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append(nullStr);
            sb.append(splitStr);
            return;
        }
        serializeHelper(root.left, sb);
        serializeHelper(root.right, sb);

        sb.append(root.val);
        sb.append(splitStr);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] strings = data.split(splitStr);
        LinkedList<String> list = new LinkedList<>(Arrays.asList(strings));
        return deserializeHelper(list);
    }

    private TreeNode deserializeHelper(LinkedList<String> list) {
        if (list.isEmpty()) {
            return null;
        }
        String s = list.pollLast();
        if (s.equals(nullStr)) {
            return null;
        }
        int value = Integer.parseInt(s);
        TreeNode root = new TreeNode(value);
        root.right = deserializeHelper(list);
        root.left = deserializeHelper(list);
        return root;
    }

}

/**
 * BFS版本  层序遍历
 */
class BFS {

    private final String splitStr = ",";
    private final String nullStr = "#";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (null == root) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (null == node) {
                stringBuilder.append(nullStr);
                stringBuilder.append(splitStr);
                continue;
            }

            stringBuilder.append(node.val);
            stringBuilder.append(splitStr);

            queue.offer(node.left);
            queue.offer(node.right);
        }

        return stringBuilder.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.isEmpty()) {
            return null;
        }
        String[] strings = data.split(splitStr);
        int rootVal = Integer.parseInt(strings[0]);
        TreeNode root = new TreeNode(rootVal);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        for (int i = 1; i < strings.length; ) {
            TreeNode node = queue.poll();
            // 左子节点
            String leftStr = strings[i];
            if (leftStr.equals(nullStr)) {
                node.left = null;
            } else {
                int leftVal = Integer.parseInt(strings[i]);
                TreeNode leftNode = new TreeNode(leftVal);
                node.left = leftNode;
                queue.add(leftNode);
            }

            i++;
            // 右子节点
            String rightStr = strings[i];
            if (rightStr.equals(nullStr)) {
                node.right = null;
            } else {
                int rightVal = Integer.parseInt(strings[i]);
                TreeNode rightNode = new TreeNode(rightVal);
                node.right = rightNode;
                queue.add(rightNode);
            }

            i++;
        }
        return root;
    }

}