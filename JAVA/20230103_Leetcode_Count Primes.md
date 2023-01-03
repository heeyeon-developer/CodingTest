# Math
> 에라토스테네스트의 체 알고리즘 복습
1. 주어진 숫자 n 보다 작은 수들중에서 소수를 찾기 위해 n개의 크기만큼 배열 생성
2. n보다 작은 수들을 최초 소수인 2부터 확인하여 i번째 수는 소수, i가 2개 이상 존재하는 수는 소수가 아닌 1로 소수 아님으로 체크
3. 2번에서 소수가 아닌 수들이 1로 체크되므로 n의 수까지 반복하여 제외되지 않은 수들은 소수이므로 cnt++해서 최종 소수의 갯수 반환


```java
class Solution {
    public int countPrimes(int n) {
        int cnt = 0;
        int[] nums = new int[n];
        
        for(int i=2; i<n; i++){
            if(nums[i] == 0){
                cnt++;
                for(int j=i+i; j<n; j+=i){
                    nums[j] = 1;
                }
            }
        }
        
        return cnt;
    }
}
```
