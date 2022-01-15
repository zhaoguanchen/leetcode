# leetcode

 leetcode solution

[TOC]

## 1. Two Sum

Given an array of integers `nums` and an integer `target`, return *indices of the two numbers such that they add up to `target`*.

You may assume that each input would have ***exactly one solution***, and you may not use the *same* element twice.

You can return the answer in any order.



```java
public static int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
        int x = nums[i];
        int diff = target - x;
        if (map.containsKey(diff)) {
            int index = map.get(diff);
            return new int[]{index, i};
        }
        map.put(x, i);
    }
    return null;
}
```

## 2. Add Two Numbers



You are given two **non-empty** linked lists representing two non-negative integers. The digits are stored in **reverse order**, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.



```java
public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
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
```



## 13. Roman to Integer

Roman numerals are represented by seven different symbols: `I`, `V`, `X`, `L`, `C`, `D` and `M`.

```
Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
```

For example, `2` is written as `II` in Roman numeral, just two one's added together. `12` is written as `XII`, which is simply `X + II`. The number `27` is written as `XXVII`, which is `XX + V + II`.

Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not `IIII`. Instead, the number four is written as `IV`. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as `IX`. There are six instances where subtraction is used:

- `I` can be placed before `V` (5) and `X` (10) to make 4 and 9. 
- `X` can be placed before `L` (50) and `C` (100) to make 40 and 90. 
- `C` can be placed before `D` (500) and `M` (1000) to make 400 and 900.

Given a roman numeral, convert it to an integer.

```java
public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('M', 1000);
        map.put('D', 500);
        map.put('C', 100);
        map.put('L', 50);
        map.put('X', 10);
        map.put('V', 5);
        map.put('I', 1);

        int base = 0;

        for (int i = 0; i < s.length() - 1; i++) {
            char cur = s.charAt(i);
            char pro = s.charAt(i + 1);
            if (map.get(pro) > map.get(cur)) {
                base = base - map.get(cur);

            } else {
                base = base + map.get(cur);
            }
        }
        base = base + map.get(s.charAt(s.length() - 1));
        return base;
    }
```



## 14. Longest Common Prefix

Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string `""`.

**Example 1:**

```
Input: strs = ["flower","flow","flight"]
Output: "fl"
```

```java
    public String longestCommonPrefix(String[] strs) {
        String com = strs[0];
        for (String s : strs) {
            com = commonPrefix(s, com);
            System.out.println(com);
        }
        return com;

    }

    private String commonPrefix(String left, String right) {
        int min = Math.min(left.length(), right.length());
        for (int i = 0; i < min; i++) {
            if (left.charAt(i) != right.charAt(i))
                return left.substring(0, i);
        }
        return left.substring(0, min);
    }
```



## 20. Valid Parentheses

Given a string `s` containing just the characters `'('`, `')'`, `'{'`, `'}'`, `'['` and `']'`, determine if the input string is valid.

An input string is valid if:

1. Open brackets must be closed by the same type of brackets.
2. Open brackets must be closed in the correct order.



```java
    public boolean isValid(String s) {
      
      Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
                continue;
            }

            if (c == ')' || c == '}' || c == ']') {
                if (stack.isEmpty()) {
                    return false;
                }
                char e = stack.pop();
                if (c == ')' && e != '(' || c == '}' && e != '{' || c == ']' && e != '[') {
                    return false;
                }

            }


        }

        return stack.isEmpty();

    }

```



## 21. Merge Two Sorted Lists

You are given the heads of two sorted linked lists `list1` and `list2`.

Merge the two lists in a one **sorted** list. The list should be made by splicing together the nodes of the first two lists.

Return *the head of the merged linked list*.

```java
public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null) {
            return null;
        }

        ListNode p1 = list1;
        ListNode p2 = list2;
        ListNode res = new ListNode();
        ListNode cur = res;
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

        if (p1 == null) {
            cur.next = p2;

        } else {
            cur.next = p1;
        }
        return res.next;
    }
```

```java
public ListNode mergeTwoLists1(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null) {
            return null;
        }

        ListNode p1 = list1;
        ListNode p2 = list2;
        ListNode res = new ListNode();
        ListNode cur = res;
        while (p1 != null || p2 != null) {
            if (p1 == null) {
                cur.next = p2;
                p2 = p2.next;
            } else if (p2 == null) {
                cur.next = p1;
                p1 = p1.next;

            } else {

                if (p1.val < p2.val) {
                    cur.next = p1;
                    p1 = p1.next;
                } else {
                    cur.next = p2;
                    p2 = p2.next;
                }

            }

            cur = cur.next;
        }

        return res.next;

    }
```





## 54. Spiral Matrix

```java
  public static List<Integer> spiralOrder(int[][] matrix) {
        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;
        int total = matrix[0].length * matrix.length;

        List<Integer> list = new ArrayList<>();

        boolean cyc = true;
        while (cyc) {

            for (int i = left; i <= right && top <= bottom; i++) {
                list.add(matrix[top][i]);
            }

            top++;

            for (int i = top; i <= bottom && left <= right; i++) {
                list.add(matrix[i][right]);
            }

            right--;

            for (int i = right; i >= left && top <= bottom; i--) {
                list.add(matrix[bottom][i]);
            }

            bottom--;

            for (int i = bottom; i >= top && left <= right; i--) {
                list.add(matrix[i][left]);
            }

            left++;

            if (list.size() >= total) {
                cyc = false;
            }
        }


        return list;
    }
```



## 70. Climbing Stairs

You are climbing a staircase. It takes `n` steps to reach the top.

Each time you can either climb `1` or `2` steps. In how many distinct ways can you climb to the top?



```java
    private static final Map<Integer, Integer> map = new HashMap<>();


    public static int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }

        if (map.containsKey(n)) {
            return map.get(n);
        }
        map.put(n, climbStairs(n - 1) + climbStairs(n - 2));

        return map.get(n);
    }

```





```java
    public static int climbStairs1(int n) {
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
```





## 88. Merge Sorted Array

You are given two integer arrays `nums1` and `nums2`, sorted in **non-decreasing order**, and two integers `m` and `n`, representing the number of elements in `nums1` and `nums2` respectively.

**Merge** `nums1` and `nums2` into a single array sorted in **non-decreasing order**.

The final sorted array should not be returned by the function, but instead be *stored inside the array* `nums1`. To accommodate this, `nums1` has a length of `m + n`, where the first `m` elements denote the elements that should be merged, and the last `n` elements are set to `0` and should be ignored. `nums2` has a length of `n`.



```java
public static void merge(int[] nums1, int m, int[] nums2, int n) {
    int p1 = m - 1;
    int p2 = n - 1;
    int total = m + n - 1;

    for (int i = total; i >= 0; i--) {
        if (p1 < 0) {
            nums1[i] = nums2[p2];
            p2--;
            continue;
        }
        if (p2 < 0) {
            break;
        }

        if (nums1[p1] >= nums2[p2]) {
            nums1[i] = nums1[p1];
            p1--;
        } else {
            nums1[i] = nums2[p2];
            p2--;

        }

    }
```

## 94. Binary Tree Inorder Traversal

**Recusion**

```java
 public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        helper(root, result);
        return result;
    }


    private static void helper(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }

        helper(root.left, result);
        result.add(root.val);
        helper(root.right, result);
    }


```

**Iteration**

```java
    public static List<Integer> inorderIterator(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            res.add(curr.val);
            curr = curr.right;
        }
        return res;

    }

```





## 100. Same Tree

Recursion

```java
public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        
        if (p == null || q == null || p.val != q.val) {
            return false;
        }

        return isSameTree(p.right, q.right) && isSameTree(p.left, q.left);
    }


```

Iteration

```java
 public static boolean isSameTree(TreeNode p, TreeNode q) {
        ArrayDeque<TreeNode> pDeque = new ArrayDeque<>();
        ArrayDeque<TreeNode> qDeque = new ArrayDeque<>();

        if (p == null && q == null) {
            return true;
        }


        if (p == null || q == null || p.val != q.val) {
            return false;
        }

        pDeque.add(p);
        qDeque.add(q);

        while (!pDeque.isEmpty() && !qDeque.isEmpty()) {

            TreeNode curP = pDeque.removeFirst();
            TreeNode curQ = qDeque.removeFirst();

            if (p.val != q.val) {
                return false;
            }

            if (curP.left == null || curQ.left == null) {
                if (curP.left != null || curQ.left != null) {
                    return false;
                }
            } else {
                pDeque.add(curP.left);
                qDeque.add(curQ.left);
            }

            if (curP.right == null || curQ.right == null) {
                if (curP.right != null || curQ.right != null) {
                    return false;
                }
            } else {
                pDeque.add(curP.right);
                qDeque.add(curQ.right);

            }

        }

        return pDeque.isEmpty() && qDeque.isEmpty();
    }
```

## 101.Symmetric Tree

Recursion

```java
public static boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSame(root.left, root.right);
    }

private static boolean isSame(TreeNode leftNode, TreeNode rightNode) {
  if (leftNode == null && rightNode == null) {
    return true;
  }
  if (leftNode == null || rightNode == null) {
    return false;
  }
  if (leftNode.val != rightNode.val) {
    return false;
  }
  return isSame(leftNode.left, rightNode.right) && isSame(leftNode.right, rightNode.left);
}
```

Iteration

```java
public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode t1 = q.poll();
            TreeNode t2 = q.poll();
            if (t1 == null && t2 == null) {
                continue;
            }
            if (t1 == null || t2 == null || t1.val != t2.val) {
                return false;
            }
            q.add(t1.left);
            q.add(t2.right);
            q.add(t1.right);
            q.add(t2.left);
        }
        return true;
    }
```





## 102. Binary Tree Level Order Traversal

Given the `root` of a binary tree, return *the level order traversal of its nodes' values*. (i.e., from left to right, level by level).

Example:

```html
Input: root = [3,9,20,null,null,15,7]
Output: [[3],[9,20],[15,7]]
```

- Recursion

```java
class Solution {
    private final List<List<Integer>> resForRecursion = new ArrayList<>();

    
    public List<List<Integer>> levelOrder(TreeNode root) {
        helper(root, 0);
        return resForRecursion;
    }

    private void helper(TreeNode root, Integer level) {
        if (root == null) {
            return;
        }
        if (resForRecursion.size() == level) {
            resForRecursion.add(new ArrayList<>());
        }
        List<Integer> cur = resForRecursion.get(level);

        cur.add(root.val);
        helper(root.left, level + 1);
        helper(root.right, level + 1);

    }
}
```



- Itreator

```java
public List<List<Integer>> levelOrderIterator(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int total = queue.size();
            List<Integer> subList = new ArrayList<>();
            for (int i = 0; i < total; i++) {
                TreeNode current = queue.poll();
                if (current == null) {
                    break;
                }
                if (current.left != null) {
                    queue.add(current.left);
                }
                if (current.right != null) {
                    queue.add(current.right);
                }
                subList.add(current.val);
            }

            res.add(subList);

        }
        return res;

    }
```



## 104. Maximum Depth of Binary Tree

Given the root of a binary tree, return its maximum depth.



- Recursion

```java
public static int maxDepth(TreeNode root) {
    if (root == null) {
        return 0;
    } else {
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }

}
```

- Iteration

```java
public static int maxDepthIterator(TreeNode root) {
    if (root == null) {
        return 0;
    }

    Queue<TreeNode> nodeQueue = new LinkedList<>();
    Queue<Integer> depthQueue = new LinkedList<>();

    nodeQueue.add(root);
    depthQueue.add(1);

    int max = 0;

    while (!nodeQueue.isEmpty()) {
        TreeNode currentNode = nodeQueue.poll();
        Integer currentDepth = depthQueue.poll();
        if (currentDepth == null) {
            continue;
        }

        max = Math.max(currentDepth, max);

        if (currentNode.left != null) {
            nodeQueue.add(currentNode.left);
            depthQueue.add(currentDepth + 1);
        }

        if (currentNode.right != null) {
            nodeQueue.add(currentNode.right);
            depthQueue.add(currentDepth + 1);
        }
    }

    return max;
}
```



## 114. Binary Tree Preorder Traversal

Recursion

```java
 public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        helper(root, result);

        return result;
    }

    private static void helper(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        result.add(root.val);
        helper(root.left, result);
        helper(root.right, result);
    }

```

Iterator:

```java
 public static List<Integer> preorderIterator(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        stack.add(root);

        while (!stack.isEmpty()) {
            TreeNode current = stack.pop();
            if (current == null) {
                break;
            }

            res.add(current.val);

            if (current.right != null) {
                stack.add(current.right);
            }
            if (current.left != null) {
                stack.add(current.left);
            }

        }
        return res;

    }
```



## 116. Populating Next Right Pointers in Each Node

You are given a **perfect binary tree** where all leaves are on the same level, and every parent has two children. The binary tree has the following definition:

```
struct Node {
  int val;
  Node *left;
  Node *right;
  Node *next;
}
```

Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to `NULL`.

Initially, all next pointers are set to `NULL`.

Solution 1:

```java
class Solution {
    public Node connect(Node root) {
  			if (root == null) {
            return null;
        }

        Node rootLeft = root;
        Node current = rootLeft;

        while (true) {
            if (current.left == null) {
                break;
            }

            current.left.next = current.right;

            if (current.next != null) {
                current.right.next = current.next.left;
            }
            if (current.next != null) {
                current = current.next;
            } else {
                rootLeft = rootLeft.left;
                current = rootLeft;
            }
        }
        return root;
    }
}


```

Solution 2:

```java
public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node current = queue.poll();
                if (current == null) {
                    continue;
                }
                if (i < size - 1) {
                    current.next = queue.peek();
                } else {
                    current.next = null;
                }

                if (current.left != null) {
                    queue.add(current.left);
                }
                if (current.right != null) {
                    queue.add(current.right);
                }
            }
        }

        return root;
    }
```


Solution 3:

```java
public Node connect(Node root) {
    if (root == null) {
        return null;
    }
    Queue<Node> queue = new LinkedList<>();
    queue.add(root);

    while (!queue.isEmpty()) {
        Node current = queue.poll();
        if (current.left == null || current.right == null) {
            continue;
        }
        current.left.next = current.right;
        if (current.next != null) {
            current.right.next = current.next.left;
        }

        queue.add(current.left);
        queue.add(current.right);
    }

    return root;
}
```







## 118. Pascal's Triangle

Given an integer `numRows`, return the first numRows of **Pascal's triangle**.

**Example 1:**

```
Input: numRows = 5
Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
```

**Example 2:**

```
Input: numRows = 1
Output: [[1]]
```





```java
public List<List<Integer>> generate(int numRows) {
       List<List<Integer>> res = new ArrayList<>();

        List<Integer> fund = new ArrayList<>();
        for (int i = 1; i <= numRows; i++) {
            List<Integer> cur = new ArrayList<>();
            cur.add(1);
            if (i > 1) {
                for (int j = 1; j < i - 1; j++) {
                    int value = fund.get(j - 1) + fund.get(j);
                    cur.add(value);
                }

                cur.add(1);
            }
            res.add(cur);
            fund = cur;
        }

        return res;
    }
```



## 121. Best Time to Buy and Sell Stock

You are given an array `prices` where `prices[i]` is the price of a given stock on the `ith` day.

You want to maximize your profit by choosing a **single day** to buy one stock and choosing a **different day in the future** to sell that stock.

Return *the maximum profit you can achieve from this transaction*. If you cannot achieve any profit, return `0`.

```java
public static int maxProfit(int[] prices) {
    int min = Integer.MAX_VALUE;
    int max = 0;

    for (int price : prices) {
        if (price < min) {
            min = price;
        } else {
            max = Math.max(price - min, max);
        }
    }
    return max;
}
```





## 141. Linked List Cycle

Given `head`, the head of a linked list, determine if the linked list has a cycle in it.

There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the `next` pointer. Internally, `pos` is used to denote the index of the node that tail's `next` pointer is connected to. **Note that `pos` is not passed as a parameter**.

Return `true` *if there is a cycle in the linked list*. Otherwise, return `false`.

```java
public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode pre = head;
        ListNode pro = head.next;

        while (pre != pro) {
            if (pro == null || pro.next == null) {
                return false;
            }

            pre = pre.next;
            pro = pro.next.next;
        }

        return true;

    }
```



```java
public boolean hasCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();

        ListNode cur = head;

        while (cur != null) {
            if (set.contains(cur)) {
                return true;
            }
            set.add(cur);
            cur = cur.next;

        }

        return false;

    }
```





## 145. Binary Tree Postorder Traversal



**Recursion**

```java
public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        helper(root, result);
        return result;
    }

    private static void helper(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }

        helper(root.left, result);
        helper(root.right, result);
        result.add(root.val);
    }
```

**Iteration**

```java
    public static List<Integer> postorderIterator(TreeNode root) {
        LinkedList<Integer> ans = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) {
            return ans;
        }

        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            ans.addFirst(cur.val);
            if (cur.left != null) {
                stack.push(cur.left);
            }
            if (cur.right != null) {
                stack.push(cur.right);
            }
        }
        return ans;
    }
```





## 203. Remove Linked List Elements

Given the `head` of a linked list and an integer `val`, remove all the nodes of the linked list that has `Node.val == val`, and return *the new head*.

```java
public ListNode removeElements(ListNode head, int val) {
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
```

## 206. Reverse Linked List

 Given the head of a singly linked list, reverse the list, and return the reversed list.

```java
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
```



```java
    public ListNode reverseList1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = reverseList1(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }
```



## 217. Contains Duplicate

Given an integer array nums, return true if any value appears at least twice in the array,
and return false if every element is distinct.



```java
 public static boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            if (set.contains(num)) {
                return true;
            } else {
                set.add(num);
            }
        }

        return false;
    }
```

## 232. Implement Queue using Stacks

Implement a first in first out (FIFO) queue using only two stacks. The implemented queue should support all the functions of a normal queue (`push`, `peek`, `pop`, and `empty`).

Implement the `MyQueue` class:

- `void push(int x)` Pushes element x to the back of the queue.
- `int pop()` Removes the element from the front of the queue and returns it.
- `int peek()` Returns the element at the front of the queue.
- `boolean empty()` Returns `true` if the queue is empty, `false` otherwise.



```java
class MyQueue {

    public MyQueue() {
        
    }
    
    Stack<Integer> s = new Stack<>();
    Stack<Integer> temp = new Stack<>();


    public void push(int x) {
         if (!s.isEmpty()) {
            while (!s.isEmpty()) {
                temp.push(s.pop());
            }

        }
        s.push(x);
        while (!temp.isEmpty()) {
            s.push(temp.pop());
        }

    }

    public int pop() {
        return s.pop();
    }

    public int peek() {
        return s.peek();
    }

    public boolean empty() {
        return s.isEmpty();
    }

}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
```



## 242. Valid Anagram

Given two strings `s` and `t`, return `true` *if* `t` *is an anagram of* `s`*, and* `false` *otherwise*.

```java
public static boolean isAnagram(String s, String t) {
        char[] cArray = new char[26];

        if (s.length() != t.length()) {
            return false;
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int index = c - 'a';
            cArray[index]++;
        }

        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            int index = c - 'a';
            if (cArray[index] <= 0) {
                return false;
            }

            cArray[index]--;
        }

        return true;
    }
```





## 350. Intersection of Two Arrays II



Given two integer arrays `nums1` and `nums2`, return *an array of their intersection*. Each element in the result must appear as many times as it shows in both arrays and you may return the result in **any order**.

 **Example 1:**

```java
Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2,2]
```



```java
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
             Map<Integer, Integer> map = new HashMap<>();

        for (int i : nums1) {
            if (map.containsKey(i)) {
                int quantity = map.get(i);

                map.put(i, quantity + 1);
            } else {
                map.put(i, 1);
            }
        }
        
        List<Integer> res = new ArrayList<>();

        for (int i : nums2) {
            if (map.containsKey(i)) {
                int quantity = map.get(i);
                if (quantity > 0) {
                    res.add(i);
                }
                map.put(i, quantity - 1);
            }
        }
        
        int[] resArray = new int[res.size()];

        for (int i = 0; i < resArray.length; i++) {
            resArray[i] = res.get(i);
        }

        return resArray;
    }
}
```





## 383. Ransom Note

Given two stings `ransomNote` and `magazine`, return `true` if `ransomNote` can be constructed from `magazine` and `false` otherwise.

Each letter in `magazine` can only be used once in `ransomNote`.



```java
 public static boolean canConstruct(String ransomNote, String magazine) {
        char[] c = new char[26];

        for (int i = 0; i < magazine.length(); i++) {
            char s = magazine.charAt(i);
            int index = s - 'a';
            c[index]++;
        }

        for (int i = 0; i < ransomNote.length(); i++) {
            char s = ransomNote.charAt(i);
            int index = s - 'a';
            if (c[index] <= 0) {
                return false;
            }

            c[index]--;
        }

        return true;
    }
```



## 387. First Unique Character in a String

Given a string `s`, *find the first non-repeating character in it and return its index*. If it does not exist, return `-1`.

```java
public int firstUniqChar(String s) {
        int[] count = new int[26];
        int n = s.length();
        for (int i = 0; i < n; i++) {
            int index = s.charAt(i) - 'a';
            count[index]++;
        }

        for (int i = 0; i < n; i++) {
            int index = s.charAt(i) - 'a';
            if (count[index] == 1) {
                return i;
            }

        }
        return -1;
    }

```



```java
public int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            Integer value = map.getOrDefault(c, 0);
            map.put(c, value + 1);
        }

        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1) {
                return i;
            }

        }
        return -1;

    }
```



## 476. Number Complement

The **complement** of an integer is the integer you get when you flip all the `0`'s to `1`'s and all the `1`'s to `0`'s in its binary representation.

- For example, The integer `5` is `"101"` in binary and its **complement** is `"010"` which is the integer `2`.

Given an integer `num`, return *its complement*.

```java
class Solution {
    public int findComplement(int num) {
    int n = (int)( Math.log(num) / Math.log(2) ) + 1;
    int c = (1 << n) - 1;
        return num ^ c;
    }
}
```



## 509. Fibonacci Number

The **Fibonacci numbers**, commonly denoted `F(n)` form a sequence, called the **Fibonacci sequence**, such that each number is the sum of the two preceding ones, starting from `0` and `1`. That is,

```
F(0) = 0, F(1) = 1
F(n) = F(n - 1) + F(n - 2), for n > 1.
```

Given `n`, calculate `F(n)`.

 **Recursion**

```java
 public int fib(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }

        return fib(n - 1) + fib(n - 2);
    }

```



**Bottom-Up Approach using Tabulation**

```java
    public static int fib1(int n) {
        int[] cache = new int[n + 1];
        cache[0] = 0;
        cache[1] = 1;
        for (int i = 2; i <= n; i++) {
            cache[i] = cache[i - 1] + cache[i - 2];
        }

        return cache[n];
    }
```



**Top-Down Approach using Memoization**

```java
		private static final Map<Integer, Integer> map = new HashMap<>();

    public static int fib3(int n) {
        map.put(0, 0);
        map.put(1, 1);

        if (map.containsKey(n)) {
            return map.get(n);
        }
        map.put(n, fib3(n - 1) + fib3(n - 2));

        return map.get(n);
    }
```



 **Iterative Bottom-Up Approach**

```java
public static int fib2(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }

        int pre = 0;
        int last = 1;
  			int res = 0;

        for (int i = 2; i <= n; i++) {
            res = pre + last;
            pre = last;
            last = res;
        }

        return last;
    }
```



## 566. Reshape the Matrix

In MATLAB, there is a handy function called `reshape` which can reshape an `m x n` matrix into a new one with a different size `r x c` keeping its original data.

You are given an `m x n` matrix `mat` and two integers `r` and `c` representing the number of rows and the number of columns of the wanted reshaped matrix.

The reshaped matrix should be filled with all the elements of the original matrix in the same row-traversing order as they were.

If the `reshape` operation with given parameters is possible and legal, output the new reshaped matrix; Otherwise, output the original matrix.



```java
public int[][] matrixReshape(int[][] mat, int r, int c) {
      int m = mat.length, n = mat[0].length;
        if (m * n != r * c) {
            return mat;
        }
        int total = m * n;
        int[][] newMat = new int[r][c];

        for (int i = 0; i < total; i++) {
            int m1 = i / n;
            int n1 = i % n;
            int r1 = i / c;
            int c1 = i % c;

            newMat[r1][c1] = mat[m1][n1];
        }
        return newMat;
    }
```



## 572. Subtree of Another Tree

Given the roots of two binary trees `root` and `subRoot`, return `true` if there is a subtree of `root` with the same structure and node values of` subRoot` and `false` otherwise.

A subtree of a binary tree `tree` is a tree that consists of a node in `tree` and all of this node's descendants. The tree `tree` could also be considered as a subtree of itself.

```java
class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) {
            return false;
        }
        if (isSame(root, subRoot)) {
            return true;
        }
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    private Boolean isSame(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) {
            return true;
        }
        if (root == null || subRoot == null) {
            return false;
        }
        if (root.val != subRoot.val) {
            return false;
        }

        return isSame(root.left, subRoot.left) && isSame(root.right, subRoot.right);
    }
}
```

## 746. Min Cost Climbing Stairs

You are given an integer array `cost` where `cost[i]` is the cost of `ith` step on a staircase. Once you pay the cost, you can either climb one or two steps.

You can either start from the step with index `0`, or the step with index `1`.

Return *the minimum cost to reach the top of the floor*.

 

We start at either step 0 or step 1. The target is to reach either last or second last step, whichever is minimum.



**Step 1 - Identify a recurrence relation between subproblems.** In this problem,
Recurrence Relation:
`mincost(i) = cost[i]+min(mincost(i-1), mincost(i-2))`
Base cases:
`mincost(0) = cost[0]`
`mincost(1) = cost[1]`



**Step 2 - Covert the recurrence relation to recursion**



```java
// Recursive Top Down - O(2^n) Time Limit Exceeded
public int minCostClimbingStairs(int[] cost) {
	int n = cost.length;
	return Math.min(minCost(cost, n-1), minCost(cost, n-2));
}
private int minCost(int[] cost, int n) {
	if (n < 0) return 0;
	if (n==0 || n==1) return cost[n];
	return cost[n] + Math.min(minCost(cost, n-1), minCost(cost, n-2));
}
```



**Step 3 - Optimization 1 - Top Down DP - Add memoization to recursion** - From exponential to linear.



```java
// Top Down Memoization - O(n) 1ms
int[] dp;
public int minCostClimbingStairs(int[] cost) {
	int n = cost.length;
	dp = new int[n];
	return Math.min(minCost(cost, n-1), minCost(cost, n-2));
}
private int minCost(int[] cost, int n) {
	if (n < 0) return 0;
	if (n==0 || n==1) return cost[n];
	if (dp[n] != 0) return dp[n];
	dp[n] = cost[n] + Math.min(minCost(cost, n-1), minCost(cost, n-2));
	return dp[n];
}
```



**Step 4 - Optimization 2 -Bottom Up DP - Convert recursion to iteration** - Getting rid of recursive stack



```java
// Bottom up tabulation - O(n) 1ms
public int minCostClimbingStairs(int[] cost) {
	int n = cost.length;
	int[] dp = new int[n];
	for (int i=0; i<n; i++) {
		if (i<2) dp[i] = cost[i];
		else dp[i] = cost[i] + Math.min(dp[i-1], dp[i-2]);
	}
	return Math.min(dp[n-1], dp[n-2]);
}
```



**Step 5 - Optimization 3 - Fine Tuning - Reduce O(n) space to O(1)**.



```java
// Bottom up computation - O(n) time, O(1) space
public int minCostClimbingStairs(int[] cost) {
	int n = cost.length;
	int first = cost[0];
	int second = cost[1];
	if (n<=2) return Math.min(first, second);
	for (int i=2; i<n; i++) {
		int curr = cost[i] + Math.min(first, second);
		first = second;
		second = curr;
	}
	return Math.min(first, second);
}
```

## 783. Minimum Distance Between BST Nodes

Given the `root` of a Binary Search Tree (BST), return *the minimum difference between the values of any two different nodes in the tree*.

```java
 		private static Integer prev, ans;

    public static int minDiffInBST(TreeNode root) {
        prev = null;
        ans = Integer.MAX_VALUE;
        dfs(root);
        return ans;
    }

    public static void dfs(TreeNode node) {
        if (node == null) {
            return;
        }

        dfs(node.left);
        if (prev != null) {
            ans = Math.min(ans, Math.abs(node.val - prev));
        }
        prev = node.val;
        dfs(node.right);
    }
```



## 876. Middle of the Linked List

Given the `head` of a singly linked list, return *the middle node of the linked list*.

If there are two middle nodes, return **the second middle** node.

**Fast and Slow Pointer**

```java
class Solution {
    public ListNode middleNode(ListNode head) {
        
        ListNode pro = head;
        ListNode pre = head;
        
        while(pro != null && pro.next != null){
            pro = pro.next.next;
            pre= pre.next;
        }
        
        return pre;
    }
}
```



## 997. Find the Town Judge

In a town, there are `n` people labeled from `1` to `n`. There is a rumor that one of these people is secretly the town judge.

If the town judge exists, then:

1. The town judge trusts nobody.
2. Everybody (except for the town judge) trusts the town judge.
3. There is exactly one person that satisfies properties **1** and **2**.

You are given an array `trust` where `trust[i] = [ai, bi]` representing that the person labeled `ai` trusts the person labeled `bi`.

Return *the label of the town judge if the town judge exists and can be identified, or return* `-1` *otherwise*.

 ```java
 public int findJudge(int n, int[][] trust) {
         if (trust.length < n - 1) {
             return -1;
         }
         
          if (n == 1 && trust.length == 0) {
             return n;
         }
 
         Map<Integer, Integer> map = new HashMap<>();
 
         for (int[] item : trust) {
             int label = item[0];
             int trustedLabel = item[1];
 
             if (map.containsKey(label)) {
                 int currentNum = map.get(label);
                 map.put(label, currentNum - 1);
             } else {
                 map.put(label, -1);
             }
             
             if (map.containsKey(trustedLabel)) {
                 int currentNum = map.get(trustedLabel);
                 map.put(trustedLabel, currentNum + 1);
             } else {
                 map.put(trustedLabel, 1);
             }
         }
 
 
         for (Integer key : map.keySet()) {
             int value = map.get(key);
             if (n == value + 1) {
                 return key;
             }
 
         }
 
         return -1;
         
     }
 ```



```java
 public int findJudge(int n, int[][] trust) {
        if (trust.length < n - 1) {
            return -1;
        }

        int[] flag = new int[n + 1];

        for (int[] item : trust) {
            int label = item[0];
            int trustedLabel = item[1];
            flag[label] = flag[label] - 1;
            flag[trustedLabel] = flag[trustedLabel] + 1;
        }

        for (int i = 1; i < flag.length; i++) {
            int value = flag[i];
            if (n == value + 1) {
                return i;
            }

        }

        return -1;

    }
```



## 1022. Sum of Root To Leaf Binary Numbers

Recursion

```java
    private static int rootToLeaf = 0;

    public static void preorder(TreeNode r, int currNumber) {
        if (r != null) {
            currNumber = (currNumber << 1) | r.val;
            // if it's a leaf, update root-to-leaf sum
            if (r.left == null && r.right == null) {
                rootToLeaf += currNumber;
            }
            preorder(r.left, currNumber);
            preorder(r.right, currNumber);
        }
    }

    public static int sumRootToLeaf(TreeNode root) {
        preorder(root, 0);
        return rootToLeaf;
    }

```

Iteration

```java
    public static int sumRootToLeafIterator(TreeNode root) {
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(root, 0));

        int sum = 0;

        while (!queue.isEmpty()) {
            Pair<TreeNode, Integer> curPair = queue.poll();
            TreeNode curNode = curPair.getKey();
            Integer currNumber = curPair.getValue();
            currNumber = (currNumber << 1) | curNode.val;
            // if it's a leaf, update root-to-leaf sum
            if (curNode.left == null && curNode.right == null) {
                sum += currNumber;
            }

            if (curNode.left != null) {
                queue.add(new Pair<>(curNode.left, currNumber));
            }
            if (curNode.right != null) {
                queue.add(new Pair<>(curNode.right, currNumber));
            }
        }
        return sum;
    }

```



## 1137. N-th Tribonacci Number

The Tribonacci sequence Tn is defined as follows: 

T0 = 0, T1 = 1, T2 = 1, and Tn+3 = Tn + Tn+1 + Tn+2 for n >= 0.

Given `n`, return the value of Tn.

 ```java
     public static int tribonacci(int n) {
         if (n == 0) {
             return 0;
         } else if ((n == 1 || n == 2)) {
             return 1;
         }
 
         return tribonacci(n - 3) + tribonacci(n - 2) +
                 tribonacci(n - 1);
 
     }
 ```



```java
    private static final Map<Integer, Integer> map = new HashMap<>();

    public static int tribonacci1(int n) {
        map.put(0, 0);
        map.put(1, 1);
        map.put(2, 1);
        if (!map.containsKey(n)) {
            map.put(n, tribonacci1(n - 3) + tribonacci1(n - 2) +
                    tribonacci1(n - 1));
        }
        return map.get(n);
    }

```

```java
    public static int tribonacci2(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }

        int pre = 0;
        int sec = 1;
        int thr = 1;
        int res = 0;

        for (int i = 3; i <= n; i++) {
            res = pre + sec + thr;
            pre = sec;
            sec = thr;
            thr = res;
        }

        return res;
    }
```



## 2109. Adding Spaces to a String

You are given a 0-indexed string s and a 0-indexed integer array spaces that describes the indices in the original string where spaces will be added. Each space should be inserted before the character at the given index.

```java
public static String addSpaces(String s, int[] spaces) {
    int spaceIndex = 0;
    int maxSpaceIndex = spaces.length;

    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < s.length(); i++) {
        if (spaceIndex >= maxSpaceIndex) {
            sb.append(s.charAt(i));
            continue;
        }

        if (i == spaces[spaceIndex]) {
            sb.append(" ");
            spaceIndex++;
        }

        sb.append(s.charAt(i));
    }

    return sb.toString();
}
```
