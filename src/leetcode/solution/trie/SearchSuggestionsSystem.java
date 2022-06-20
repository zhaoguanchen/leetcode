package leetcode.solution.trie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1268. Search Suggestions System
 */
public class SearchSuggestionsSystem {

    public static void main(String[] args) {
        String[] products = {"mobile", "mouse", "moneypot", "monitor", "mousepad"};
        String searchWord = "mouse";
        SearchSuggestionsSystemBinarySearchSolution solution = new SearchSuggestionsSystemBinarySearchSolution();
        List<List<String>> ans = solution.suggestedProducts(products, searchWord);
        System.out.println(ans);

        SearchSuggestionsSystemTrieSolution solution1 = new SearchSuggestionsSystemTrieSolution();
        List<List<String>> ans1 = solution1.suggestedProducts(products, searchWord);
        System.out.println(ans1);


    }


}

/**
 * @Description: Binary Search
 * @Author: Guanchen Zhao
 * @Date: 2022/6/19
 */
class SearchSuggestionsSystemBinarySearchSolution {

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);
        List<List<String>> ans = new ArrayList<>();

        int base = 0;
        StringBuilder word = new StringBuilder();
        for (char c : searchWord.toCharArray()) {
            word.append(c);
            ans.add(new ArrayList<>());
            int start = getLeft(products, base, word.toString());

            for (int i = start; i < Math.min(products.length, start + 3); i++) {
                if (products[i].length() < word.length() || !products[i].startsWith(word.toString())) {
                    break;
                }
                ans.get(ans.size() - 1).add(products[i]);
            }

            base = start;
        }


        return ans;

    }

    private int getLeft(String[] array, int start, String word) {
        int i = start, j = array.length - 1;
        int mid;

        while (i < j) {
            mid = i + (j - i) / 2;
            if (array[mid].compareTo(word) >= 0) {
                j = mid;
            } else {
                i = mid + 1;
            }
        }

        return i;
    }
}

/**
 * @Description: Using Trie
 * @Author: Guanchen Zhao
 * @Date: 2022/6/19
 */
class SearchSuggestionsSystemTrieSolution {

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {

        SearchSuggestionsSystemTrie trie = new SearchSuggestionsSystemTrie();

        for (String product : products) {
            trie.insert(product);
        }

        List<List<String>> ans = new ArrayList<>();

        StringBuilder searchStr = new StringBuilder();
        for (char c : searchWord.toCharArray()) {
            searchStr.append(c);
            ans.add(trie.search(searchStr.toString()));
        }

        return ans;

    }
}

class SearchSuggestionsSystemTrie {

    SearchSuggestionsSystemTrieNode root;

    public SearchSuggestionsSystemTrie() {
        this.root = new SearchSuggestionsSystemTrieNode();
    }

    public void insert(String word) {
        SearchSuggestionsSystemTrieNode curr = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (null == curr.child.get(index)) {
                curr.child.set(index, new SearchSuggestionsSystemTrieNode());
            }

            curr = curr.child.get(index);
        }

        curr.isWord = true;

    }


    public List<String> search(String word) {
        SearchSuggestionsSystemTrieNode curr = root;

        List<String> res = new ArrayList<>();

        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (curr.child.get(index) == null) {
                return res;
            }

            curr = curr.child.get(index);

        }
        dfs(word, curr, res);

        return res;

    }


    private void dfs(String word, SearchSuggestionsSystemTrieNode node, List<String> res) {
        if (res.size() == 3) {
            return;
        }

        if (node.isWord) {
            res.add(word);
        }

        for (int i = 0; i < 26; i++) {
            char c = (char) ('a' + i);
            if (null != node.child.get(i)) {
                dfs(word + c, node.child.get(i), res);
            }
        }

    }


}

class SearchSuggestionsSystemTrieNode {

    boolean isWord;

    List<SearchSuggestionsSystemTrieNode> child;

    public SearchSuggestionsSystemTrieNode() {
        this.isWord = false;
        this.child = Arrays.asList(new SearchSuggestionsSystemTrieNode[26]);
    }


}