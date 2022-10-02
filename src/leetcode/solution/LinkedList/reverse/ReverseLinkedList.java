package leetcode.solution.LinkedList.reverse;

import leetcode.structure.ListNode;

/**
 * 206. Reverse Linked List
 */
public class ReverseLinkedList {

    public static void main(String[] args) {
        Integer[] array1 = {1, 2, 2, 3, 14};
        ListNode list1 = ListNode.constructList(array1);
        ReverseLinkedList reverseLinkedList = new ReverseLinkedList();
        ListNode ans = reverseLinkedList.reverseListIterate(list1);
        ListNode.print(ans);

        ListNode list2 = ListNode.constructList(array1);
        ListNode ans2 = reverseLinkedList.reverseList(list2);
        ListNode.print(ans2);

    }

    /**
     * Iteration
     *
     * @param head
     * @return
     */
    public ListNode reverseListIterate(ListNode head) {
        // the previous node
        ListNode pre = null;
        // the pointer
        ListNode cur = head;

        // remember the next node
        // make pointer point to the previous node
        // move the pre and cur forward
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        // pre will be the last node
        return pre;
    }

    /**
     * Recursion
     *
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        // Recursion
        ListNode last = reverseList(head.next);

        // head.next point to head
        head.next.next = head;
        // head should be the last node, so point to `null`
        head.next = null;
        return last;
    }
}
