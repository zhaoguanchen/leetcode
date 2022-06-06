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

# 55. Jump Game


Greedy
```java
class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int lastPosition = n - 1;
        for(int i = n - 2; i >=0; i--) {
            if(i + nums[i] >= lastPosition) {
                lastPosition = i;
            }
        }
        
        return lastPosition == 0;
    }
}
```

DP

```java

class Solution {
    
    int [] memo;
    int [] nums;
    
    public boolean canJump(int[] nums) {
        this.memo = new int [nums.length];
        this.nums = nums;
        
        return dp(0);
    }
    
    private boolean dp(int index) {
        if(index >= nums.length - 1) {
            return true;
        }
        
        if(memo[index] != 0) {
            return memo[index] == 1;
        }
        
        int fastest = index + nums[index];
         
        for(int i = index + 1; i <= fastest; i++) {
          boolean ans = dp(i);
            if(ans) {
                memo[index] = 1;
                return true;
            }
        }
        
        memo[index] = -1;
        return false;
    }
}

```


DP

```java



```