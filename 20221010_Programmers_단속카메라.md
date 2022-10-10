# 탐욕법
> 주어진 문제를 제대로 해석하는게 매우 중요한 문제, 창의적으로(?) 생각하고 주어진 배열을 오름차순 하려는 생각을 갖는게 중요!!
1. 주어진 차량의 경로를 오름차순 정렬
2. 오름차순은 차량의 경로가 끝나는 위치가 가장 빠른순으로 해야하는데    
   그 이유는 가장 빠르게 경로가 끝나는 차랑의 마지막 위치에 단속카메라를 설치하지 않으면 해당 차를 단속할 수 있는 방법은 없기 때문
3. 단속 카메라 초기 위치는 start = -30001 로 설정하고 정렬된 차량의 경로에서 i번째 차량의 경로 시작과 끝이 모두 start 보다 클 경우   
   단속카메라 설치가 필요하므로 answer++ 한 뒤 start 값을 현재 차량의 경로 끝으로 변경
4. 모든 차량을 확인하여 answer 값 반환


```java
import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int start = -30001;
        int answer = 0;
        Arrays.sort(routes,(a,b)->{return a[1]-b[1];});
        for(int i=0; i<routes.length; i++){
            if(routes[i][0] > start && routes[i][1] > start){
                start = routes[i][1];
                answer++;
            }
        }
        return answer;
    }
}
```
