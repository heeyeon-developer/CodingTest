# DP
1. 1 or 2 칸을 이동할 수 있으므로 i번째 위치에서 i-1, i-2 번째 경우의 수들의 합을 구하기
2. n=1 일때 경우의 수는 1, n=2 일때 경우의 수는 2 로 초기 설정 후 계산


```java
class Solution {
    public int climbStairs(int n) {
        int[] nums = new int[45];
        nums[0] = 1;
        nums[1] = 2;
        for(int i=2; i<n; i++){
            nums[i] = nums[i-1]+nums[i-2];
        }
        return nums[n-1];
    }
}
```
