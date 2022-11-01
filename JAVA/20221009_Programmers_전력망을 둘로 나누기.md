# 완전탐색
1. 주어진 wires 배열을 이용하여 그래프를 그릴때 i번째 연결을 제외하여 그래프를 그리기
2. i번째 연결을 제외하여 그린 후 que와 visited를 이용하여 현재 그려진 그래프에서 이어진 노드의 수를 구하기
3. '구한 노드의수 - (전체 노드의 수 - 구한 노드의 수)'의 절대값이 현재의 answer 값보다 잘을때 갱신하여 answer 값 반환


```java
import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        int answer = n;
        
        for(int i=0; i<wires.length; i++){
            int num = 0, next = 0;
            int[] visited = new int[n];
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            Queue<Integer> que = new LinkedList<>();
            HashSet<Integer> set = new HashSet<>();
            que.add(1);
            set.add(1);
            for(int j=0; j<n; j++){
                list.add(new ArrayList<Integer>());
            }
            for(int j=0; j<wires.length; j++){
                if(j == i)//i번째 제외하여 추가
                    continue;
                list.get(wires[j][0]-1).add(wires[j][1]);
                list.get(wires[j][1]-1).add(wires[j][0]);
            }
            while(!que.isEmpty()){
                int node = que.poll();
                for(int j=0; j<list.get(node-1).size(); j++){
                    next = list.get(node-1).get(j);
                    if(visited[next-1] == 0){
                        que.add(next);
                        set.add(next);
                        visited[next-1] = 1;
                    }
                }
            }
            num = set.size();
            if(Math.abs(num - (n-num)) < answer){
                answer = Math.abs(num - (n-num));
            }
        }
        //두 차이를 구해서 작다면 갱신
        return answer;
    }
}
```
