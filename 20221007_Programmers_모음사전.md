# 완전탐색
1. i번째 자리를 넘어갈 때에 생성될 수 있는 최소 숫자 규칙 구하기
2. 주어진 word의 문자열이 되려면 각 자리가 몇번 반복되어야 하는지 확인


```java
class Solution {
    public int solution(String word) {
        int answer = 0;
        int total= 3905;
        String aeiou="AEIOU";
        
        for(String str: word.split("")){
            //781, 156, 31, 6, 1
            total/= 5;
            answer+= total*aeiou.indexOf(str)+1;
        }
        
        return answer;
    }
}
```
