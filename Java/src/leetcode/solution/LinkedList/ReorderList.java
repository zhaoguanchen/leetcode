package leetcode.solution.LinkedList;

import leetcode.structure.ListNode;

/**
 * 143. Reorder List
 */
public class ReorderList {

    public static void main(String[] args) {
        Integer[] array = {1, 2, 3, 4, 5};
        ListNode list = ListNode.constructList(array);
        ReorderList reorderList = new ReorderList();
        reorderList.reorderList(list);
        ListNode.print(list);
        // 1,5,2,4,3


    }

    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode secondPart = reverseList(slow.next);
        slow.next = null;

        ListNode p1 = head.next;
        ListNode p2 = secondPart;
        ListNode p = head;
        while (p2 != null && p1 != null) {
            ListNode p1Next = p1.next;
            ListNode p2Next = p2.next;

            p.next = p2;
            p = p.next;
            p.next = p1;
            p = p.next;

            p1 = p1Next;
            p2 = p2Next;
        }

    }


    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = null;
        ListNode cur = head;

        while (cur != null) {
            ListNode nextNode = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nextNode;
        }

        return pre;
    }
}




