package leetcode.solution.Heap;

import java.util.*;

/**
 * 347. Top K Frequent Elements
 */
public class TopKFrequentElements {


    public static void main(String[] args) {
        String s = "sseee/";
        int i = 3;
        int a = s.indexOf('/', i);
        System.out.println(a);
        int[] nums = {1, 2, 3, 4};
        int k = 3;
        TopKFrequentElementsHeapSolution solution = new TopKFrequentElementsHeapSolution();
        int[] ans = solution.topKFrequent(nums, k);
        System.out.println(Arrays.toString(ans));
        // 16
    }


}

class TopKFrequentElementsHeapSolution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> countMap = new HashMap<>();

        for (int num : nums) {
            int currCount = countMap.getOrDefault(num, 0);
            countMap.put(num, currCount + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> {
            return a.getValue() - b.getValue();
        });


        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            pq.add(entry);

            if (pq.size() > k) {
                pq.poll();
            }
        }

        int[] ans = new int[k];

        for (int i = 0; i < k; i++) {
            Map.Entry<Integer, Integer> entry = pq.poll();
            ans[i] = entry.getKey();
        }

        return ans;

    }
}


class TopKFrequentElementsBubbleSortSolution {
    public List<Integer> topKFrequent(int[] nums, int k) {

        List<Integer>[] bucket = new List[nums.length + 1];
        Map<Integer, Integer> frequencyMap = new HashMap<Integer, Integer>();

        for (int n : nums) {
            frequencyMap.put(n, frequencyMap.getOrDefault(n, 0) + 1);
        }

        for (int key : frequencyMap.keySet()) {
            int frequency = frequencyMap.get(key);
            if (bucket[frequency] == null) {
                bucket[frequency] = new ArrayList<>();
            }
            bucket[frequency].add(key);
        }

        List<Integer> res = new ArrayList<>();

        for (int pos = bucket.length - 1; pos >= 0 && res.size() < k; pos--) {
            if (bucket[pos] != null) {
                res.addAll(bucket[pos]);
            }
        }


        return res;
    }
}
