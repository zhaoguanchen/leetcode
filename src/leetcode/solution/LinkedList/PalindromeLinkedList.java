package leetcode.solution.LinkedList;

import leetcode.structure.ListNode;

/**
 * 234. Palindrome Linked List
 * 判断回文
 */
public class PalindromeLinkedList {

    public static void main(String[] args) {
        Integer[] array1 = {1, 2, 2, 2, 1};
        ListNode list1 = ListNode.constructList(array1);
        System.out.println(isPalindrome1(list1));

//        ListNode.print(reverse(list1));
    }


    private static ListNode first;

    /**
     * 全比较
     * 递归到最底，与头节点比较。递归回溯时，与头节点next比较。
     * 这样实现了从后往前与从前往后的比较。
     *
     * @param head
     * @return
     */
    public static boolean isPalindrome(ListNode head) {
        first = head;
        return helper(head);
    }

    public static boolean helper(ListNode head) {
        // 到达末尾，无需比较，返回true
        if (head == null) {
            return true;
        }

        // 先递归，到达尾节点
        boolean res = helper(head.next);
        // 尾节点与头节点比较
        res = head.val == first.val && res;
        // 准备回溯，头节点后移，准备比较倒数第二节点与第二节点
        first = first.next;
        return res;
    }

    /**
     * 翻转后半段的解法
     *
     * @param head
     * @return
     */
    public static boolean isPalindrome1(ListNode head) {
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
     * 获取中间节点
     *
     * @param head
     * @return
     */
    private static ListNode getMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }


    /**
     * 翻转链表   迭代
     *
     * @param head
     * @return
     */
    private static ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode first = head;
        ListNode second = head.next;
        // 虚拟头节点
        ListNode vHead = new ListNode(0);
        vHead.next = first;

        while (second != null) {
            first.next = second.next;
            // 新节点指向头部
            second.next = vHead.next;
            // 新节点链接到虚拟头节点后面
            vHead.next = second;
            second = first.next;
        }
        return vHead.next;
    }
}