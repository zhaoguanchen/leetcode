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
| 206  | [Reverse Linked List](https://leetcode.com/problems/reverse-linked-list/) | Easy       | [ReverseLinkedList.java](src/leetcode/solution/LinkedList/reverse/ReverseLinkedList.java) | Iteration \| Recursion                                       |
| 92   | [Reverse Linked List II](https://leetcode.com/problems/reverse-linked-list-ii/) | Medium     | [ReverseLinkedListII.java](src/leetcode/solution/LinkedList/reverse/ReverseLinkedListII.java) | Iteration \| Recursion<br />Reverse Linked List between `a` and `b`. At first, we can move to a-th, and the problem becomes  Reverse Top N nodes. |
| 25   | [Reverse Nodes in k-Group](https://leetcode.com/problems/reverse-nodes-in-k-group/) | Hard       | [ReverseNodesInkGroup.java](src/leetcode/solution/LinkedList/reverse/ReverseNodesInkGroup.java) | For each k group, reverse Linked List between head and k-th. Let head equal k+1th node, then do Recursion. |
| 234  | [Palindrome Linked List](https://leetcode.com/problems/palindrome-linked-list/) | Easy       | [PalindromeLinkedList.java](src/leetcode/solution/LinkedList/reverse/PalindromeLinkedList.java) | 1. Using a pointer that points to the node from the start location. Recursion and move pointer forward. Compare.<br />2. Reverse the whole List.<br />3. Reverse the second-half List |
| 147  | [Insertion Sort List](https://leetcode.com/problems/insertion-sort-list/) | Easy       | [InsertionSortList.java](src/leetcode/solution/LinkedList/InsertionSortList.java) | Virtual Head Node                                            |

**Two Pointer** 

| No.  | Title                                                        | Difficulty | Solution                                                     | Idea                   |
| ---- | ------------------------------------------------------------ | ---------- | ------------------------------------------------------------ | ---------------------- |
| 206  | [Reverse Linked List](https://leetcode.com/problems/reverse-linked-list/) | Easy       | [ReverseLinkedList.java](src/leetcode/solution/LinkedList/reverse/ReverseLinkedList.java) | Iteration \| Recursion |

#### [DataStruct](src/leetcode/solution/DataStruct)

| No.  | Title                                                        | Difficulty | Solution                                                     | Idea                                                         |
| ---- | ------------------------------------------------------------ | ---------- | ------------------------------------------------------------ | ------------------------------------------------------------ |
| 341  | [Flatten Nested List Iterator](https://leetcode.com/problems/flatten-nested-list-iterator/) | Medium     | [FlattenNestedListIterator.java](src/leetcode/solution/DataStruct/FlattenNestedListIterator.java) | LinkedList, Deque, or Stack.                                 |
| 705  | [Design HashSet](https://leetcode.com/problems/design-hashset/) | Easy       | [DesignHashSet.java](src/leetcode/solution/DataStruct/DesignHashSet.java) | Array + LinkedList                                           |
| 706  | [Design HashMap](https://leetcode.com/problems/design-hashmap/) | Easy       | [DesignHashMap.java](src/leetcode/solution/DataStruct/DesignHashMap.java) | Array + LinkedList                                           |
| 706  | [Design Underground System](https://leetcode.com/problems/design-underground-system/) | Medium     | [DesignUndergroundSystem.java](src/leetcode/solution/DataStruct/DesignUndergroundSystem.java) | using two HashMap. One saves the check-in record, another saves the data of the current stage. |
| 1166 | [Design File System](https://leetcode.com/problems/design-file-system/) | Medium     | [DesignFileSystem.java](src/leetcode/solution/DataStruct/DesignFileSystem.java) | - 1. **Trie**: using HashMap as the child list.              |

#### [Tree](src/leetcode/solution/tree)

##### [Binary Tree](src/leetcode/solution/tree/bst)

| No.  | Title                                                        | Difficulty | Solution                                                     | Idea                |
| ---- | ------------------------------------------------------------ | ---------- | ------------------------------------------------------------ | ------------------- |
| 199  | [Binary Tree Right Side View](https://leetcode.com/problems/binary-tree-right-side-view/) | Medium     | [BinaryTreeRightSideView.java](src/leetcode/solution/tree/BinaryTreeRightSideView.java) |                     |
| 108  | [Convert Sorted Array to Binary Search Tree](https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/) | Medium     | [ConvertSortedArrayToBinarySearchTree.java](src/leetcode/solution/tree/ConvertSortedArrayToBinarySearchTree.java) | DFS                 |
| 2265 | [Count Nodes Equal to Average of Subtree](https://leetcode.com/problems/count-nodes-equal-to-average-of-subtree/) | Medium     | [CountNodesEqualToAverageOfSubtree.java](src/leetcode/solution/tree/CountNodesEqualToAverageOfSubtree.java) | Postorder  traverse |

##### [Binary Search Tree](src/leetcode/solution/tree/bst)

| No.  | Title                                                        | Difficulty | Solution                                                     | Idea |
| ---- | ------------------------------------------------------------ | ---------- | ------------------------------------------------------------ | ---- |
| 173  | [Binary Search Tree Iterator](https://leetcode.com/problems/binary-search-tree-iterator/) | Medium     | [BinarySearchTreeIterator.java](src/leetcode/solution/tree/bst/BinarySearchTreeIterator.java) |      |

#### [Backtrack](src/leetcode/solution/backtrack)

| No.  | Title                                                        | Difficulty | Solution                                                     | Idea      |
| ---- | ------------------------------------------------------------ | ---------- | ------------------------------------------------------------ | --------- |
| 17   | [Letter Combinations of a Phone Number](https://leetcode.com/problems/letter-combinations-of-a-phone-number/) | Medium     | [LetterCombinationsPhoneNumber.java](src/leetcode/solution/backtrack/LetterCombinationsPhoneNumber.java) | Backtrack |
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
| 216  | [Combination Sum III](https://leetcode.com/problems/combination-sum-iii/) | Medium     | [CombinationSumIII.java](src/leetcode/solution/backtrack/CombinationSumIII.java) | Backtrack |

#### [DFS](src/leetcode/solution/DFS)

**Search Path**

| No.  | Title                                                        | Difficulty | Solution                                                     | Idea |
| ---- | ------------------------------------------------------------ | ---------- | ------------------------------------------------------------ | ---- |
| 2267 | [Check if There Is a Valid Parentheses String Path](https://leetcode.com/problems/check-if-there-is-a-valid-parentheses-string-path/) | Hard       | [CheckIfThereIsAValidParenthesesStringPath.java](src/leetcode/solution/DFS/CheckIfThereIsAValidParenthesesStringPath.java) | DFS  |



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

| No.  | Title                                                        | Difficulty | Solution                                                     | Idea                                |
| ---- | ------------------------------------------------------------ | ---------- | ------------------------------------------------------------ | ----------------------------------- |
| 752  | [Open the Lock](https://leetcode.com/problems/open-the-lock/) | Medium     | [OpenTheLock.java](src/leetcode/solution/BFS/OpenTheLock.java) | BFS with Queue                      |
| 752  | [Network Delay Time](https://leetcode.com/problems/network-delay-time/) | Medium     | [NetworkDelayTime.java](src/leetcode/solution/BFS/NetworkDelayTime.java) | directed graph<br />BFS  \| DFS     |
| 286  | [Walls and Gates](https://leetcode.com/problems/walls-and-gates/) | Medium     | [WallAndGates.java](src/leetcode/solution/BFS/WallAndGates.java) | BFS: spread from the gate           |
| 994  | [Rotting Oranges](https://leetcode.com/problems/rotting-oranges/) | Medium     | [RottingOranges.java](src/leetcode/solution/BFS/RottingOranges.java) | BFS: spread from the rotten oranges |

#### [Array](src/leetcode/solution/array)

| No.  | Title                                                        | Difficulty | Solution                                                     | Idea                                                         |
| ---- | ------------------------------------------------------------ | ---------- | ------------------------------------------------------------ | ------------------------------------------------------------ |
| 281  | [Zigzag Iterator](https://leetcode.com/problems/zigzag-iterator/) | Medium     | [ZigzagIterator.java](src/leetcode/solution/array/ZigzagIterator.java) | Two Pointer<br />Muti Pointer or Queue for the **Follow-Up** Question. |
| 412  | [Fizz Buzz](https://leetcode.com/problems/fizz-buzz/)        | Easy       | [FizzBuzz.java](src/leetcode/solution/array/FizzBuzz.java)   | For loop. Calculate i%5 and i%3 separately.                  |
| 456  | [132 Pattern](https://leetcode.com/problems/132-pattern/)    | Medium     | [OneThreeTwoPattern.java](src/leetcode/solution/array/OneThreeTwoPattern.java) | Using Array as a Stack                                       |
| 768  | [Max Chunks To Make Sorted II](https://leetcode.com/problems/max-chunks-to-make-sorted-ii/) | Hard       | [MaxChunksToMakeSortedII.java](src/leetcode/solution/array/MaxChunksToMakeSortedII.java) | Iterate through the array, each time all elements to the left are smaller (or equal) to all elements to the right, there is a new chunk. |
| 769  | [Max Chunks To Make Sorted](https://leetcode.com/problems/max-chunks-to-make-sorted/) | Medium     | [MaxChunksToMakeSorted.java](src/leetcode/solution/array/MaxChunksToMakeSortedII.java) | Iterate through the array,  each time the maximum value of all elements to the left equals the index, there is a new chunk. |

**Two Pointer** 

| No.  | Title                                                        | Difficulty | Solution                                                     | Idea                |
| ---- | ------------------------------------------------------------ | ---------- | ------------------------------------------------------------ | ------------------- |
| 581  | [Shortest Unsorted Continuous Subarray](https://leetcode.com/problems/shortest-unsorted-continuous-subarray/) | Medium     | [ShortestUnsortedContinuousSubarray.java](src/leetcode/solution/array/twopointer/ShortestUnsortedContinuousSubarray.java) | Two Pointer \| Sort |
| 905  | [Sort Array By Parity](https://leetcode.com/problems/sort-array-by-parity/) | Easy       | [SortArrayByParity.java](src/leetcode/solution/array/SortArrayByParity.java) | Two Pointer         |
| 1679 | [Max Number of K-Sum Pairs](https://leetcode.com/problems/max-number-of-k-sum-pairs/) | Medium     | [MaxNumberOfKSumPairs.java](src/leetcode/solution/array/twopointer/MaxNumberOfKSumPairs.java) | Two Pointer         |

#### [String](src/leetcode/solution/string)

| No.  | Title                                                        | Difficulty | Solution                                                     | Idea                 |
| ---- | ------------------------------------------------------------ | ---------- | ------------------------------------------------------------ | -------------------- |
| 2027 | [Minimum Moves to Convert String](https://leetcode.com/problems/minimum-moves-to-convert-string/) | Easy       | [MinimumMovesToConvertString.java](src/leetcode/solution/string/MinimumMovesToConvertString.java) | Pointer and Count    |
| 535  | [Encode and Decode TinyURL](https://leetcode.com/problems/encode-and-decode-tinyurl/) | Medium     | [EncodeAndDecodeTinyURL.java](src/leetcode/solution/string/EncodeAndDecodeTinyURL.java) | HashMap              |
| 844  | [Backspace String Compare](https://leetcode.com/problems/backspace-string-compare/) | Medium     | [BackspaceStringCompare.java](src/leetcode/solution/string/BackspaceStringCompare.java) | Stack \| Two Pointer |
| 1209 | [Remove All Adjacent Duplicates in String II](https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string-ii/) | Medium     | [RemoveAllAdjacentDuplicatesInStringII.java](src/leetcode/solution/string/RemoveAllAdjacentDuplicatesInStringII.java) | Stack \| Two Pointer |
| 2264 | [Largest 3-Same-Digit Number in String](https://leetcode.com/problems/largest-3-same-digit-number-in-string/) | Easy       | [LargestThreeSameDigitNumberInString.java](src/leetcode/solution/string/LargestThreeSameDigitNumberInString.java) | Two Pointer          |

#### [Slide Window](src/leetcode/solution/SlideWindow)

| No.  | Title                                                        | Difficulty | Solution                                                     | Idea         |
| ---- | ------------------------------------------------------------ | ---------- | ------------------------------------------------------------ | ------------ |
| 567  | [Permutation in String](https://leetcode.com/problems/permutation-in-string/) | Medium     | [PermutationInString.java](src/leetcode/solution/SlideWindow/PermutationInString.java) | Slide Window |

#### [Hash Table](src/leetcode/solution/Hash)

| No.  | Title                                                        | Difficulty | Solution                                                     | Idea                                     |
| ---- | ------------------------------------------------------------ | ---------- | ------------------------------------------------------------ | ---------------------------------------- |
| 567  | [Longest Consecutive Sequence](https://leetcode.com/problems/longest-consecutive-sequence/) | Medium     | [LongestConsecutiveSequence.java](src/leetcode/solution/Hash/LongestConsecutiveSequence.java) | Hash Table: using hashSet save the nums. |

#### [Graph](src/leetcode/solution/Graph)

| No.  | Title                                                        | Difficulty | Solution                                                     | Idea                                                         |
| ---- | ------------------------------------------------------------ | ---------- | ------------------------------------------------------------ | ------------------------------------------------------------ |
| 261  | [Graph Valid Tree](https://leetcode.com/problems/graph-valid-tree/) | Medium     | [GraphValidTree.java](src/leetcode/solution/Graph/GraphValidTree.java) | This question is actually to determine whether there is a cycle in the graph.<br />- generate Adjacency List<br />- DFS<br />- BFS |
| 399  | [Evaluate Division](https://leetcode.com/problems/evaluate-division/) | Medium     | [EvaluateDivision.java](src/leetcode/solution/Graph/EvaluateDivision.java) | - generate Adjacency List<br />- DFS<br />- BFS              |
| 841  | [Keys and Rooms](https://leetcode.com/problems/evaluate-division/) | Medium     | [KeysAndRooms.java](src/leetcode/solution/Graph/KeysAndRooms.java) | - DFS<br />- BFS                                             |
| 133  | [Clone Graph](https://leetcode.com/problems/clone-graph/)    | Medium     | [CloneGraph.java](src/leetcode/solution/CloneGraph.java)     | - DFS<br />                                                  |
| 277  | [Find the Celebrity](https://leetcode.com/problems/find-the-celebrity/) | Medium     | [FindTheCelebrity.java](src/leetcode/solution/FindTheCelebrity.java) | - Logical Deduction<br />                                    |
| 310  | [Minimum Height Trees](https://leetcode.com/problems/minimum-height-trees/) | Medium     | [MinimumHeightTrees.java](src/leetcode/solution/MinimumHeightTrees.java) | - BFS: remove leaves<br />                                   |



**Bipartite Graph**

| No.  | Title                                                        | Difficulty | Solution                                                     | Idea                                               |
| ---- | ------------------------------------------------------------ | ---------- | ------------------------------------------------------------ | -------------------------------------------------- |
| 785  | [Is Graph Bipartite?](https://leetcode.com/problems/is-graph-bipartite/) | Medium     | [IsBipartite.java](src/leetcode/solution/Graph/IsBipartitet.java) | - Paint with different color<br />- DFS<br /> -BFS |
| 886  | [Possible Bipartite](https://leetcode.com/problems/possible-bipartition/) | Medium     | [PossibleBipartition.java](src/leetcode/solution/Graph/PossibleBipartition.java) | - Paint with different color<br />- DFS<br /> -BFS |



#### [Dynamic Programing](src/leetcode/solution/DP)

| No.  | Title                                                        | Difficulty | Solution                                                     | Idea |
| ---- | ------------------------------------------------------------ | ---------- | ------------------------------------------------------------ | ---- |
| 2266 | [Count Number of Texts](https://leetcode.com/problems/count-number-of-texts/) | Medium     | [CountNumberOfTexts.java](src/leetcode/solution/DP/CountNumberOfTexts.java) | DP   |

#### [Heap (Priority Queue)](src/leetcode/solution/Heap)

| No.  | Title                                                        | Difficulty | Solution                                                     | Idea           |
| ---- | ------------------------------------------------------------ | ---------- | ------------------------------------------------------------ | -------------- |
| 778  | [Swim in Rising Water](https://leetcode.com/problems/swim-in-rising-water/) | Hard       | [SwimInRisingWater.java](src/leetcode/solution/Heap/SwimInRisingWater.java) | Priority Queue |

