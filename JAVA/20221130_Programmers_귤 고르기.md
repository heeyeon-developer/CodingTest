# LEVEL 2
1. 주어진 귤의 크기를 HashMap<>을 이용하여 크기별 갯수를 저장
2. map의 갯수(value)기준으로 내림차순 정렬 후 갯수를 sum에 누적하여 저장
3. sum의 값의 값이 k보다 작을경우 answer++ 하고 k값과 같거나 커지는 경우 중단하여 answer값 반환


```java
import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        
        for(int i=0; i<tangerine.length; i++){
            map.put(tangerine[i], map.getOrDefault(tangerine[i],0)+1);
        }
      
        ArrayList<Integer> keys = new ArrayList<>(map.keySet());
        Collections.sort(keys, (o1,o2) -> (map.get(o2).compareTo(map.get(o1))));
        
        for(int i=0; i<keys.size(); i++){
            if(sum < k){
                answer++;
                sum += map.get(keys.get(i));
            }else
                break;
        }
      
        return answer;
    }
}
```
