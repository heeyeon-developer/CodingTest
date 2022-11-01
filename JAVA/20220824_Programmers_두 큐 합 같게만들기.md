# 2022 KAKAO TECH INTERNSHOP
1. 길이가 같은 큐 2개가 배열로 주어질 때 큐의 수들을 이동하여 두 큐의 수들의 합이 동일하게 만들기 위한 최소 이동 수를 구하는 문제
2. 먼저 두 배열에 담긴 수들을 LinkedList를 이용하여 queue에 추가하고 추가하면섯 각각의 큐에 담긴 수의 총합을 sum1, sum2 에 저장
3. que1의 수들의 합인 sum1 이 que2의 수들의 합인 sum2 보다 클경우 que1의 첫번째 수(num)를 que2의 마지막에 담고   
   sum1 -= num, sum2 += num 으로 변경하며 sum1 < sum2일 경우 반대로 진행
4. while문을 통해 'sum1 == sum2'가 될때까지 반복하며 만약 queue의 모든 수들을 이동할 경우에도 sum1 != sum2일 경우 -1을 반환
5. 이때 주의할 점은 que1에 큰수가 몰려있고 que2에 작은수들만 담겨있어서 queue1.length*2보다 많은 횟수의 수가 이동할 경우가 있으므로   
   while의 조건을 answer <= queue1.length*2 가 아닌 answer <= queue1.length*3(queue1.length*2 보다는 큰 수로 조건을 주어야 하는것이 포인트
   ex) 	[1, 1, 1, 8, 10, 9], [1, 1, 1, 1, 1, 1] 일 경우 queue1.length*2 = 12 이지만 answer = 14 입니다. (프로그래머스 질문하기 예시를 참고하였습니다.)
   
   
```java
import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0, num = 0;
        long sum1 = 0, sum2 = 0;
        Queue<Integer> que1 = new LinkedList<>(), que2 = new LinkedList<>();
        for(int i=0; i<queue1.length; i++){
            que1.add(queue1[i]);
            sum1 += queue1[i];
            que2.add(queue2[i]);
            sum2 += queue2[i];
        }
        if((sum1+sum2)%2 != 0)
            return -1;
        
        while(sum1 != sum2 && answer <= queue1.length*3){
            if(sum1 < sum2){
                num = que2.poll();
                sum1 += num;
                sum2 -= num;
                que1.add(num);
            }else{
                num = que1.poll();
                sum2 += num;
                sum1 -= num;
                que2.add(num);
            }
            answer++;
        }
        return answer > queue1.length*3 ? -1 : answer;
    }
}
```
