package leetcode.solution.LinkedList;

import leetcode.Structure.ListNode;

/**
 * 206. Reverse Linked List
 * Given the head of a singly linked list, reverse the list, and return the reversed list.
 */
public class ReverseNodesInkGroup {

    public static void main(String[] args) {
        Integer[] array1 = {1, 2, 3, 4, 5};
        ListNode list1 = ListNode.constructList(array1);
        int k = 3;
        ListNode.print(reverseKGroup(list1, k));
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return head;
        }

        ListNode a = head;
        ListNode b = head;

        for (int i = 0; i < k; i++) {
            // 不足k个，直接返回
            if (b == null) {
                return head;
            }
            b = b.next;

        }
        // 翻转当前区间
        ListNode newHead = reverseBetween1(a, b);
        // 此时a为当前区间的尾节点，后续接下一区间头节点
        a.next = reverseKGroup(b, k);
        return newHead;

    }

    /**
     * 翻转链表的迭代写法
     * 交换a节点到b节点，不包含b
     * <p>
     * 切记不是依次翻转。每个新节点都放在开头，而不是跟前一个节点交换位置
     *
     * @param a
     * @param b
     * @return
     */
    private static ListNode reverseBetween(ListNode a, ListNode b) {
        ListNode vHead = new ListNode(-1);
        vHead.next = a;
        ListNode second = a.next;
        while (second != b) {
            a.next = second.next;
            second.next = vHead.next;
            vHead.next = second;
            second = a.next;
        }
        return vHead.next;
    }


    /**
     * 翻转链表的递归写法
     *
     * @param a
     * @param b
     * @return
     */
    private static ListNode reverseBetween1(ListNode a, ListNode b) {
        // 只剩下最后一个节点自己，直接返回
        if (a.next == b) {
            return a;
        }

        ListNode last = reverseBetween1(a.next, b);
        // 将a链接到末尾
        a.next.next = a;
        a.next = b;
        return last;
    }
}
