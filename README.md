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
