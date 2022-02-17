package leetcode.solution.List;

import leetcode.Structure.ListNode;

/**
 * 1721. Swapping Nodes in a Linked List
 * You are given the head of a linked list, and an integer k.
 * <p>
 * Return the head of the linked list after swapping the values of the kth node from the beginning and the kth node from the end (the list is 1-indexed).
 */
public class SwapNodesInLinkedList {

    public static void main(String[] args) {
        Integer[] array = {1, 2,3,4,5};
        ListNode l1 = ListNode.constructList(array);
        int k = 2;
        ListNode.print(swapValue(l1, k));

        ListNode l2 = ListNode.constructList(array);
        ListNode.print(swapNodes(l2, k));

        ListNode l3 = ListNode.constructList(array);
        ListNode.print(swapNodes1(l3, k));

    }

    public static ListNode swapValue(ListNode head, int k) {
        ListNode cur = head;
        int length = 0;
        // 左侧节点
        ListNode left = head;
        // 右侧节点
        ListNode right = head;
        // iteration
        while (cur.next != null) {
            length++;
            // 当左侧节点为第k个节点时，糨右侧节点设为head节点。这样，当遍历结束时，右侧节点恰好为length - k所在的节点。
            if (length == k) {
                left = cur;
                right = head;
            }

            right = right.next;
            cur = cur.next;
        }

        // exchange
        int temp = left.val;
        left.val = right.val;
        right.val = temp;

        return head;
    }


    public static ListNode swapNodes(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }

        int length = 0;
        ListNode root = new ListNode(-1);

        root.next = head;

        // 左侧应交换节点的前一节点
        ListNode leftRoot = root;
        // 右侧应交换节点的前一节点
        ListNode rightRoot = root;
        // iteration
        ListNode cur = root;

        while (cur.next != null) {
            length++;
            // 不到左节点时，后移
            if (length < k) {
                leftRoot = leftRoot.next;
            }
            // 当左侧节点为第k个节点时，糨右侧节点设为head节点。这样，当遍历结束时，右侧节点恰好为length - k所在的节点。
            if (length == k) {
                // 将右边基数节点回退指起点
                rightRoot = root;
            }

            cur = cur.next;
            if (cur.next != null) {
                rightRoot = rightRoot.next;
            }
        }

        // 左侧应交换节点
        ListNode left = leftRoot.next;
        // 左侧应交换节点的后一节点
        ListNode leftNext = left.next;
        // 右侧应交换节点
        ListNode right = rightRoot.next;
        // 左侧应交换节点的后一节点
        ListNode rightNext = right.next;

        System.out.println(left.val);
        System.out.println(right.val);

        // exchange
        if (right.next == left) {
            rightRoot.next = left;
            left.next = right;
            right.next = leftNext;
        } else if (left.next == right) {
            leftRoot.next = right;
            right.next = left;
            left.next = rightNext;
        } else {
            left.next = rightNext;
            right.next = leftNext;
            leftRoot.next = right;
            rightRoot.next = left;
        }

        return root.next;
    }


    public static ListNode swapNodes1(ListNode head, int k) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode firstPrev = dummy;
        for (int i = 0; i < k - 1; i++) {
            firstPrev = firstPrev.next;
        }

        ListNode secondPrev = dummy;
        ListNode advanced = firstPrev.next.next;
        while (advanced != null) {
            secondPrev = secondPrev.next;
            advanced = advanced.next;
        }

        ListNode first = firstPrev.next;
        ListNode second = secondPrev.next;
        ListNode firstNodeAfter = first.next;
        ListNode secondNodeAfter = second.next;

        System.out.println(first.val);
        System.out.println(second.val);
        if (second.next == first) {
            secondPrev.next = first;
            first.next = second;
            second.next = firstNodeAfter;
        } else if (secondPrev == first) {
            firstPrev.next = second;
            second.next = first;
            first.next = secondNodeAfter;
        } else {
            firstPrev.next = second;
            second.next = firstNodeAfter;
            secondPrev.next = first;
            first.next = secondNodeAfter;
        }


        return dummy.next;
    }

}
