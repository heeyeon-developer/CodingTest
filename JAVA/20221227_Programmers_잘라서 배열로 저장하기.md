# Level 0
1. 주어진 문자열이 n으로 나누어 떨어지는지 확인하여 나누어 떨어지면 몫을 그대로 사용하고 나머지가 존재한다면 몫+1 을 하여 사용
2. answer[]에 잘린 단어를 추가할 때에 마지막 잘린 문자열의 길이가 n보다 작을경우 my_str.length()를 사용하여 자르기


```java
class Solution {
    public String[] solution(String my_str, int n) {
        String[] answer = new String[my_str.length()%n == 0 ? my_str.length()/n : my_str.length()/n+1];
            
        for(int i=0; i<(my_str.length()%n == 0 ? my_str.length()/n : my_str.length()/n+1); i++){
            answer[i] = my_str.substring(i*n,Math.min(my_str.length(),(i+1)*n));
        }
        
        return answer;
    }
}
```
