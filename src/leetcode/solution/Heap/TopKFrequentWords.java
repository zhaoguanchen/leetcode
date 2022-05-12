package leetcode.solution.Heap;

import java.util.*;

/**
 * 692. Top K Frequent Words
 */
public class TopKFrequentWords {


    public static void main(String[] args) {
        String[] s = {"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};
        int k = 4;
        TopKFrequentWords topKFrequentWords = new TopKFrequentWords();
        List<String> ans = topKFrequentWords.topKFrequent(s, k);
        System.out.println(ans);
        // ["the","is","sunny","day"]
    }

    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();

        for (String word : words) {
            int count = 0;
            if (map.containsKey(word)) {
                count = map.get(word);
            }
            map.put(word, count + 1);
        }

        // take care of the sort method
        PriorityQueue<Map.Entry<String, Integer>> priorityQueue = new PriorityQueue<>((o1, o2) -> {
            if (o1.getValue() > o2.getValue()) {
                return 1;
            } else if (o1.getValue() < o2.getValue()) {
                return -1;
            } else {
                // compare String
                return -o1.getKey().compareTo(o2.getKey());
            }
        });

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            priorityQueue.add(entry);
            if (priorityQueue.size() > k) {
                priorityQueue.poll();
            }
        }

        // provide convenience for addFirst
        List<String> ans = new LinkedList<>();

        // add to first index
        while (!priorityQueue.isEmpty()) {
            ans.add(0, priorityQueue.poll().getKey());
        }

        return ans;
    }

}