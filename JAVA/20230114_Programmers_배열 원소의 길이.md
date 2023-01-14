# Level 0
1. 주어진 strlist[] 배열에 담긴 문자열의 길이를 for문을 돌며 answer[]배열에 값 넣어 반환


```java
class Solution {
    public int[] solution(String[] strlist) {
        int[] answer = new int[strlist.length];
        
        for(int i=0; i<strlist.length; i++){
            answer[i] = strlist[i].length();
        }
        
        return answer;
    }
}
```
