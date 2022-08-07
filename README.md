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



### [Utils](src/leetcode/utils)

 Tool class for handling issues such as format conversions.

| No.  | Title                                                 | Short Description                                            |
| ---- | ----------------------------------------------------- | ------------------------------------------------------------ |
| 1    | [InputUtils.java](src/leetcode/utils/InputUtils.java) | Handle Input Data Format<br />-`java int[][] generateGrid(int m, int n, String s) `: convert String like "[[0,1],[0,2]]" to grid. |



### Classification

#### [LinkedList](src/leetcode/solution/LinkedList)

**Reverse**

| No.  | Title                                                        | Difficulty | Solution                                                     | Idea                                                         |
| ---- | ------------------------------------------------------------ | ---------- | ------------------------------------------------------------ | ------------------------------------------------------------ |
| 92   | [Reverse Linked List II](https://leetcode.com/problems/reverse-linked-list-ii/) | Medium     | [ReverseLinkedListII.java](src/leetcode/solution/LinkedList/reverse/ReverseLinkedListII.java) | Iteration \| Recursion<br />Reverse Linked List between `a` and `b`. At first, we can move to a-th, and the problem becomes  Reverse Top N nodes. |
| 25   | [Reverse Nodes in k-Group](https://leetcode.com/problems/reverse-nodes-in-k-group/) | Hard       | [ReverseNodesInkGroup.java](src/leetcode/solution/LinkedList/reverse/ReverseNodesInkGroup.java) | For each k group, reverse Linked List between head and k-th. Let head equal k+1th node, then do Recursion. |
| 234  | [Palindrome Linked List](https://leetcode.com/problems/palindrome-linked-list/) | Easy       | [PalindromeLinkedList.java](src/leetcode/solution/LinkedList/reverse/PalindromeLinkedList.java) | 1. Using a pointer that points to the node from the start location. Recursion and move pointer forward. Compare.<br />2. Reverse the whole List.<br />3. Reverse the second-half List |
| 143  | [Reorder List](https://leetcode.com/problems/reorder-list/)  | Easy       | [ReorderList.java](src/leetcode/solution/LinkedList/ReorderList.java) | Reverse the second-half List and Merge                       |
| 147  | [Insertion Sort List](https://leetcode.com/problems/insertion-sort-list/) | Easy       | [InsertionSortList.java](src/leetcode/solution/LinkedList/InsertionSortList.java) | Virtual Head Node                                            |
| 206  | [Reverse Linked List](https://leetcode.com/problems/reverse-linked-list/) | Easy       | [ReverseLinkedList.java](src/leetcode/solution/LinkedList/reverse/ReverseLinkedList.java) | Iteration \| Recursion                                       |
| 2130 | [Maximum Twin Sum of a Linked List](https://leetcode.com/problems/maximum-twin-sum-of-a-linked-list/) | Medium     | [MaximumTwinSumOfALinkedList.java](src/leetcode/solution/LinkedList/MaximumTwinSumOfALinkedList.java) | Reverse the second-half List                                 |

**Two Pointer** 

| No.  | Title                                                        | Difficulty | Solution                                                     | Idea          |
| ---- | ------------------------------------------------------------ | ---------- | ------------------------------------------------------------ | ------------- |
| 160  | [Intersection of Two Linked Lists](https://leetcode.com/problems/intersection-of-two-linked-lists/) | Easy       | [IntersectionOfTwoLinkedLists.java](src/leetcode/solution/LinkedList/twopoint/IntersectionOfTwoLinkedLists.java) | Hash \| A + B |

#### [Design](src/leetcode/solution/DataStruct)

| No.  | Title                                                        | Difficulty | Solution                                                     | Idea                                                         |
| ---- | ------------------------------------------------------------ | ---------- | ------------------------------------------------------------ | ------------------------------------------------------------ |
| 341  | [Flatten Nested List Iterator](https://leetcode.com/problems/flatten-nested-list-iterator/) | Medium     | [FlattenNestedListIterator.java](src/leetcode/solution/DataStruct/FlattenNestedListIterator.java) | LinkedList, Deque, or Stack.                                 |
| 348  | [Design Tic-Tac-Toe](https://leetcode.com/problems/design-tic-tac-toe/) | Medium     | [DesignTicTacToe.java](src/leetcode/solution/DataStruct/DesignTicTacToe.java) | using Array.                                                 |
| 380  | [Insert Delete GetRandom O(1)](https://leetcode.com/problems/insert-delete-getrandom-o1/) | Medium     | [InsertDeleteGetRandom.java](src/leetcode/solution/DataStruct/InsertDeleteGetRandom.java) | HashMap + ArrayList                                          |
| 622  | [Design Circular Queue](https://leetcode.com/problems/design-circular-queue/) | Medium     | [DesignCircularQueue.java](src/leetcode/solution/DataStruct/DesignCircularQueue.java) | Using Array and Pointer.                                     |
| 705  | [Design HashSet](https://leetcode.com/problems/design-hashset/) | Easy       | [DesignHashSet.java](src/leetcode/solution/DataStruct/DesignHashSet.java) | Array + LinkedList                                           |
| 706  | [Design HashMap](https://leetcode.com/problems/design-hashmap/) | Easy       | [DesignHashMap.java](src/leetcode/solution/DataStruct/DesignHashMap.java) | Array + LinkedList                                           |
| 1166 | [Design File System](https://leetcode.com/problems/design-file-system/) | Medium     | [DesignFileSystem.java](src/leetcode/solution/DataStruct/DesignFileSystem.java) | - 1. **Trie**: using HashMap as the child list.              |
| 1396 | [Design Underground System](https://leetcode.com/problems/design-underground-system/) | Medium     | [DesignUndergroundSystem.java](src/leetcode/solution/DataStruct/DesignUndergroundSystem.java) | using two HashMap. One saves the check-in record, another saves the data of the current stage. |
| 2102 | [Sequentially Ordinal Rank Tracker](https://leetcode.com/problems/sequentially-ordinal-rank-tracker/) | Hard       | [SequentiallyOrdinalRankTracker.java](src/leetcode/solution/DataStruct/SequentiallyOrdinalRankTracker.java) | Two Heap.                                                    |

#### [Tree](src/leetcode/solution/tree)

##### [Binary Tree](src/leetcode/solution/tree/bst)

| No.  | Title                                                        | Difficulty | Solution                                                     | Idea                                                         |
| ---- | ------------------------------------------------------------ | ---------- | ------------------------------------------------------------ | ------------------------------------------------------------ |
| 108  | [Convert Sorted Array to Binary Search Tree](https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/) | Medium     | [ConvertSortedArrayToBinarySearchTree.java](src/leetcode/solution/tree/ConvertSortedArrayToBinarySearchTree.java) | DFS                                                          |
| 129  | [Sum Root to Leaf Numbers](https://leetcode.com/problems/sum-root-to-leaf-numbers/) | Medium     | [SumRootOoLeafNumbers.java](src/leetcode/solution/tree/SumRootOoLeafNumbers.java) | DFS                                                          |
| 199  | [Binary Tree Right Side View](https://leetcode.com/problems/binary-tree-right-side-view/) | Medium     | [BinaryTreeRightSideView.java](src/leetcode/solution/tree/BinaryTreeRightSideView.java) | DFS                                                          |
| 515  | [Find Largest Value in Each Tree Row](https://leetcode.com/problems/find-largest-value-in-each-tree-row/) | Medium     | [FindLargestValueInEachTreeRow.java](src/leetcode/solution/tree/FindLargestValueInEachTreeRow.java) | BFS \|DFS                                                    |
| 404  | [Sum of Left Leaves](https://leetcode.com/problems/sum-of-left-leaves/) | Easy       | [SumOfLeftLeaves.java](src/leetcode/solution/tree/SumOfLeftLeaves.java) | DFS                                                          |
| 513  | [Find Bottom Left Tree Value](https://leetcode.com/problems/find-bottom-left-tree-value/) | Medium     | [FindBottomLeftTreeValue.java](src/leetcode/solution/tree/FindBottomLeftTreeValue.java) | DFS                                                          |
| 617  | [Merge Two Binary Trees](https://leetcode.com/problems/merge-two-binary-trees/) | Easy       | [MergeTwoBinaryTrees.java](src/leetcode/solution/tree/MergeTwoBinaryTrees.java) | DFS                                                          |
| 662  | [Maximum Width of Binary Tree](https://leetcode.com/problems/maximum-width-of-binary-tree/) | Medium     | [MaximumWidthOfBinaryTree.java](src/leetcode/solution/tree/MaximumWidthOfBinaryTree.java) | BFS \|DFS + The relationship of the index between the father node and the child node. |
| 979  | [Distribute Coins in Binary Tree](https://leetcode.com/problems/distribute-coins-in-binary-tree/) | Medium     | [DistributeCoinsInBinaryTree.java](src/leetcode/solution/tree/DistributeCoinsInBinaryTree.java) | DFS                                                          |
| 1302 | [Deepest Leaves Sum](https://leetcode.com/problems/deepest-leaves-sum/) | Medium     | [DeepestLeavesSum.java](src/leetcode/solution/tree/DeepestLeavesSum.java) | BFS \| DFS                                                   |
| 1379 | [Find a Corresponding Node of a Binary Tree in a Clone of That Tree](https://leetcode.com/problems/find-a-corresponding-node-of-a-binary-tree-in-a-clone-of-that-tree/) | Medium     | [FindACorrespondingNodeOfABinaryTreeInACloneOfThatTree.java](src/leetcode/solution/tree/FindACorrespondingNodeOfABinaryTreeInACloneOfThatTree.java) | inorder traversal                                            |
| 2265 | [Count Nodes Equal to Average of Subtree](https://leetcode.com/problems/count-nodes-equal-to-average-of-subtree/) | Medium     | [CountNodesEqualToAverageOfSubtree.java](src/leetcode/solution/tree/CountNodesEqualToAverageOfSubtree.java) | Postorder  traversal                                         |

##### [Binary Search Tree](src/leetcode/solution/tree/bst)

| No.  | Title                                                        | Difficulty | Solution                                                     | Idea               |
| ---- | ------------------------------------------------------------ | ---------- | ------------------------------------------------------------ | ------------------ |
| 173  | [Binary Search Tree Iterator](https://leetcode.com/problems/binary-search-tree-iterator/) | Medium     | [BinarySearchTreeIterator.java](src/leetcode/solution/tree/bst/BinarySearchTreeIterator.java) |                    |
| 230  | [Kth Smallest Element in a BST](https://leetcode.com/problems/kth-smallest-element-in-a-bst/) | Medium     | [KthSmallestElementInABST.java](src/leetcode/solution/tree/bst/KthSmallestElementInABST.java) | Preorder traversal |

##### [Complete Tree](src/leetcode/solution/tree/bst)

| No.  | Title                                                        | Difficulty | Solution                                                     | Idea                              |
| ---- | ------------------------------------------------------------ | ---------- | ------------------------------------------------------------ | --------------------------------- |
| 222  | [Count Complete Tree Nodes](https://leetcode.com/problems/count-complete-tree-nodes/) | Medium     | [CountCompleteTreeNodes.java](src/leetcode/solution/tree/completeBinaryTree/CountCompleteTreeNodes.java) | Consider left and right separatly |

#### [Backtrack](src/leetcode/solution/backtrack)

| No.  | Title                                                        | Difficulty | Solution                                                     | Idea             |
| ---- | ------------------------------------------------------------ | ---------- | ------------------------------------------------------------ | ---------------- |
| 17   | [Letter Combinations of a Phone Number](https://leetcode.com/problems/letter-combinations-of-a-phone-number/) | Medium     | [LetterCombinationsPhoneNumber.java](src/leetcode/solution/backtrack/LetterCombinationsPhoneNumber.java) | Backtrack        |
| 39   | [Combination Sum](https://leetcode.com/problems/combination-sum/) | Medium     | [CombinationSum.java](src/leetcode/solution/backtrack/CombinationSum.java) | Backtrack        |
| 40   | [Combination Sum II](https://leetcode.com/problems/combination-sum-II/) | Medium     | [CombinationSumII.java](src/leetcode/solution/backtrack/CombinationSumII.java) | Backtrack        |
| 46   | [Permutations](https://leetcode.com/problems/permutations/)  | Medium     | [Permutations.java](src/leetcode/solution/backtrack/Permutations.java) | Backtrack        |
| 47   | [Permutations II](https://leetcode.com/problems/permutations-ii/) | Medium     | [PermutationsII.java](src/leetcode/solution/backtrack/PermutationsII.java) | Backtrack        |
| 51   | [N-Queens](https://leetcode.com/problems/n-queens/)          | Hard       | [NQueens.java](src/leetcode/solution/backtrack/NQueens.java) | Backtrack + Memo |
| 52   | [N-Queens II](https://leetcode.com/problems/n-queens-ii/)    | Hard       | [NQueensII.java](src/leetcode/solution/backtrack/NQueensII.java) | Backtrack + Memo |
| 77   | [Combinations](https://leetcode.com/problems/combinations/)  | Medium     | [Combinations.java](src/leetcode/solution/backtrack/Combinations.java) | Backtrack        |
| 78   | [Subsets](https://leetcode.com/problems/subsets/)            | Medium     | [Subset.java](src/leetcode/solution/backtrack/Subset.java)   | Backtrack        |
| 79   | [Word Search](https://leetcode.com/problems/word-search/)    | Medium     | [WordSearch.java](src/leetcode/solution/backtrack/WordSearch.java) | Backtrack        |
| 90   | [Subsets II](https://leetcode.com/problems/subsets-ii/)      | Medium     | [SubsetII.java](src/leetcode/solution/backtrack/SubsetII.java) | Backtrack        |
| 93   | [Restore IP Addresses](https://leetcode.com/problems/restore-ip-addresses/) | Medium     | [RestoreIPAddresses.java](src/leetcode/solution/backtrack/RestoreIPAddresses.java) | Backtrack        |
| 95   | [Unique Binary Search Trees II](https://leetcode.com/problems/unique-binary-search-trees-ii/) | Medium     | [UniqueBinarySearchTreesII.java](src/leetcode/solution/backtrack/UniqueBinarySearchTreesII.java) | Backtrack        |
| 113  | [Path Sum II](https://leetcode.com/problems/path-sum-ii/)    | Medium     | [PathSumII.java](src/leetcode/solution/backtrack/PathSumII.java) | Backtrack        |
| 216  | [Combination Sum III](https://leetcode.com/problems/combination-sum-iii/) | Medium     | [CombinationSumIII.java](src/leetcode/solution/backtrack/CombinationSumIII.java) | Backtrack        |

#### [DFS](src/leetcode/solution/DFS)

**Search Path**

| No.  | Title                                                        | Difficulty | Solution                                                     | Idea       |
| ---- | ------------------------------------------------------------ | ---------- | ------------------------------------------------------------ | ---------- |
| 329  | [Longest Increasing Path in a Matrix](https://leetcode.com/problems/longest-increasing-path-in-a-matrix/) | Hard       | [LongestIncreasingPathInAMatrix.java](src/leetcode/solution/DFS/LongestIncreasingPathInAMatrix.java) | DFS + Memo |
| 547  | [Number of Provinces](https://leetcode.com/problems/number-of-provinces/) | Medium     | [NumberOfProvinces.java](src/leetcode/solution/DFS/NumberOfProvinces.java) | DFS        |
| 802  | [Find Eventual Safe States](https://leetcode.com/problems/find-eventual-safe-states/) | Hard       | [LongestIncreasingPathInAMatrix.java](src/leetcode/solution/DFS/LongestIncreasingPathInAMatrix.java) | DFS + Memo |
| 2267 | [Check if There Is a Valid Parentheses String Path](https://leetcode.com/problems/check-if-there-is-a-valid-parentheses-string-path/) | Medium     | [FindEventualSafeStates.java](src/leetcode/solution/DFS/FindEventualSafeStates.java) | DFS        |

**Island**

| No.  | Title                                                        | Difficulty | Solution                                                     | Idea                                                         |
| ---- | ------------------------------------------------------------ | ---------- | ------------------------------------------------------------ | ------------------------------------------------------------ |
| 200  | [Number of Islands](https://leetcode.com/problems/number-of-islands/) | Medium     | [NumberOfIslands.java](src/leetcode/solution/DFS/NumberOfIslands.java) | DFS \| Remove the island and count                           |
| 1254 | [Number of Closed Islands](https://leetcode.com/problems/number-of-closed-islands/) | Medium     | [NumberOfClosedIslands.java](src/leetcode/solution/DFS/NumberOfClosedIslands.java) | DFS \| Remove the island close to the border, then Remove other islands and count. |
| 695  | [Max Area of Island](https://leetcode.com/problems/max-area-of-island/) | Medium     | [MaxAreaOfIsland.java](src/leetcode/solution/DFS/MaxAreaOfIsland.java) | DFS \| Remove the island and count the area of each island. Return the max value. |
| 694  | [Number of Distinct Islands](https://leetcode.com/problems/number-of-distinct-islands/) | Medium     | [NumberOfDistinctIslands.java](src/leetcode/solution/DFS/NumberOfDistinctIslands.java) | DFS \| remove the island and record the path, which could reflect the shape of the island, use HashSet to save the distinct path. |
| 1905 | [Count Sub Islands](https://leetcode.com/problems/count-sub-islands/) | Medium     | [CountSubIslands.java](src/leetcode/solution/DFS/CountSubIslands.java) | DFS \| At first, remove the island that is not sub island. Then, remove the island and count. |
| 1020 | [Number of Enclaves](https://leetcode.com/problems/number-of-enclaves/) | Medium     | [NumberOfEnclaves.java](src/leetcode/solution/DFS/NumberOfEnclaves.java) | DFS \| Remove the island close to the border, then Remove other islands and count. Same as problem '1254'. |

#### [BFS](src/leetcode/solution/BFS)

| No.  | Title                                                        | Difficulty | Solution                                                     | Idea                                                         |
| ---- | ------------------------------------------------------------ | ---------- | ------------------------------------------------------------ | ------------------------------------------------------------ |
| 752  | [Open the Lock](https://leetcode.com/problems/open-the-lock/) | Medium     | [OpenTheLock.java](src/leetcode/solution/BFS/OpenTheLock.java) | BFS with Queue                                               |
| 752  | [Network Delay Time](https://leetcode.com/problems/network-delay-time/) | Medium     | [NetworkDelayTime.java](src/leetcode/solution/BFS/NetworkDelayTime.java) | directed graph<br />BFS  \| DFS                              |
| 286  | [Walls and Gates](https://leetcode.com/problems/walls-and-gates/) | Medium     | [WallAndGates.java](src/leetcode/solution/BFS/WallAndGates.java) | BFS: spread from the gate                                    |
| 994  | [Rotting Oranges](https://leetcode.com/problems/rotting-oranges/) | Medium     | [RottingOranges.java](src/leetcode/solution/BFS/RottingOranges.java) | BFS: spread from the rotten oranges                          |
| 1091 | [Shortest Path in Binary Matrix](https://leetcode.com/problems/shortest-path-in-binary-matrix/) | Medium     | [ShortestPathInBinaryMatrix.java](src/leetcode/solution/BFS/ShortestPathInBinaryMatrix.java) | BFS: spread from (0,0). The path that arrived earliest is the shortest. |
| 1197 | [Minimum Knight Moves](https://leetcode.com/problems/minimum-knight-moves/) | Medium     | [MinimumKnightMoves.java](src/leetcode/solution/BFS/MinimumKnightMoves.java) | BFS: spread from (0,0). The path that arrived earliest is the shortest. |

#### [Array](src/leetcode/solution/array)

| No.  | Title                                                        | Difficulty | Solution                                                     | Idea                                                         |
| ---- | ------------------------------------------------------------ | ---------- | ------------------------------------------------------------ | ------------------------------------------------------------ |
| 31   | [Next Permutation](https://leetcode.com/problems/next-permutation/) | Medium     | [NextPermutation.java](src/leetcode/solution/array/NextPermutation.java) | Find the first element that is greater than the previous element, then replace it with the greater and smallest element on the right side. |
| 228  | [Summary Ranges](https://leetcode.com/problems/summary-ranges/) | Easy       | [SummaryRanges.java](src/leetcode/solution/array/SummaryRanges.java) | Two Pointer.                                                 |
| 281  | [Zigzag Iterator](https://leetcode.com/problems/zigzag-iterator/) | Medium     | [ZigzagIterator.java](src/leetcode/solution/array/ZigzagIterator.java) | Two Pointer<br />Muti Pointer or Queue for the **Follow-Up** Question. |
| 386  | [Lexicographical Numbers](https://leetcode.com/problems/lexicographical-numbers/) | Medium     | [LexicographicalNumbers.java](src/leetcode/solution/array/LexicographicalNumbers.java) | Recursion                                                    |
| 412  | [Fizz Buzz](https://leetcode.com/problems/fizz-buzz/)        | Easy       | [FizzBuzz.java](src/leetcode/solution/array/FizzBuzz.java)   | For loop. Calculate i%5 and i%3 separately.                  |
| 456  | [132 Pattern](https://leetcode.com/problems/132-pattern/)    | Medium     | [OneThreeTwoPattern.java](src/leetcode/solution/array/OneThreeTwoPattern.java) | Using Array as a Stack                                       |
| 495  | [Teemo Attacking](https://leetcode.com/problems/teemo-attacking/) | Easy       | [TeemoAttacking.java](src/leetcode/solution/array/TeemoAttacking.java) | Simulation                                                   |
| 605  | [Can Place Flowers](https://leetcode.com/problems/can-place-flowers/) | Easy       | [CanPlaceFlowers.java](src/leetcode/solution/array/CanPlaceFlowers.java) | One Pass and Check                                           |
| 768  | [Max Chunks To Make Sorted II](https://leetcode.com/problems/max-chunks-to-make-sorted-ii/) | Hard       | [MaxChunksToMakeSortedII.java](src/leetcode/solution/array/MaxChunksToMakeSortedII.java) | Iterate through the array, each time all elements to the left are smaller (or equal) to all elements to the right, there is a new chunk. |
| 769  | [Max Chunks To Make Sorted](https://leetcode.com/problems/max-chunks-to-make-sorted/) | Medium     | [MaxChunksToMakeSorted.java](src/leetcode/solution/array/MaxChunksToMakeSortedII.java) | Iterate through the array,  each time the maximum value of all elements to the left equals the index, there is a new chunk. |
| 953  | [Verifying an Alien Dictionary](https://leetcode.com/problems/verifying-an-alien-dictionary/) | Easy       | [VerifyingAnAlienDictionary.java](src/leetcode/solution/array/VerifyingAnAlienDictionary.java) | Compare adjacent elements                                    |
| 2239 | [Find Closest Number to Zero](https://leetcode.com/problems/max-chunks-to-make-sorted/) | Easy       | [FindClosestNumberToZero.java](src/leetcode/solution/array/FindClosestNumberToZero.java) | One Pass                                                     |
| 1480 | [Running Sum of 1d Array](https://leetcode.com/problems/running-sum-of-1d-array/) | Easy       | [RunningSumOf1dArray.java](src/leetcode/solution/array/RunningSumOf1dArray.java) | Prefix sum                                                   |
| 2284 | [Sender With Largest Word Count](https://leetcode.com/problems/sender-with-largest-word-count/) | Medium     | [SenderWithLargestWordCount.java](src/leetcode/solution/Heap/SenderWithLargestWordCount.java) | Priority Queue                                               |
| 2303 | [Calculate Amount Paid in Taxes](https://leetcode.com/problems/calculate-amount-paid-in-taxes/) | Easy       | [CalculateAmountPaidInTaxes.java](src/leetcode/solution/array/CalculateAmountPaidInTaxes.java) | One Pass                                                     |
| x    | Rearrange Sorted Array In MaxMin Form                        | Medium     | [RearrangeSortedArrayInMaxMinForm.java](src/leetcode/solution/Arrays/RearrangeSortedArrayInMaxMinForm.java) | Using `%` and `/`                                            |

**Two Pointer** 

| No.  | Title                                                        | Difficulty | Solution                                                     | Idea                      |
| ---- | ------------------------------------------------------------ | ---------- | ------------------------------------------------------------ | ------------------------- |
| 88   | [Merge Sorted Array](https://leetcode.com/problems/sort-array-by-parity/) | Easy       | [MergeSortedArray.java](src/leetcode/solution/array/MergeSortedArray.java) | Two Pointer               |
| 581  | [Shortest Unsorted Continuous Subarray](https://leetcode.com/problems/shortest-unsorted-continuous-subarray/) | Medium     | [ShortestUnsortedContinuousSubarray.java](src/leetcode/solution/array/twopointer/ShortestUnsortedContinuousSubarray.java) | Two Pointer \| Sort       |
| 905  | [Sort Array By Parity](https://leetcode.com/problems/sort-array-by-parity/) | Easy       | [SortArrayByParity.java](src/leetcode/solution/array/SortArrayByParity.java) | Two Pointer               |
| 1679 | [Max Number of K-Sum Pairs](https://leetcode.com/problems/max-number-of-k-sum-pairs/) | Medium     | [MaxNumberOfKSumPairs.java](src/leetcode/solution/array/twopointer/MaxNumberOfKSumPairs.java) | Two Pointer               |
| 1695 | [Maximum Erasure Value](https://leetcode.com/problems/maximum-erasure-value/) | Medium     | [MaximumErasureValue.java](src/leetcode/solution/array/twopointer/MaximumErasureValue.java) | Two Pointer \| Prefix Sum |

**Intervals**

| No.  | Title                                                        | Difficulty | Solution                                                     | Idea                                              |
| ---- | ------------------------------------------------------------ | ---------- | ------------------------------------------------------------ | ------------------------------------------------- |
| 56   | [Merge Intervals](https://leetcode.com/problems/merge-intervals/) | Medium     | [MergeIntervals.java](src/leetcode/solution/array/interval/MergeIntervals.java) | Sort and compare left border of the interval      |
| 57   | [Insert Interval](https://leetcode.com/problems/insert-interval/) | Medium     | [InsertInterval.java](src/leetcode/solution/array/interval/InsertInterval.java) | Add Before, Merge, Add After.                     |
| 986  | [Interval List Intersections](https://leetcode.com/problems/interval-list-intersections/) | Medium     | [IntervalListIntersections.java](src/leetcode/solution/array/interval/IntervalListIntersections.java) | Two pointer and Check intersect                   |
| 1272 | [Remove Interval](https://leetcode.com/problems/remove-interval/) | Medium     | [RemoveInterval.java](src/leetcode/solution/array/interval/RemoveInterval.java) | Check Intersection                                |
| 1288 | [Remove Covered Intervals](https://leetcode.com/problems/remove-covered-intervals/) | Medium     | [RemoveCoveredIntervals.java](src/leetcode/solution/array/interval/RemoveCoveredIntervals.java) | Sort and compare the right border of the interval |

**n Sum**

| No.  | Title                                                        | Difficulty | Solution                                                     | Idea         |
| ---- | ------------------------------------------------------------ | ---------- | ------------------------------------------------------------ | ------------ |
| 167  | [Two Sum II - Input Array Is Sorted](https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/) | Medium     | [TwoSumIIInputArrayIsSorted.java](src/leetcode/solution/array/nSum/TwoSumIIInputArrayIsSorted.java) | Two Pointer. |



**voting**

| No.  | Title                                                        | Difficulty | Solution                                                     | Idea                                 |
| ---- | ------------------------------------------------------------ | ---------- | ------------------------------------------------------------ | ------------------------------------ |
| 169  | [Majority Element](https://leetcode.com/problems/majority-element/) | Easy       | [MajorityElement.java](src/leetcode/solution/array/MajorityElement.java) | Sort \| Boyer-Moore Voting Algorithm |
| 229  | [Majority Element II](https://leetcode.com/problems/majority-element-ii/) | Medium     | [MajorityElementII.java](src/leetcode/solution/array/MajorityElementII.java) | Sort \| Boyer-Moore Voting Algorithm |
| 1150 | [Check If a Number Is Majority Element in a Sorted Array](https://leetcode.com/problems/check-if-a-number-is-majority-element-in-a-sorted-array/) | Easy       | [CheckIfANumberIsMajorityElementInASortedArray.java](src/leetcode/solution/array/CheckIfANumberIsMajorityElementInASortedArray.java) | Voting                               |

#### [Matrix](src/leetcode/solution/matrix)

| No.  | Title                                                        | Difficulty | Solution                                                     | Idea      |
| ---- | ------------------------------------------------------------ | ---------- | ------------------------------------------------------------ | --------- |
| 54   | [Spiral Matrix](https://leetcode.com/problems/spiral-matrix/) | Medium     | [SpiralMatrix.java](src/leetcode/solution/matrix/SpiralMatrix.java) | 4 Bound   |
| 59   | [Spiral Matrix II](https://leetcode.com/problems/spiral-matrix-ii/) | Medium     | [SpiralMatrixII.java](src/leetcode/solution/matrix/SpiralMatrixII.java) | 4 Bound   |
| 867  | [Transpose Matrix](https://leetcode.com/problems/transpose-matrix/) | Easy       | [TransposeMatrix.java](src/leetcode/solution/matrix/TransposeMatrix.java) | Traversal |

#### [Binary Search](src/leetcode/solution/BinarySearch)

| No.  | Title                                                        | Difficulty | Solution                                                     | Idea          |
| ---- | ------------------------------------------------------------ | ---------- | ------------------------------------------------------------ | ------------- |
| 374  | [Guess Number Higher or Lower](https://leetcode.com/problems/guess-number-higher-or-lower/) | Easy       | [GuessNumberHigherOrLower.java](src/leetcode/solution/BinarySearch/GuessNumberHigherOrLower.java) | Binary Search |

#### [String](src/leetcode/solution/string)

| No.  | Title                                                        | Difficulty | Solution                                                     | Idea                                        |
| ---- | ------------------------------------------------------------ | ---------- | ------------------------------------------------------------ | ------------------------------------------- |
| 5    | [Longest Palindromic Substring](https://leetcode.com/problems/longest-palindromic-substring/) | Medium     | [LongestPalindromicSubstring.java](src/leetcode/solution/string/LongestPalindromicSubstring.java) | Two Pointer, Expand Around Possible Centers |
| 205  | [Isomorphic Strings](https://leetcode.com/problems/isomorphic-strings/) | Easy       | [IsomorphicStrings.java](src/leetcode/solution/string/IsomorphicStrings.java) | Use HashMap and HashSet.                    |
| 535  | [Encode and Decode TinyURL](https://leetcode.com/problems/encode-and-decode-tinyurl/) | Medium     | [EncodeAndDecodeTinyURL.java](src/leetcode/solution/string/EncodeAndDecodeTinyURL.java) | HashMap                                     |
| 647  | [Palindromic Substrings](https://leetcode.com/problems/palindromic-substrings/) | Medium     | [PalindromicSubstrings.java](src/leetcode/solution/string/PalindromicSubstrings.java) | Two Pointer, Expand Around Possible Centers |
| 844  | [Backspace String Compare](https://leetcode.com/problems/backspace-string-compare/) | Medium     | [BackspaceStringCompare.java](src/leetcode/solution/string/BackspaceStringCompare.java) | Stack \| Two Pointer                        |
| 1209 | [Remove All Adjacent Duplicates in String II](https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string-ii/) | Medium     | [RemoveAllAdjacentDuplicatesInStringII.java](src/leetcode/solution/string/RemoveAllAdjacentDuplicatesInStringII.java) | Stack \| Two Pointer                        |
| 2027 | [Minimum Moves to Convert String](https://leetcode.com/problems/minimum-moves-to-convert-string/) | Easy       | [MinimumMovesToConvertString.java](src/leetcode/solution/string/MinimumMovesToConvertString.java) | Pointer and Count                           |
| 2264 | [Largest 3-Same-Digit Number in String](https://leetcode.com/problems/largest-3-same-digit-number-in-string/) | Easy       | [LargestThreeSameDigitNumberInString.java](src/leetcode/solution/string/LargestThreeSameDigitNumberInString.java) | Two Pointer                                 |
| 2288 | [Apply Discount to Prices](https://leetcode.com/problems/apply-discount-to-prices/) | Medium     | [ApplyDiscountToPrices.java](src/leetcode/solution/string/ApplyDiscountToPrices.java) | Split, Format,  StringBuilder               |

**Two Pointer** 

| No.  | Title                                                        | Difficulty | Solution                                                     | Idea                                             |
| ---- | ------------------------------------------------------------ | ---------- | ------------------------------------------------------------ | ------------------------------------------------ |
| 1332 | [Remove Palindromic Subsequences](https://leetcode.com/problems/remove-palindromic-subsequences/) | Easy       | [RemovePalindromicSubsequences.java](src/leetcode/solution/string/twopoint/RemovePalindromicSubsequences.java) | Two Pointer, check if it is a Palindrome String. |



#### [Slide Window](src/leetcode/solution/SlideWindow)

| No.  | Title                                                        | Difficulty | Solution                                                     | Idea                     |
| ---- | ------------------------------------------------------------ | ---------- | ------------------------------------------------------------ | ------------------------ |
| 3    | [Longest Substring Without Repeating Characters](https://leetcode.com/problems/longest-substring-without-repeating-characters/) | Medium     | [LongestSubstringWithoutRepeatingCharacters.java](src/leetcode/solution/SlideWindow/LongestSubstringWithoutRepeatingCharacters.java) | Slide Window and HashMap |
| 567  | [Permutation in String](https://leetcode.com/problems/permutation-in-string/) | Medium     | [PermutationInString.java](src/leetcode/solution/SlideWindow/PermutationInString.java) | Slide Window             |
| 1423 | [Maximum Points You Can Obtain from Cards](https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/) | Medium     | [MaximumPointsYouCanObtainFromCards.java](src/leetcode/solution/SlideWindow/MaximumPointsYouCanObtainFromCards.java) | Slide Window             |
| 1658 | [Minimum Operations to Reduce X to Zero](https://leetcode.com/problems/minimum-operations-to-reduce-x-to-zero/) | Medium     | [MinimumOperationsToReduceXToZero.java](src/leetcode/solution/SlideWindow/MinimumOperationsToReduceXToZero.java) | Slide Window             |

#### [Hash Table](src/leetcode/solution/Hash)

| No.  | Title                                                        | Difficulty | Solution                                                     | Idea                                     |
| ---- | ------------------------------------------------------------ | ---------- | ------------------------------------------------------------ | ---------------------------------------- |
| 451  | [Sort Characters By Frequency](https://leetcode.com/problems/sort-characters-by-frequency/) | Medium     | [SortCharactersByFrequency.java](src/leetcode/solution/Hash/SortCharactersByFrequency.java) | Map and Sort. Or Bucket Sort.            |
| 567  | [Longest Consecutive Sequence](https://leetcode.com/problems/longest-consecutive-sequence/) | Medium     | [LongestConsecutiveSequence.java](src/leetcode/solution/Hash/LongestConsecutiveSequence.java) | Hash Table: using HashSet save the nums. |

#### [Graph](src/leetcode/solution/Graph)

| No.  | Title                                                        | Difficulty | Solution                                                     | Idea                                                         |
| ---- | ------------------------------------------------------------ | ---------- | ------------------------------------------------------------ | ------------------------------------------------------------ |
| 261  | [Graph Valid Tree](https://leetcode.com/problems/graph-valid-tree/) | Medium     | [GraphValidTree.java](src/leetcode/solution/Graph/GraphValidTree.java) | This question is actually to determine whether there is a cycle in the graph.<br />- generate Adjacency List<br />- DFS<br />- BFS |
| 399  | [Evaluate Division](https://leetcode.com/problems/evaluate-division/) | Medium     | [EvaluateDivision.java](src/leetcode/solution/Graph/EvaluateDivision.java) | - generate Adjacency List<br />- DFS<br />- BFS              |
| 841  | [Keys and Rooms](https://leetcode.com/problems/evaluate-division/) | Medium     | [KeysAndRooms.java](src/leetcode/solution/Graph/KeysAndRooms.java) | - DFS<br />- BFS                                             |
| 133  | [Clone Graph](https://leetcode.com/problems/clone-graph/)    | Medium     | [CloneGraph.java](src/leetcode/solution/Graph/CloneGraph.java) | - DFS                                                        |
| 277  | [Find the Celebrity](https://leetcode.com/problems/find-the-celebrity/) | Medium     | [FindTheCelebrity.java](src/leetcode/solution/Graph/FindTheCelebrity.java) | - Logical Deduction                                          |
| 310  | [Minimum Height Trees](https://leetcode.com/problems/minimum-height-trees/) | Medium     | [MinimumHeightTrees.java](src/leetcode/solution/Graph/MinimumHeightTrees.java) | - BFS: remove leaves                                         |
| 1192 | [Critical Connections in a Network](https://leetcode.com/problems/critical-connections-in-a-network/) | Hard       | [CriticalConnectionsInANetwork.java](src/leetcode/solution/Graph/CriticalConnectionsInANetwork.java) | - DFS: find cycle and remove the edge.                       |
| 2368 | [Reachable Nodes With Restrictions](https://leetcode.com/problems/reachable-nodes-with-restrictions/) | Medium     | [ReachableNodesWithRestrictions.java](src/leetcode/solution/Graph/ReachableNodesWithRestrictions.java) | - DFS.                                                       |



**Bipartite Graph**

| No.  | Title                                                        | Difficulty | Solution                                                     | Idea                                               |
| ---- | ------------------------------------------------------------ | ---------- | ------------------------------------------------------------ | -------------------------------------------------- |
| 785  | [Is Graph Bipartite?](https://leetcode.com/problems/is-graph-bipartite/) | Medium     | [IsBipartite.java](src/leetcode/solution/Graph/IsBipartitet.java) | - Paint with different color<br />- DFS<br /> -BFS |
| 886  | [Possible Bipartite](https://leetcode.com/problems/possible-bipartition/) | Medium     | [PossibleBipartition.java](src/leetcode/solution/Graph/PossibleBipartition.java) | - Paint with different color<br />- DFS<br /> -BFS |

#### [Dynamic Programming](src/leetcode/solution/DP)

| No.  | Title                                                        | Difficulty | Solution                                                     | Idea         |
| ---- | ------------------------------------------------------------ | ---------- | ------------------------------------------------------------ | ------------ |
| 63   | [Unique Paths II](https://leetcode.com/problems/unique-paths-ii/) | Medium     | [UniquePathsII.java](src/leetcode/solution/DP/UniquePathsII.java) | DP           |
| 300  | [Longest Increasing Subsequence](https://leetcode.com/problems/longest-increasing-subsequence/) | Medium     | [LongestIncreasingSubsequence.java](src/leetcode/solution/DP/LongestIncreasingSubsequence.java) | DP Bottom-up |
| 322  | [Coin Change](https://leetcode.com/problems/coin-change/)    | Medium     | [CoinChange.java](src/leetcode/solution/DP/CoinChange.java)  | DP Bottom-up |
| 474  | [Ones and Zeroes](https://leetcode.com/problems/ones-and-zeroes/) | Medium     | [OnesAndZeroes.java](src/leetcode/solution/DP/OnesAndZeroes.java) | DP           |
| 2266 | [Count Number of Texts](https://leetcode.com/problems/count-number-of-texts/) | Medium     | [CountNumberOfTexts.java](src/leetcode/solution/DP/CountNumberOfTexts.java) | DP           |
| 120  | [Triangle](https://leetcode.com/problems/triangle/)          | Medium     | [Triangle.java](src/leetcode/solution/DP/Triangle.java)      | DP           |
| 256  | [Paint House](https://leetcode.com/problems/paint-house/)    | Medium     | [PaintHouse.java](src/leetcode/solution/DP/PaintHouse.java)  | DP           |

#### [Heap (Priority Queue)](src/leetcode/solution/Heap)

| No.  | Title                                                        | Difficulty | Solution                                                     | Idea           |
| ---- | ------------------------------------------------------------ | ---------- | ------------------------------------------------------------ | -------------- |
| 347  | [Top K Frequent Elements](https://leetcode.com/problems/top-k-frequent-elements/) | Medium     | [TopKFrequentElements.java](src/leetcode/solution/Heap/TopKFrequentElements.java) | Priority Queue |
| 692  | [Top K Frequent Words](https://leetcode.com/problems/top-k-frequent-words/) | Medium     | [TopKFrequentWords.java](src/leetcode/solution/Heap/TopKFrequentWords.java) | Priority Queue |
| 778  | [Swim in Rising Water](https://leetcode.com/problems/swim-in-rising-water/) | Hard       | [SwimInRisingWater.java](src/leetcode/solution/Heap/SwimInRisingWater.java) | Priority Queue |
| 1642 | [Furthest Building You Can Reach](https://leetcode.com/problems/furthest-building-you-can-reach/) | Medium     | [FurthestBuildingYouCanReach.java](src/leetcode/solution/Heap/FurthestBuildingYouCanReach.java) | Priority Queue |

#### [Stack](src/leetcode/solution/stack)

| No.  | Title                                                        | Difficulty | Solution                                                     | Idea                        |
| ---- | ------------------------------------------------------------ | ---------- | ------------------------------------------------------------ | --------------------------- |
| 32   | [Longest Valid Parentheses](https://leetcode.com/problems/longest-valid-parentheses/) | Hard       | [LongestValidParentheses.java](src/leetcode/solution/stack/LongestValidParentheses.java) | Stack                       |
| 316  | [Remove Duplicate Letters](https://leetcode.com/problems/remove-duplicate-letters/) | Medium     | [RemoveDuplicateLetters.java](src/leetcode/solution/stack/RemoveDuplicateLetters.java) | Stack                       |
| 394  | [Decode String](https://leetcode.com/problems/decode-string/) | Medium     | [DecodeString.java](src/leetcode/solution/stack/DecodeString.java) | Two Stack                   |
| 921  | [Minimum Add to Make Parentheses Valid](https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/) | Medium     | [MinimumAddToMakeParenthesesValid.java](src/leetcode/solution/stack/MinimumAddToMakeParenthesesValid.java) | Balance                     |
| 1047 | [Remove All Adjacent Duplicates In String](https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/) | Easy       | [RemoveAllAdjacentDuplicatesInString.java](src/leetcode/solution/stack/RemoveAllAdjacentDuplicatesInString.java) | Use Stack or StringBuilder. |
| 1249 | [Minimum Remove to Make Valid Parentheses](https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/) | Medium     | [MinimumRemoveToMakeValidParentheses.java](src/leetcode/solution/stack/MinimumRemoveToMakeValidParentheses.java) | Using Stack to save '('     |

#### [Math](src/leetcode/solution/math)

| No.  | Title                                                        | Difficulty | Solution                                                     | Idea                         |
| ---- | ------------------------------------------------------------ | ---------- | ------------------------------------------------------------ | ---------------------------- |
| 171  | [Excel Sheet Column Number](https://leetcode.com/problems/excel-sheet-column-number/) | Easy       | [ExcelSheetColumnNumber.java](src/leetcode/solution/math/ExcelSheetColumnNumber.java) | Iteration                    |
| 191  | [Number of 1 Bits](https://leetcode.com/problems/number-of-1-bits/) | Easy       | [LongestValidParentheses.java](src/leetcode/solution/math/bit/NumberOf1Bits.java) | n & (n - 1)                  |
| 202  | [Happy Number](https://leetcode.com/problems/happy-number/)  | Easy       | [HappyNumber.java](src/leetcode/solution/math/HappyNumber.java) | HashSet \| fast-slow pointer |

#### [Greedy](src/leetcode/solution/greedy)

| No.  | Title                                                        | Difficulty | Solution                                                     | Idea                                         |
| ---- | ------------------------------------------------------------ | ---------- | ------------------------------------------------------------ | -------------------------------------------- |
| 134  | [Gas Station](https://leetcode.com/problems/gas-station/)    | Medium     | [GasStation.java](src/leetcode/solution/greedy/GasStation.java) | Greedy                                       |
| 135  | [Candy](https://leetcode.com/problems/candy/)                | Hard       | [Candy.java](src/leetcode/solution/greedy/Candy.java)        | From left to right, then form right to left. |
| 179  | [Largest Number](https://leetcode.com/problems/largest-number/submissions/) | Medium     | [LargestNumber.java](src/leetcode/solution/greedy/LargestNumber.java) | Greedy and Sort                              |
| 376  | [Wiggle Subsequence](https://leetcode.com/problems/wiggle-subsequence/) | Medium     | [WiggleSubsequence.java](src/leetcode/solution/greedy/WiggleSubsequence.java) | detect the change.                           |
| 1647 | [Minimum Deletions to Make Character Frequencies Unique](https://leetcode.com/problems/minimum-deletions-to-make-character-frequencies-unique/) | Medium     | [MinimumDeletionsToMakeCharacterFrequenciesUnique.java](src/leetcode/solution/greedy/MinimumDeletionsToMakeCharacterFrequenciesUnique.java) | Greedy  \| HashSet \| Sort                   |
| 1710 | [Maximum Units on a Truck](https://leetcode.com/problems/maximum-units-on-a-truck/) | Easy       | [MaximumUnitsOnATruck.java](src/leetcode/solution/greedy/MaximumUnitsOnATruck.java) | select Greatest first.                       |

#### [Trie](src/leetcode/solution/trie)

| No.  | Title                                                        | Difficulty | Solution                                                     | Idea                  |
| ---- | ------------------------------------------------------------ | ---------- | ------------------------------------------------------------ | --------------------- |
| 1268 | [Search Suggestions System](https://leetcode.com/problems/search-suggestions-system/) | Medium     | [SearchSuggestionsSystem.java](src/leetcode/solution/trie/SearchSuggestionsSystem.java) | Trie \| Binary Search |

 

