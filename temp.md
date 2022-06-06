# 134. Gas Station

```java
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        
        int n = gas.length;
        int sum = 0;
        for(int i = 0; i < n; i++) {
            sum += gas[i] - cost[i];
        }
        
        if(sum < 0) {
            return -1;
        }
        
        sum = 0;
        int start = 0;
        
        for(int i = 0; i < n; i++) {
            sum += gas[i] - cost[i];
            if(sum < 0) {
                start = i + 1;
                sum = 0;
            }
        }
        
        if(start == n) {
            return 0;
        }
        
        return start;
    }
}
```