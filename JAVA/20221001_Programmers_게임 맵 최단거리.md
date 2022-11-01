# 깊이/너비 우선 탐색(DFS/BFS)
1. 주어진 maps 에서 지나갈때마다의 거리를 누적해서 visited[][] 배열에 저장
2. 시작위치를 que 에 넣고 동,서,남,북 이동 가능한지 체크하여 이동가능할 경우 que에 추가
3. que 에 원소가 존재할 경우 while 문 반복하며 n*m 크기의 맵이 주어질때 maps[n-1][m-1] 에 도착할 경우 반복문 중단
4. visiter[n-1][m-1] 위치의 값을 답으로 반환
5. map[n-1][m-1] 에 도달하지 못할경우 -1 반환


```java
import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int answer = Integer.MAX_VALUE;
        int dy = maps.length, dx = maps[0].length;
        int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
        int[][] visited = new int[dy][dx];
        Queue<int[]> que = new LinkedList<>();
        
        que.add(new int[]{0,0});
        visited[0][0] = 1;
        
        while(!que.isEmpty()){
            int[] check = que.poll();
            int y = check[0], x = check[1];
            
            for(int i=0; i<4; i++){
                int ty = y+dir[i][0], tx = x+dir[i][1];
                if(0<=ty && ty<dy && 0<= tx && tx<dx && maps[ty][tx] == 1 && visited[ty][tx] == 0){
                    que.add(new int[]{ty,tx});
                    visited[ty][tx] = visited[y][x]+1;
                    if(ty == dy-1 && tx == dx-1){
                        answer = visited[ty][tx];
                        que.clear();
                        break;
                    }
                }     
            }   
        }
        
        return answer == Integer.MAX_VALUE ? -1 : answer;
    }
}
```
