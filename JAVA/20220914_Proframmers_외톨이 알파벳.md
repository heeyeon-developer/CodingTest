# PCCP 모의고사 #1
1. 외톨이 알파벳은 주어진 문자열에 2회이상 연속되지 않게 나타나지 않는 알파벳을 의미함
2. 연속되지 않는 조건을 체크하기 위해 주어진 문자열을 deque에 추가할 때 중복을 제거하여 추가
3. 중복이 제거된 알파벳이 존재하는 deque 에서 맨 앞의 알파벳을 꺼낸 후 deque에 여전히 꺼낸 알파벳이 존재한다면 외톨이 알파벳이므로 set 에 추가
4. set을 사용한 이유는 중복을 제거하기 위함이고 그 중 TreeSet()을 사용한 이유는 외톨이 알파벳을 사전순서대로 출력하기 위함
5. 외톨이 알파벳이 존재하지 않는다면 set 의 크기가 0일때 "N"을 반환하고 외톨이 알파벳이 존재한다면 사전순으로 정렬하여 answer 에 추가하여 반환


```java
import java.util.*;

class Solution {
    public String solution(String input) {
        String answer = "", alp = "";
        StringBuilder sb = new StringBuilder();
        Deque<String> deque = new LinkedList<>();
        Set<String> set = new TreeSet<>();
        
        deque.add(Character.toString(input.charAt(0)));
        //반복되는 알파벳 제거
        for(int i=1; i<input.length(); i++){
            alp = Character.toString(input.charAt(i));
            if(!deque.peekLast().equals(alp))
                deque.add(alp);
        }
        //뒤에 동일한 알파벳 존재하면 외톨이 알파벳
        while(!deque.isEmpty()){
            String ch = deque.poll();
            if(deque.contains(ch))
                set.add(ch);
        }
        if(set.size() == 0)
            return "N";
        set.stream().forEach(ch -> sb.append(ch));
        answer = sb.toString();
        return answer;
    }
}
```
