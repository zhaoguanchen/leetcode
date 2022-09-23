package leetcode.solution.LinkedList;

import leetcode.structure.ListNode;

/**
 * 203. Remove Linked List Elements
 * Given the head of a linked list and an integer val,
 * remove all the nodes of the linked list that has Node.val == val, and return the new head
 */
public class RemoveLinkedListElements {

    public static void main(String[] args) {
        Integer[] array1 = {1, 2, 2, 3, 14};
        ListNode list1 = ListNode.constructList(array1);
        ListNode.print(removeElements(list1, 3));
    }

    public static ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        ListNode newNode = new ListNode(0);
        newNode.next = head;
        ListNode pre = newNode;

        ListNode pro = newNode.next;
        while (pro != null) {
            if (pro.val == val) {
                pre.next = pro.next;
            } else {
                pre = pro;
            }
            pro = pro.next;
        }

        return newNode.next;
    }
}
