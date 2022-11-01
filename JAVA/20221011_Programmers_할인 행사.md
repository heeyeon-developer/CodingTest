# 연습문제
1. 10개의 품목을 10일 이내에 살 수 있는지 체크하는 것으로 주어진 할인날짜를 10 개 묶음으로 묶어 확인
2. 10일 동안 살 수 있는 품목을 HashMap 을 이용해 '품목 : n' 의 형태로 저장
3. 사고자 하는 want, number 배열의 수와 map 의 수가 일치하면 가입할 수 있는 날짜 증가
4. 최종 가입 가능한 날짜가 저장된 answer 반환


```java
import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        boolean check = true;
        //10개 묶음으로 확인
        for(int i=0; i<=discount.length-10; i++){
            check = true;
            HashMap<String, Integer> map = new HashMap<>();
            
            for(int j=i; j<i+10; j++){
                map.put(discount[j], map.getOrDefault(discount[j],0)+1);
            }
            //want : number 과 같은지 확인
            for(int j=0; j<want.length; j++){
                if(map.getOrDefault(want[j],0) != number[j]){
                    check = false;
                    break;
                }
            }
            if(check){
                answer++;
            }
        }
        
        return answer;
    }
}
```
