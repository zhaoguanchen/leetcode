# Leetcode and Java

[![License](https://img.shields.io/badge/license-Apache_2.0-blue.svg)](LICENSE.md) [![Build Status](https://travis-ci.org/fishercoder1534/Leetcode.svg?branch=master)](https://travis-ci.org/fishercoder1534/Leetcode) ![Language](https://img.shields.io/badge/language-Java-blue.svg) ![Language](https://img.shields.io/badge/Leetcode-blue.svg)![Language](https://img.shields.io/badge/Algorithm-blue.svg)

_If you like this project, please leave me a star._ &#9733;

## Description
The project is divided into two parts: `structure` and `solution`.

`structure` package contains the data structure required for the question, such as `TreeNode` for the binary tree question, `ListNode` for the linked list question, etc.

`solution` package contains the leetcode algorithm problems, packaged by solution type.



## Problems

### Data Structure

| No.  | Title                                            | Short Description                                            |
| ---- | ------------------------------------------------ | ------------------------------------------------------------ |
| 1    | [TreeNode](src/leetcode/structure/TreeNode.java) | Definition for the Binary Tree node. <br />- construct List by Integer Array.<br />- print the Binary Tree with level order. |
| 2    | [ListNode](src/leetcode/structure/ListNode.java) | Definition for the LinkedList node. <br />- construct List by Integer Array.<br />- construct by value.<br />- set cycle(to solve the cycle problems).<br />- print the LinkedList. |
| 3    | [Node](src/leetcode/structure/Node.java)         | Definition for the Tree node with next right pointers. <br />- construct List by Integer Array. |
| 4    | [NNode](src/leetcode/structure/NNode.java)       | Definition for the N-ary Tree node. <br />- construct List by Integer Array.<br />- construct by value. |





### Classification

#### [LinkedList](src/leetcode/solution/LinkedList)

**Reverse**

| No.  | Title                                                        | Difficulty | Solution                                                     | Idea                                                         |
| ---- | ------------------------------------------------------------ | ---------- | ------------------------------------------------------------ | ------------------------------------------------------------ |
| 206  | [Reverse Linked List](https://leetcode.com/problems/reverse-linked-list/) | Easy       | [ReverseLinkedList.java](src/leetcode/solution/LinkedList/reverse/ReverseLinkedList.java) | Iteration \| Recursion                                       |
| 92   | [Reverse Linked List II](https://leetcode.com/problems/reverse-linked-list-ii/) | Medium     | [ReverseLinkedListII.java](src/leetcode/solution/LinkedList/reverse/ReverseLinkedListII.java) | Iteration \| Recursion<br />Reverse Linked List between a-th and b-th. At first, we can move to a-th, and the problem becomes  Reverse Top N nodes. |
| 25   | [Reverse Nodes in k-Group](https://leetcode.com/problems/reverse-nodes-in-k-group/) | Hard       | [ReverseNodesInkGroup.java](src/leetcode/solution/LinkedList/reverse/ReverseNodesInkGroup.java) | For each k group, reverse Linked List between head and k-th. Let head equal k+1th node, then do Recursion. |
| 234  | [Palindrome Linked List](https://leetcode.com/problems/palindrome-linked-list/) | Easy       | [PalindromeLinkedList.java](src/leetcode/solution/LinkedList/reverse/PalindromeLinkedList.java) | 1. Using a pointer that points to the node from the start location. Recursion and move pointer forward. Compare.<br />2. Reverse the whole List.<br />3. Reverse the second-half List |



**Two Pointer** 

| No.  | Title                                                        | Difficulty | Solution                                                     | Idea                   |
| ---- | ------------------------------------------------------------ | ---------- | ------------------------------------------------------------ | ---------------------- |
| 206  | [Reverse Linked List](https://leetcode.com/problems/reverse-linked-list/) | Easy       | [ReverseLinkedList.java](src/leetcode/solution/LinkedList/reverse/ReverseLinkedList.java) | Iteration \| Recursion |





#### [DataStruct](src/leetcode/solution/DataStruct)

| No.  | Title                                                        | Difficulty | Solution                                                     | Idea                                                         |
| ---- | ------------------------------------------------------------ | ---------- | ------------------------------------------------------------ | ------------------------------------------------------------ |
| 705  | [Design HashSet](https://leetcode.com/problems/design-hashset/) | Easy       | [DesignHashSet.java](src/leetcode/solution/DataStruct/DesignHashSet.java) | Array + LinkedList                                           |
| 706  | [Design HashMap](https://leetcode.com/problems/design-hashmap/) | Easy       | [DesignHashMap.java](src/leetcode/solution/DataStruct/DesignHashMap.java) | Array + LinkedList                                           |
| 706  | [Design Underground System](https://leetcode.com/problems/design-underground-system/) | Medium     | [DesignUndergroundSystem.java](src/leetcode/solution/DataStruct/DesignUndergroundSystem.java) | using two HashMap. One saves the check-in record, another saves the data of the current stage. |
| 1166 | [Design File System](https://leetcode.com/problems/design-file-system/) | Medium     | [DesignFileSystem.java](src/leetcode/solution/DataStruct/DesignFileSystem.java) | - 1. **Trie**: using HashMap as the child list.              |





#### [Tree](src/leetcode/solution/tree)

##### [Binary Tree](src/leetcode/solution/tree/bst)

| No.  | Title                                                        | Difficulty | Solution                                                     | Idea |
| ---- | ------------------------------------------------------------ | ---------- | ------------------------------------------------------------ | ---- |
| 199  | [Binary Tree Right Side View](https://leetcode.com/problems/binary-tree-right-side-view/) | Medium     | [BinaryTreeRightSideView.java](src/leetcode/solution/tree/BinaryTreeRightSideView.java) |      |
|      |                                                              |            |                                                              |      |
|      |                                                              |            |                                                              |      |
|      |                                                              |            |                                                              |      |
|      |                                                              |            |                                                              |      |


##### [Binary Search Tree](src/leetcode/solution/tree/bst)

| No.  | Title                                                        | Difficulty | Solution                                                     | Idea |
| ---- | ------------------------------------------------------------ | ---------- | ------------------------------------------------------------ | ---- |
| 173  | [Binary Search Tree Iterator](https://leetcode.com/problems/binary-search-tree-iterator/) | Medium     | [BinarySearchTreeIterator.java](src/leetcode/solution/tree/bst/BinarySearchTreeIterator.java) |      |
|      |                                                              |            |                                                              |      |
|      |                                                              |            |                                                              |      |
|      |                                                              |            |                                                              |      |
|      |                                                              |            |                                                              |      |



#### [Backtrack](src/leetcode/solution/backtrack)

| No.  | Title                                                        | Difficulty | Solution                                                     | Idea      |
| ---- | ------------------------------------------------------------ | ---------- | ------------------------------------------------------------ | --------- |
| 39   | [Combination Sum](https://leetcode.com/problems/combination-sum/) | Medium     | [CombinationSum.java](src/leetcode/solution/backtrack/CombinationSum.java) | Backtrack |
| 40   | [Combination Sum II](https://leetcode.com/problems/combination-sum-II/) | Medium     | [CombinationSumII.java](src/leetcode/solution/backtrack/CombinationSumII.java) | Backtrack |
| 46   | [Permutations](https://leetcode.com/problems/permutations/)  | Medium     | [Permutations.java](src/leetcode/solution/backtrack/Permutations.java) | Backtrack |
| 47   | [Permutations II](https://leetcode.com/problems/permutations-ii/) | Medium     | [PermutationsII.java](src/leetcode/solution/backtrack/PermutationsII.java) | Backtrack |
| 77   | [Combinations](https://leetcode.com/problems/combinations/)  | Medium     | [Combinations.java](src/leetcode/solution/backtrack/Combinations.java) | Backtrack |
| 78   | [Subsets](https://leetcode.com/problems/subsets/)            | Medium     | [Subset.java](src/leetcode/solution/backtrack/Subset.java)   | Backtrack |
| 79   | [Word Search](https://leetcode.com/problems/word-search/)    | Medium     | [WordSearch.java](src/leetcode/solution/backtrack/WordSearch.java) | Backtrack |
| 90   | [Subsets II](https://leetcode.com/problems/subsets-ii/)      | Medium     | [SubsetII.java](src/leetcode/solution/backtrack/SubsetII.java) | Backtrack |
| 93   | [Restore IP Addresses](https://leetcode.com/problems/restore-ip-addresses/) | Medium     | [RestoreIPAddresses.java](src/leetcode/solution/backtrack/RestoreIPAddresses.java) | Backtrack |
| 95   | [Unique Binary Search Trees II](https://leetcode.com/problems/unique-binary-search-trees-ii/) | Medium     | [UniqueBinarySearchTreesII.java](src/leetcode/solution/backtrack/UniqueBinarySearchTreesII.java) | Backtrack |
| 113  | [Path Sum II](https://leetcode.com/problems/path-sum-ii/)    | Medium     | [PathSumII.java](src/leetcode/solution/backtrack/PathSumII.java) | Backtrack |
|      |                                                              |            |                                                              |           |

#### [DFS](src/leetcode/solution/DFS)

**Island**

| No.  | Title                                                        | Difficulty | Solution                                                     | Idea                                                         |
| ---- | ------------------------------------------------------------ | ---------- | ------------------------------------------------------------ | ------------------------------------------------------------ |
| 200  | [Number of Islands](https://leetcode.com/problems/number-of-islands/) | Medium     | [NumberOfIslands.java](src/leetcode/solution/DFS/NumberOfIslands.java) | DFS \| Remove the island and count                           |
| 1254 | [Number of Closed Islands](https://leetcode.com/problems/number-of-closed-islands/) | Medium     | [NumberOfClosedIslands.java](src/leetcode/solution/DFS/NumberOfClosedIslands.java) | DFS \| Remove the island close to the border, then Remove other islands and count. |
| 695  | [Max Area of Island](https://leetcode.com/problems/max-area-of-island/) | Medium     | [MaxAreaOfIsland.java](src/leetcode/solution/DFS/MaxAreaOfIsland.java) | DFS \| Remove the island and count the area of each island. Return the max value. |
| 694  | [Number of Distinct Islands](https://leetcode.com/problems/number-of-distinct-islands/) | Medium     | [NumberOfDistinctIslands.java](src/leetcode/solution/DFS/NumberOfDistinctIslands.java) | DFS \| remove the island and record the path, which could reflect the shape of the island, use HashSet to save the distinct path. |
| 1905 | [Count Sub Islands](https://leetcode.com/problems/count-sub-islands/) | Medium     | [CountSubIslands.java](src/leetcode/solution/DFS/CountSubIslands.java) | DFS \| At first, remove the island that is not sub island. Then, remove the island and count. |
| 1020 | [Number of Enclaves](https://leetcode.com/problems/number-of-enclaves/) | Medium     | [NumberOfEnclaves.java](src/leetcode/solution/DFS/NumberOfEnclaves.java) | DFS \| Remove the island close to the border, then Remove other islands and count. Same as problem '1254'. |





#### [BFS]()

| No.  | Title                                                        | Difficulty | Solution                                                     | Idea           |
| ---- | ------------------------------------------------------------ | ---------- | ------------------------------------------------------------ | -------------- |
| 752  | [Open the Lock](https://leetcode.com/problems/open-the-lock/) | Medium     | [OpenTheLock.java](src/leetcode/solution/BFS/OpenTheLock.java) | BFS with Queue |
|      |                                                              |            |                                                              |                |
|      |                                                              |            |                                                              |                |

#### [Array](src/leetcode/solution/array)

| No.  | Title                                                        | Difficulty | Solution                                                     | Idea                                                         |
| ---- | ------------------------------------------------------------ | ---------- | ------------------------------------------------------------ | ------------------------------------------------------------ |
| 412  | [Fizz Buzz](https://leetcode.com/problems/fizz-buzz/)        | Easy       | [FizzBuzz.java](src/leetcode/solution/array/FizzBuzz.java)   | For loop. Calculate i%5 and i%3 separately.                  |
| 768  | [Max Chunks To Make Sorted II](https://leetcode.com/problems/max-chunks-to-make-sorted-ii/) | Hard       | [MaxChunksToMakeSortedII.java](src/leetcode/solution/array/MaxChunksToMakeSortedII.java) | Iterate through the array, each time all elements to the left are smaller (or equal) to all elements to the right, there is a new chunk. |
| 769  | [Max Chunks To Make Sorted](https://leetcode.com/problems/max-chunks-to-make-sorted/) | Medium     | [MaxChunksToMakeSorted.java](src/leetcode/solution/array/MaxChunksToMakeSortedII.java) | Iterate through the array,  each time the maximum value of all elements to the left equals the index, there is a new chunk. |
|      |                                                              |            |                                                              |                                                              |

#### [String](src/leetcode/solution/string)

| No.  | Title                                                        | Difficulty | Solution                                                     | Idea              |
| ---- | ------------------------------------------------------------ | ---------- | ------------------------------------------------------------ | ----------------- |
| 2027 | [Minimum Moves to Convert String](https://leetcode.com/problems/minimum-moves-to-convert-string/) | Easy       | [MinimumMovesToConvertString.java](src/leetcode/solution/string/MinimumMovesToConvertString.java) | Pointer and Count |
| 535  | [Encode and Decode TinyURL](https://leetcode.com/problems/encode-and-decode-tinyurl/) | Medium     | [EncodeAndDecodeTinyURL.java](src/leetcode/solution/string/EncodeAndDecodeTinyURL.java) | HashMap           |
|      |                                                              |            |                                                              |                   |
|      |                                                              |            |                                                              |                   |
