package leetcode.solution.List;

import leetcode.Structure.ListNode;

/**
 * 24. Swap Nodes in Pairs
 * <p>
 * Given a linked list, swap every two adjacent nodes and return its head.
 * You must solve the problem without modifying the values in the list's nodes (i.e., only nodes themselves may be changed.)
 */
public class SwapNodesInPairs {

    public static void main(String[] args) {
        Integer[] array = {1, 2, 3, 4, 5, 6};
        ListNode l1 = ListNode.constructList(array);
        ListNode.print(swapPairs(l1));

    }

    public static ListNode swapPairs(ListNode head) {
        // 判断空
        if (head == null || head.next == null) {
            return head;
        }
        // 新链表头节点
        ListNode root = new ListNode(-1);
        root.next = head;
        ListNode base = root;

        while (head != null && head.next != null) {
            ListNode backNode = head;
            ListNode frontNode = head.next;
            // 交换节点
            base.next = frontNode;
            backNode.next = frontNode.next;
            frontNode.next = backNode;

            // 基准节点后移，head节点后移
            base = frontNode.next;
            head = base.next;
        }

        return root.next;
    }

}
