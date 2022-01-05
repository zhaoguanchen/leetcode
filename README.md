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
