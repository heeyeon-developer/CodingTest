# 연습문제
1. 1부터 주어진 순서 길이만큼 반복
2. 주어진 순서면 answer++, 체크해야 하는 순서 넘어가기
3. 순서가 아니라면 스택에 추가
4. 스택이 비어있지 않고 스택의 top이 주어진 순서라면 answer++, 스택이 비거나 더이상 순서와 맞지 않는다면 while 끝내기
5. 최종적으로 순서에 맞는 갯수 반환


```java
import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0, idx = 0;
        Stack<Integer> stack = new Stack<>();
        System.out.println(idx);
        for(int i=1; i<=order.length; i++){
            //순서면 answer++, idx++;
            if(i==order[idx]){
                answer++;
                idx++;
            }else{
                stack.add(i);//순서대로 넣기전 order 인지 확인 아니면 stack 에 넣기
            }
            //stack이 비어있지 않다면 뺄 수 있는지 체크
            //더이상 못빼거나 비었으면 그만
            while(!stack.isEmpty() && stack.peek() == order[idx]){
                stack.pop();
                answer++;
                idx++;
            }            
        }
        return answer;
    }
}
```
