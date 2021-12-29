package solution.List;

import Structure.ListNode;

/**
 * 2. Add two list
 * You are given two **non-empty** linked lists representing two non-negative integers.
 * The digits are stored in **reverse order**, and each of their nodes contains a single digit.
 * Add the two numbers and return the sum as a linked list.
 */
public class AddTwoNumbers {

    public static void main(String[] args) {
        Integer[] array = {9, 9, 9, 9, 9, 9, 9};
        ListNode l1 = ListNode.constructList(array);
        Integer[] array2 = {9, 9, 9, 9};
        ListNode l2 = ListNode.constructList(array2);
        ListNode.print(addTwoNumbers(l1, l2));

    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }


}
