package leetcode.solution.array;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.PriorityQueue;

/**
 * 2284. Sender With Largest Word Count
 */
public class SenderWithLargestWordCount {

    public static void main(String[] args) {
        String[] messages = {"Hello userTwooo", "Hi userThree", "Wonderful day Alice", "Nice day userThree"};
        String[] senders = {"Alice", "userTwo", "userThree", "Alice"};
        SenderWithLargestWordCount solution = new SenderWithLargestWordCount();
        String ans = solution.largestWordCount(messages, senders);
        System.out.println(ans);
        // Alice
    }

    public String largestWordCount(String[] messages, String[] senders) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < messages.length; i++) {
            String s = messages[i];
            int count = s.split(" ").length;
            String name = senders[i];
            count += map.getOrDefault(name, 0);
            map.put(name, count);
        }


        PriorityQueue<Map.Entry<String, Integer>> priorityQueue = new PriorityQueue<>((a, b) -> {
            if (Objects.equals(a.getValue(), b.getValue())) {
                return b.getKey().compareTo(a.getKey());
            }

            return b.getValue() - a.getValue();
        });

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            priorityQueue.add(entry);
        }

        return priorityQueue.poll().getKey();
    }

}
