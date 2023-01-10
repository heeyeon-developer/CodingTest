# Level 0
1. 주어진 수 n이 1시간마다 2배로 증가할때 t시간 지난 후의 세균 갯수를 알기위해 2^t 를 곱해주기 위해 Math.pow() 사용하여 반환


```java
class Solution {
    public int solution(int n, int t) {
        return n*(int)Math.pow(2,t);
    }
}
```
