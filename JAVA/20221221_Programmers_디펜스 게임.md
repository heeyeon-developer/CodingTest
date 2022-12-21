# LEVEL 2
1. 주어진 적의 수를 PriorityQueue<> pq에 순서대로 담아 나가기
2. 만약 pq의 길이가 방어권의 크기인 k보다 커진다면 가장 작은 적의 수 enemy[i]를 병사수n에서 빼기
3. 병사수가 음수가 된다면 더이상 진행할 수 없으므로 현재의 i 값이 라운드수로 출력 (i-1 을 해 줄 필요가 없음)
4. 만약 모든 라운드를 진행 가능하다면 enemy.length 만큼의 모든 라운드가 가능한 것으로 출력


```java
import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i=0; i<enemy.length; i++){
            pq.add(enemy[i]);
            if(pq.size() > k)
                n -= pq.poll();
            if(n < 0)
                return i;
        }
        
        return enemy.length;
    }
}
```
