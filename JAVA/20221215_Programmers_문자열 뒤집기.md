# 입문
1. 입력된 문자열을 뒤에서부터 1개씩 answer에 추가하여 문자열을 뒤집기


```java
class Solution {
    public String solution(String my_string) {
        String answer = "";
        
        for(int i=my_string.length()-1; i>=0; i--){
            answer = answer + my_string.charAt(i);
        }
        
        return answer;
    }
}
```
