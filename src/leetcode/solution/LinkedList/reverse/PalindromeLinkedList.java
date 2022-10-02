package leetcode.solution.LinkedList.reverse;

import leetcode.structure.ListNode;

/**
 * 234. Palindrome Linked List
 */
public class PalindromeLinkedList {

    public static void main(String[] args) {
        Integer[] array1 = {1, 2, 2, 2, 1};
        ListNode list1 = ListNode.constructList(array1);

        PalindromeLinkedList palindromeLinkedList = new PalindromeLinkedList();
        boolean ans = palindromeLinkedList.isPalindrome(list1);
        System.out.println(ans);
        ListNode list2 = ListNode.constructList(array1);
        ans = palindromeLinkedList.isPalindrome(list2);
        System.out.println(ans);
    }

    /**
     * Solution 1
     * ************************************************************
     * ============================================================
     * ************************************************************
     */

    private ListNode firstNode;

    /**
     * create a ListNode Pointer point to the first node.
     * recurse to the last node, compare with the first node(the Pointer).
     * at last, forward the pointer.
     *
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        firstNode = head;
        return helper(head);
    }

    private boolean helper(ListNode head) {
        // 到达末尾，无需比较，返回true
        if (head == null) {
            return true;
        }

        // 先递归，到达尾节点
        boolean res = helper(head.next);
        // 尾节点与头节点比较
        res = head.val == firstNode.val && res;
        // 准备回溯，头节点后移，准备比较倒数第二节点与第二节点
        firstNode = firstNode.next;
        return res;
    }


    /**
     * Solution 2
     * ************************************************************
     * ============================================================
     * ************************************************************
     */


    /**
     * reverse the second half part
     * then, using two pointer compare the value
     *
     * @param head
     * @return
     */
    public boolean isPalindrome1(ListNode head) {
        ListNode mid = getMid(head);
        ListNode secondList = reverse(mid);
        ListNode p1 = head;
        ListNode p2 = secondList;
        while (p1 != null && p2 != null) {
            if (p1.val != p2.val) {
                return false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        return true;
    }

    /**
     * using two pointer method, get the mid-node
     *
     * @param head
     * @return
     */
    private ListNode getMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }


    /**
     * reverse the Linked List
     *
     * @param head
     * @return
     */
    private ListNode reverse(ListNode head) {
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
}