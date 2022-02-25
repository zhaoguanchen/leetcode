package leetcode.solution.LinkedList;

import leetcode.Structure.ListNode;

/**
 * 206. Reverse Linked List
 * Given the head of a singly linked list, reverse the list, and return the reversed list.
 */
public class ReverseLinkedList {

    public static void main(String[] args) {
        Integer[] array1 = {1, 2, 2, 3, 14};
        ListNode list1 = ListNode.constructList(array1);
        ListNode.print(reverseList1(list1));
    }

    public static ListNode reverseList1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // 前一节点
        ListNode pre = null;
        // 游标节点
        ListNode cur = head;

        // 找到当前节点与下一节点，改变指向关系
        while (cur != null) {
            ListNode nextNode = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nextNode;
        }

        // cur == null, pre为最后一个节点，作为头节点返回
        return pre;
    }

    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        // 递归反转，最终返回末尾元素
        ListNode last = reverseList1(head.next);

        // head原来指向第二个节点，现在第二个节点指向head
        head.next.next = head;
        // 作为最后节点，head指向null
        head.next = null;
        return last;

    }
}
