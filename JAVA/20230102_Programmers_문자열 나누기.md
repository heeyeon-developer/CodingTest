# Level 1
1. 주어진 문자열의 첫 문자를 c에 저장
2. 1번째 위치부터 c와 동일한지 확인
3. c와 동일할 경우 cnt++, 다를경우 next++
4. cnt, next 값이 동일할 경우 answer++, idx가 s.length()와 동일할 경우 마지막이 카운팅 되지 않을것으로 answer+1 값을 반환
5. 이외의 경우 answer 반환


```java
class Solution {
    public int solution(String s) {
        int answer = 0;
        int idx = 1;
        Character c = s.charAt(0);
        int cnt = 1, next = 0;

        while(idx < s.length()){
            if(s.charAt(idx) == c){
                cnt++;
            }else{
                next++;
            }
            if(cnt == next){
                c = s.charAt(Math.min(++idx,s.length()-1));
                cnt = 1;
                next = 0;
                answer++;
            }
            idx++;
        }

        if(idx == s.length())
            return answer+1;
        else
            return answer;
    }
}
```
