# 연습문제
> dp는 무조건 점화식이 중요!!
1. n 번째 멀리뛰는 방법은 n-1번째에서 1칸 더 뛰거나 n-2번째에서 2칸 더 뛰는 방법이 존재
2. 그렇기 때문에 dp[2001](1 <= n <= 2000 이므로) 에 dp[1] = 1, dp[2] = 2 로 저장 후 n까지의 방법 수 계산


```java
class Solution {
    public long solution(int n) {
        int[] dp = new int[2001];
        
        dp[1] = 1;
        dp[2] = 2;
        
        for(int i=3; i<=n; i++){
            dp[i] = (dp[i-2] + dp[i-1])%1234567;
        }
        
        return dp[n];
    }
}
```
