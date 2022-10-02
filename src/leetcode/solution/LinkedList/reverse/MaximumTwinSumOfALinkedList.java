package leetcode.solution.LinkedList.reverse;

import leetcode.structure.ListNode;

/**
 * 2130. Maximum Twin Sum of a Linked List
 */
public class MaximumTwinSumOfALinkedList {

    public static void main(String[] args) {
        Integer[] array1 = {1, 2, 2, 3, 14};
        ListNode head = ListNode.constructList(array1);
        RecursiveSolution recursiveSolution = new RecursiveSolution();
        int ans = recursiveSolution.pairSum(head);
        System.out.println(ans);
        IterateSolution iterateSolution = new IterateSolution();
        ans = iterateSolution.pairSum(head);
        System.out.println(ans);

    }


}

class RecursiveSolution {
    private ListNode first;

    private int ans;

    public int pairSum(ListNode head) {
        first = head;
        ans = 0;
        traverse(head);

        return ans;
    }


    private void traverse(ListNode head) {
        if (head == null) {
            return;
        }

        traverse(head.next);
        int sum = first.val + head.val;

        ans = Math.max(ans, sum);

        first = first.next;

    }
}


class IterateSolution {
    public int pairSum(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;


        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode reversed = reverse(slow);

        int ans = 0;
        ListNode p1 = head;
        ListNode p2 = reversed;
        while (p1.next != null) {
            int sum = p1.val + p2.val;
            ans = Math.max(sum, ans);
            p1 = p1.next;
            p2 = p2.next;
        }


        return ans;
    }


    private ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode vHead = new ListNode(0);

        vHead.next = head;

        ListNode curr = head.next;


        while (curr != null) {
            head.next = curr.next;
            curr.next = vHead.next;
            vHead.next = curr;
            curr = head.next;
        }


        return vHead.next;
    }
}