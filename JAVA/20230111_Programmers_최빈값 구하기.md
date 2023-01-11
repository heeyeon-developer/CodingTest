# Level 0
1. 주어진 array[]배열에 같은 수가 나타난 빈도를 HashMap<>에 'key = 수, value = 빈도'로 저장
2. HashMap의 최빈값을 max에 저장
3. max값과 동일한 빈도로 나타난 key 값이 존재할 경우 answer = k 저장
4. 만약 answer에 값이 존재하는데 또 변경되려고 한다면 1개 이상의 동일한 최빈값이 존재하는 것이므로 -1 반환
5. answer 값이 한번만 변경될 경우 최빈값은 하나이므로 answer 반환


```java
import java.util.*;

class Solution {
    public int solution(int[] array) {
        int answer = 0, max = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i=0; i<array.length; i++){
            map.put(array[i], map.getOrDefault(array[i],0)+1);
        }
        
        ArrayList<Integer> keys = new ArrayList<>(map.keySet());
        for(Integer k : keys){
            if(max < map.get(k)){
                max = map.get(k);
            }
        }
        for(Integer k : keys){
            if(max == map.get(k)){
                if(answer != 0)
                    return -1;
                answer = k;
            }
        }
        return answer;
    }
}
```

> (참고) 같은 방법이지만 더욱 간편하게 코드 작성할 수 있음
```java
import java.util.*;
class Solution {
    public int solution(int[] array) {
        int maxCount = 0;
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int number : array){
            int count = map.getOrDefault(number, 0) + 1;
            if(count > maxCount){
                maxCount = count;
                answer = number;
            }
            else  if(count == maxCount){
                answer = -1;
            }
            map.put(number, count);
        }
        return answer;
    }
}
```
