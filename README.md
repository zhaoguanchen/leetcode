# leetcode

 leetcode solution

[TOC]


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
