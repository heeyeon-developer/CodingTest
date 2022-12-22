# Level 1
1. 주어진 과일을 모두 판매할 때 최대의 수익을 나게 하기 위해서는 과일 묶음의 가장 낮은 과일의 점수가 높아야 함
2. 주어진 과일 점수 배열인 score을 오름차순 정렬하고 뒤에서부터 m개를 묶기
3. m개의 가장 낮은 점수는 가장 왼쪽의 과일이므로 score[i]*m을 이용해서 최대의 수익 계산하여 반환


```java
import java.util.*;

class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        Arrays.sort(score);
        for(int i=score.length-m; i>=0; i-=m){
            answer += m*score[i];
        }
        return answer;
    }
}
```
