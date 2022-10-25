# DP
1. 인접한 집들을 같은날 침범할 경우 보안에 걸리므로 인접한 집을 제외하여 최대한 많이 훔칠 수 있는 방법 찾기
2. i번째 위치에서 i-1번째 까지 누적된 값중 가장 큰 값을 찾아 값 갱신하여 최대 값 찾기


```java
class Solution {
    public int rob(int[] nums) {
        int max = nums[0];
        for(int i=1; i<nums.length; i++){
            int temp = 0;
            for(int j=0; j<i-1; j++){
                temp = Math.max(temp, nums[j]);
            }
            nums[i] += temp;
            max = Math.max(max, nums[i]);
        }
        return max;
    }
}
```
