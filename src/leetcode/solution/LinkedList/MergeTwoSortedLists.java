package leetcode.solution.LinkedList;

import leetcode.Structure.ListNode;

/**
 * 21. Merge Two Sorted Lists
 */
public class MergeTwoSortedLists {

    public static void main(String[] args) {
        Integer[] array1 = {1, 2, 2, 3, 14};
        Integer[] array2 = {1, 3, 4};
        ListNode list1 = ListNode.constructList(array1);
        ListNode list2 = ListNode.constructList(array2);

        ListNode.print(mergeTwoLists(list1, list2));
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null) {
            return null;
        }
        // list指针
        ListNode p1 = list1;
        ListNode p2 = list2;
        // 虚拟头节点 指向结果链表
        ListNode tempHead = new ListNode();
        // 游标
        ListNode cur = tempHead;
        while (p1 != null && p2 != null) {
            if (p1.val < p2.val) {
                cur.next = p1;
                p1 = p1.next;
            } else {
                cur.next = p2;
                p2 = p2.next;
            }

            cur = cur.next;
        }
        // p1或p2到达末尾  可直接链接另一个list
        if (p1 == null) {
            cur.next = p2;
        } else {
            cur.next = p1;
        }
        // 去掉虚拟头节点
        return tempHead.next;
    }


}
