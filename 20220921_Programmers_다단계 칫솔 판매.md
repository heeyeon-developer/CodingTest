# 2021 Dev-Matching: 웹 백엔드 개발자(상반기) LEVEL 3
> 문제에서 준 조건이 버림을 뜻하는지 반올림을 뜻하는지 올림을 뜻하는지 제대로 보기! 이번 문제는 버림이다!
1. referral 배열이 enroll 배열의 사람을 초대한 것으로 HashMap을 이용하여 (초대받은사람 : 초대한 사람 = enroll : referral) 로 묶기
2. seller 의 referral 가 center 가 아니고 이익의 10% 가 0이 아닐때까지 이익을 나누기
3. 이익이 발생할때 마다 answer 배열에 누적하여 저장하고 각각의 이익금이 저장된 answer 반환

```java
import java.util.*;

class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];
        HashMap<String, Integer> list = new HashMap<>();
        HashMap<String, String> map = new HashMap<>();
        String person = "";
        int calc = 0, give = 0;
        
        for(int i=0; i<enroll.length; i++){
            list.put(enroll[i], i);
            map.put(enroll[i], referral[i]);
        }
        
        for(int i=0; i<seller.length; i++){
            person = seller[i];
            calc = amount[i]*100;
            give = calc/10;
            answer[list.get(person)] += (calc - give);
            while(!map.get(person).equals("-") && calc != 0){
                calc = give;
                give = calc/10;
                person = map.get(person);
                answer[list.get(person)] += (calc - give);
            }
        }
        
        return answer;
    }
}
```
