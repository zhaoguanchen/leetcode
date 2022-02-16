package leetcode.solution.List;

import leetcode.Structure.ListNode;

/**
 * 1721. Swapping Nodes in a Linked List
 * You are given the head of a linked list, and an integer k.
 * <p>
 * Return the head of the linked list after swapping the values of the kth node from the beginning and the kth node from the end (the list is 1-indexed).
 */
public class SwapNodesInLinkedList {

    public static void main(String[] args) {
        Integer[] array = {1, 2, 3, 4, 5, 6};
        ListNode l1 = ListNode.constructList(array);
        int k = 2;
        ListNode.print(swapNodes(l1, k));

    }

    public static ListNode swapNodes(ListNode head, int k) {
        ListNode cur = head;
        int length = 0;
        // 左侧节点
        ListNode left = head;
        // 右侧节点
        ListNode right = head;
        // iteration
        while (cur.next != null) {
            length++;
            // 当左侧节点为第k个节点时，糨右侧节点设为head节点。这样，当遍历结束时，右侧节点恰好为length - k所在的节点。
            if (length == k) {
                left = cur;
                right = head;
            }

            right = right.next;
            cur = cur.next;
        }

        // exchange
        int temp = left.val;
        left.val = right.val;
        right.val = temp;

        return head;
    }

}
