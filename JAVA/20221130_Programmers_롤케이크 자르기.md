# LEVEL 2
1. 주어진 롤 케이크를 두부분으로 잘라서 같은 토핑의 수를 가지게 하기 위해 left, right 2개의 HashMap 생성
2. 전체 토핑을 right에 추가 후 토핑의 위치만큼 잘라 나가기
3. left에 토핑을 추가하고 right에 토핑의 갯수를 감소시킨 후 해당 토핑의 수가 0일 경우 HashMap에서 제거
4. left,right의 토핑종류 즉 size()가 동일하면 동일한 토핑을 갖은것이므로 answer++
5. 모든 위치에서 나누어 보고 최종 answer 출력


```java
import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        HashMap<Integer, Integer> left = new HashMap<>();
        HashMap<Integer, Integer> right = new HashMap<>();
        for(int i=0; i<topping.length; i++){
            right.put(topping[i], right.getOrDefault(topping[i],0)+1);
        }
        for(int i=0; i<topping.length-1; i++){
            left.put(topping[i], left.getOrDefault(topping[i],0)+1);
            right.put(topping[i], right.getOrDefault(topping[i],0)-1);
            if(right.get(topping[i]) == 0)
                right.remove(topping[i]);
            if(left.size() == right.size())
                answer++;
        }
        return answer;
    }
}
```
