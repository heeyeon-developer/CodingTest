# 2022 KAKAO BLIND RECRUITMENT
1. k진수로 변환할 n을 받아서 10진수라면 그대로 문자열로 변경하고 10진수 이외의 진수라면 진법변환하여 문자열로 저장
2. 진법변환한 문자열을 "0"을 기준으로 나누어 nums 배열에 저장
    - 진법변환한 숫자가 커질 수 있으므로 Long 타입을 사용해야 함**
3. 0 이 연속될 경우 공백의 문자열이 nums 에 추가되었을 경우나 1일 경우 소수판별하지 않고 나머지는 소수판별하여 소수인경우 answer++
4. 최종 answer 값을 반환


```java
import java.util.*;

class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        String chg = "";
        if(k == 10){//10진수라면 그대로
            chg = Integer.toString(n);
        }else{//주어진 숫자를 k 진수로 변경
            chg = Integer.toString(n,k);
        }
        String[] nums = chg.split("0");//문자로 변경후 split 한 숫자들이 소수인지 판별
        for(String s : nums){
            if(s.length() == 0 || s.equals("1"))
                continue;
            long num = Long.parseLong(s);
            boolean check = true;
            
            for(long i=2; i<=Math.sqrt(num); i++){
                if(num%i == 0){
                    check = !check;
                    break;
                }   
            }
            if(check)//소수라면 answer++
                answer++;
        }
        return answer;
    }
}
```
