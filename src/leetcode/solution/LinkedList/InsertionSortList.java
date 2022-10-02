package leetcode.solution.LinkedList;

import leetcode.structure.ListNode;

/**
 * 147. Insertion Sort List
 */
public class InsertionSortList {

    public static void main(String[] args) {
        Integer[] array = {4, 2, 1, 3};
        ListNode head = ListNode.constructList(array);
        InsertionSortList insertionSortList = new InsertionSortList();
        ListNode ans = insertionSortList.insertionSortList(head);
        ListNode.print(ans);
    }

    public ListNode insertionSortList(ListNode head) {
        ListNode vHead = new ListNode(0);
        ListNode cur = head;

        while (cur != null) {
            // the previous node of the insert position
            ListNode pre = vHead;
            // search the position that the value of next node is greater than the value of cur node.
            while (pre.next != null && pre.next.val < cur.val) {
                pre = pre.next;
            }

            // cache the next node to avoid cycle.
            ListNode next = cur.next;
            // insert cur node to the next position of pre
            cur.next = pre.next;
            pre.next = cur;
            // forward
            cur = next;
        }

        return vHead.next;
    }

}
