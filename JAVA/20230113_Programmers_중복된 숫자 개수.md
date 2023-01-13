> Level 0
1. 주어진 array[]배열의 값 중 n과 같은 숫자일 경우 answer += 1
2. n과 다른 숫자일 경우 answer 값이 증가되지 않아야 하므로 answer += 0
3. 최종 answer값을 반환


```java
import java.util.*;

class Solution {
    public int solution(int[] array, int n) {
        int answer = 0;
        
        for(int i=0; i<array.length; i++){
            answer += array[i] == n ? 1 : 0;
        }
        
        return answer;
    }
}
```
> HashMap을 이용할 수도 있지만 시간이 더 오래 걸림
```java
import java.util.*;

class Solution {
    public int solution(int[] array, int n) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i=0; i<array.length; i++){
            map.put(array[i], map.getOrDefault(array[i],0)+1);
        }
        
        return map.getOrDefault(n,0);
    }
}
```
