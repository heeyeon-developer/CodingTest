# Summer/Winter Coding(~2018)
1. 주어진 road 배열을 이용하여 연결된 도로와 시간을 list에 저장
2. visited 배열을 이용하여 한번 들린 지점을 중복하여 들리지 않게 체크
3. 최대 배달 가능 시간인 K 보다 작거나 같을 경우 set 에 배달 가능한 마을로 추가
4. 최종적으로 배달 가능한 위치가 담긴 set의 크기가 주문을 받을수 있는 마을의 개수이므로 set의 크기 반환


```java
import java.util.*;

class Solution {
    ArrayList<ArrayList<int[]>> list = new ArrayList<>();
    HashSet<Integer> set = new HashSet<>();
    public int solution(int N, int[][] road, int K) {
        int[] visited = new int[N];
        for(int i=0; i<N; i++){
            list.add(new ArrayList<>());
        }
        for(int i=0; i<road.length; i++){
            list.get(road[i][0]-1).add(new int[]{road[i][1],road[i][2]});
            list.get(road[i][1]-1).add(new int[]{road[i][0],road[i][2]});
        }
        visited[0] = 1;
        dfs(0,0, K, visited);
        return set.size();
    }
    public void dfs(int node, int len, int max, int[] visited){
        if(len <= max)  set.add(node);
        else    return;
        for(int i=0; i<list.get(node).size(); i++){
            if(visited[list.get(node).get(i)[0]-1] == 0){
                visited[list.get(node).get(i)[0]-1] = 1;
                dfs(list.get(node).get(i)[0]-1, len + list.get(node).get(i)[1], max, visited);
                visited[list.get(node).get(i)[0]-1] = 0;
            }
        }
    }
}
```
