package view;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class MinClickCount {


    public static void main(String[] args) {
        String s = "abacadefghibg";
        MinClickCount minClickCount = new MinClickCount();
        int ans = minClickCount.getMinClickCount(s);
        System.out.println(ans);
    }


     /**
      * @Description: stastic 
      * @Author: Guanchen Zhao
      * @Date: 2022/5/5  
      */
    public int getMinClickCount(String s) {
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            Integer count = map.getOrDefault(c, 0);
            map.put(c, count + 1);
        }

        PriorityQueue<Map.Entry<Character, Integer>> queue = new PriorityQueue<>((o1, o2) -> o2.getValue() - o1.getValue());

        queue.addAll(map.entrySet());

        int count = 0;

        int sum = 0;
        int base;
        while (!queue.isEmpty()) {
            if (count > 18) {
                base = 3;
            } else if (count > 9) {
                base = 2;
            } else {
                base = 1;
            }
            Map.Entry<Character, Integer> entry = queue.poll();

            count++;
            sum += base * entry.getValue();
        }

        return sum;
    }


}
