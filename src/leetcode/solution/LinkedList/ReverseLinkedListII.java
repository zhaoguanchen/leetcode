package leetcode.solution.LinkedList;

import leetcode.Structure.ListNode;

/**
 * 92. Reverse Linked List II
 */
public class ReverseLinkedListII {

    public static void main(String[] args) {
        Integer[] array1 = {1, 2, 3, 4, 5};
        ListNode list1 = ListNode.constructList(array1);
//        ListNode.print(reverseBetween(list1, 2, 4));
        ListNode.print(reverseBetweenIteration(list1, 2, 4));
    }

    /**
     * 反转后链表的下一个节点
     */
    private static ListNode nextNode;

    public static ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null) {
            return head;
        }

        // 到达起点，题目转换为反转链表前n个节点
        if (left == 1) {
            return reverseTopN(head, right);
        }
        // 前进到要反转的区间
        head.next = reverseBetween(head.next, left - 1, right - 1);

        return head;
    }


    /**
     * reverse top n
     *
     * @param head
     * @param n
     * @return
     */
    private static ListNode reverseTopN(ListNode head, int n) {
        if (n == 1) {
            nextNode = head.next;
            return head;
        }

        ListNode last = reverseTopN(head.next, n - 1);

        head.next.next = head;
        head.next = nextNode;

        return last;
    }


    public static ListNode reverseBetweenIteration(ListNode head, int left, int right) {
        if (head == null) {
            return head;
        }

        ListNode vHead = new ListNode(-1); // create a dummy node to mark the head of this list
        vHead.next = head;
        ListNode pre = vHead;

        // 前进到区间前一节点
        for (int i = 1; i < left; i++) {
            pre = pre.next;
        }

        ListNode first = pre.next;
        ListNode second = pre.next.next;

        int bar = right - left;
        for (int i = 0; i < bar; i++) {
            first.next = second.next;
            second.next = pre.next;
            pre.next = second;
            second = first.next;
            ListNode.print(vHead);
        }


        return vHead.next;
    }

}
