package leetcode.solution.LinkedList;

import leetcode.structure.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 23. Merge k Sorted Lists
 */
public class MergeKSortedLists {

    public static void main(String[] args) {
        Integer[] array1 = {1, 2, 2, 3, 14};
        Integer[] array2 = {1, 3, 4};
        ListNode list1 = ListNode.constructList(array1);
        ListNode list2 = ListNode.constructList(array2);

        ListNode[] lists = {list1, list2};

        ListNode.print(mergeKLists(lists));
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        // 优先队列
        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, Comparator.comparingInt(value -> value.val));

        // 虚拟头节点
        ListNode vHead = new ListNode(0);
        // 游标
        ListNode cur = vHead;

        // 将头节点放入
        for (ListNode list : lists) {
            if (list != null) {
                queue.add(list);
            }
        }

        // 最小节点出队后，添加其下一节点
        while (!queue.isEmpty()) {
            ListNode node = queue.poll();
            // 找到新节点，链接到新链表
            cur.next = node;
            // 添加下一个节点到队列
            if (node.next != null) {
                queue.add(node.next);
            }

            cur = cur.next;
        }

        return vHead.next;
    }

}
