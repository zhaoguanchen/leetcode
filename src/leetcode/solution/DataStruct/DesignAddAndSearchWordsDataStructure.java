package leetcode.solution.DataStruct;

/**
 * 211. Design Add and Search Words Data Structure
 */
class WordDictionary {

    public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");
        System.out.println(wordDictionary.search("pad")); // return False
        System.out.println(wordDictionary.search("bad")); // return True
        System.out.println(wordDictionary.search(".ad")); // return True
        System.out.println(wordDictionary.search("b..")); // return True
    }

    private WordDictionaryNode root;

    public WordDictionary() {
        root = new WordDictionaryNode();
    }

    public void addWord(String word) {
        WordDictionaryNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!cur.containsKey(c)) {
                cur.put(c, new WordDictionaryNode());
            }
            cur = cur.get(c);
        }

        cur.setEnd();
    }

    public boolean search(String word) {
        return searchWithNode(word, root);
    }


    private boolean searchWithNode(String word, WordDictionaryNode node) {
        if (node == null) {
            return false;
        }
        WordDictionaryNode cur = node;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);

            if (Character.isLetter(c)) {
                if (!cur.containsKey(c)) {
                    return false;
                } else {
                    cur = cur.get(c);
                }
            } else {
                String subWord = word.substring(i + 1);
                for (int j = 0; j < 26; j++) {
                    char target = (char) ('a' + j);
                    WordDictionaryNode nextNode = cur.get(target);
                    if (null == nextNode) {
                        continue;
                    }
                    boolean ans = searchWithNode(subWord, nextNode);
                    if (ans) {
                        return true;
                    }

                }
                return false;
            }


        }

        return cur.isEnd();
    }

}

class WordDictionaryNode {

    /**
     * ?????????
     */
    private WordDictionaryNode[] children;

    /**
     * ????????????   ???????????????26???????????????
     */
    private final int range = 26;

    /**
     * ????????????????????????????????????????????????
     */
    private boolean isEnd;

    /**
     * ????????????
     */
    public WordDictionaryNode() {
        children = new WordDictionaryNode[range];
        isEnd = false;
    }

    public void setEnd() {
        isEnd = true;
    }

    public boolean isEnd() {
        return isEnd;
    }

    /**
     * ???????????????????????????c
     *
     * @param c
     * @return
     */
    public boolean containsKey(char c) {
        // ????????????
        int index = c - 'a';
        return null != children[index];
    }

    /**
     * ???????????????????????????Node
     *
     * @param c
     * @return
     */
    public WordDictionaryNode get(char c) {
        int index = c - 'a';
        return children[index];
    }


    /**
     * ??????????????? ????????????????????????????????????????????????TrieNode
     *
     * @param c
     * @param wordDictionaryNode
     */
    public void put(char c, WordDictionaryNode wordDictionaryNode) {
        int index = c - 'a';
        children[index] = wordDictionaryNode;
    }
}