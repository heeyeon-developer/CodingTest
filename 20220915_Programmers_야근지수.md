# Level3 연습문제
1. 퇴근까지 남은시간 n과 남은 일의 목록 works가 주어질때 야근 피로도는 works의 각 일의 양의 제곱의 합으로 계산
2. 야근 피로도가 낮아지기 위해서는 works에 작은 수들이 존재해야 하므로 PriorityQueue를 사용하여 works의 가장 큰 양의 일들을 처리해 나가기
3. 일을 처리하면서 퇴근시간 전까지 모든 일을 마무리 했다면 pqueue에 추가하는 값이 -1이 되므로 0을 반환
4. 남은 일의 목록의 양을 각각 제곱하여 더해서 반환


```java
import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Integer> pqueue = new PriorityQueue<>(Collections.reverseOrder());
        int work = 0;
        
        for(int w : works){
            pqueue.add(w);
        }
        for(int i=0; i<n; i++){
            work = pqueue.poll()-1;
            if(work < 0)
                return 0;
            pqueue.add(work);
        }
        
        while(!pqueue.isEmpty()){
            answer += Math.pow(pqueue.poll(),2);
        }
        
        return answer;
    }
}
```
