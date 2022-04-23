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

#### [Backtrack](src/leetcode/solution/backtrack)

| No.  | Title   | Difficulty | Solution                                                   | Idea |
| ---- | ------- | ---------- | ---------------------------------------------------------- | ---- |
| 39   | [Combination Sum](https://leetcode.com/problems/combination-sum/)     | Medium     | [CombinationSum.java](src/leetcode/solution/backtrack/CombinationSum.java) | Backtrack |
| 40   | [Combination Sum II](https://leetcode.com/problems/combination-sum-II/) | Medium     | [CombinationSumII.java](src/leetcode/solution/backtrack/CombinationSumII.java) | Backtrack |
| 46   | [Permutations](https://leetcode.com/problems/permutations/)           | Medium | [Permutations.java](src/leetcode/solution/backtrack/Permutations.java) | Backtrack |
| 47 | [Permutations II](https://leetcode.com/problems/permutations-ii/) | Medium | [PermutationsII.java](src/leetcode/solution/backtrack/PermutationsII.java) | Backtrack |
| 77 | [Combinations](https://leetcode.com/problems/combinations/) | Medium | [Combinations.java](src/leetcode/solution/backtrack/Combinations.java) | Backtrack |
| 78   | [Subsets](https://leetcode.com/problems/subsets/) 	                   | Medium    | [Subset.java](src/leetcode/solution/backtrack/Subset.java) | Backtrack |
| 79 | [Word Search](https://leetcode.com/problems/word-search/) | Medium | [WordSearch.java](src/leetcode/solution/backtrack/WordSearch.java) | Backtrack |
| 90 | [Subsets II](https://leetcode.com/problems/subsets-ii/) | Medium | [SubsetII.java](src/leetcode/solution/backtrack/SubsetII.java) | Backtrack |
| 93 | [Restore IP Addresses](https://leetcode.com/problems/restore-ip-addresses/) | Medium | [RestoreIPAddresses.java](src/leetcode/solution/backtrack/RestoreIPAddresses.java) | Backtrack |
| 95 | [Unique Binary Search Trees II](https://leetcode.com/problems/unique-binary-search-trees-ii/) | Medium | [UniqueBinarySearchTreesII.java](src/leetcode/solution/backtrack/UniqueBinarySearchTreesII.java) | Backtrack |
| 113 | [Path Sum II](https://leetcode.com/problems/path-sum-ii/) | Medium | [PathSumII.java](src/leetcode/solution/backtrack/PathSumII.java) | Backtrack |
|  |  |  |  | |

#### [DFS]()

#### [BFS]()

| No.  | Title                                                        | Difficulty | Solution                                                     | Idea           |
| ---- | ------------------------------------------------------------ | ---------- | ------------------------------------------------------------ | -------------- |
| 752  | [Open the Lock](https://leetcode.com/problems/open-the-lock/) | Medium     | [OpenTheLock.java](src/leetcode/solution/DataStruct/OpenTheLock.java) | BFS with Queue |
|      |                                                              |            |                                                              |                |
|      |                                                              |            |                                                              |                |



#### [Array](src/leetcode/solution/array)

| No.  | Title                                                        | Difficulty | Solution                                                     | Idea                                                         |
| ---- | ------------------------------------------------------------ | ---------- | ------------------------------------------------------------ | ------------------------------------------------------------ |
| 412  | [Fizz Buzz](https://leetcode.com/problems/fizz-buzz/)        | Easy       | [FizzBuzz.java](src/leetcode/solution/array/FizzBuzz.java)   |                                                              |
| 768  | [Max Chunks To Make Sorted II](https://leetcode.com/problems/max-chunks-to-make-sorted-ii/) | Hard       | [MaxChunksToMakeSortedII.java](src/leetcode/solution/array/MaxChunksToMakeSortedII.java) | Iterate through the array, each time all elements to the left are smaller (or equal) to all elements to the right, there is a new chunk. |
| 769  | [Max Chunks To Make Sorted](https://leetcode.com/problems/max-chunks-to-make-sorted/) | Medium     | [MaxChunksToMakeSorted.java](src/leetcode/solution/array/MaxChunksToMakeSortedII.java) | Iterate through the array,  each time the maximum value of all elements to the left equals the index, there is a new chunk. |
|      |                                                              |            |                                                              |                                                              |

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


#### [DataStruct](src/leetcode/solution/DataStruct)

| No.  | Title                                                        | Difficulty | Solution                                                     | Idea               |
| ---- | ------------------------------------------------------------ | ---------- | ------------------------------------------------------------ | ------------------ |
| 705  | [Design HashSet](https://leetcode.com/problems/design-hashset/) | Easy       | [DesignHashSet.java](src/leetcode/solution/DataStruct/DesignHashSet.java) | Array + LinkedList |
| 706  | [Design HashMap](https://leetcode.com/problems/design-hashmap/) | Easy       | [DesignHashMap.java](src/leetcode/solution/DataStruct/DesignHashMap.java) | Array + LinkedList |
|      |                                                              |            |                                                              |                    |
|      |                                                              |            |                                                              |                    |

#### [String](src/leetcode/solution/string)

| No.  | Title                                                        | Difficulty | Solution                                                     | Idea              |
| ---- | ------------------------------------------------------------ | ---------- | ------------------------------------------------------------ | ----------------- |
| 2027 | [Minimum Moves to Convert String](https://leetcode.com/problems/minimum-moves-to-convert-string/) | Easy       | [MinimumMovesToConvertString.java](src/leetcode/solution/string/MinimumMovesToConvertString.java) | Pointer and Count |
| 535  | [Encode and Decode TinyURL](https://leetcode.com/problems/encode-and-decode-tinyurl/) | Medium     | [EncodeAndDecodeTinyURL.java](src/leetcode/solution/string/EncodeAndDecodeTinyURL.java) | HashMap           |
|      |                                                              |            |                                                              |                   |
|      |                                                              |            |                                                              |                   |
