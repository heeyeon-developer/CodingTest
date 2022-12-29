# Level 1
1. 주어진 문자열 t에서 p의 길이만큼 자른 부분 문자열을 tt라고 하면 tt, p를 Long으로 변환하여 비교
2. tt <= p 를 만족하면 answer++ 하여 최종 answer 값 반환


```java
class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        int len = t.length() - p.length();
        
        for(int i=0; i<=len; i++){
            if(Long.parseLong(t.substring(i,i+p.length())) <= Long.parseLong(p))
                answer++;
        }
        
        return answer;
    }
}
```
