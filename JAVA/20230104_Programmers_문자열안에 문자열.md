# Level 0
1. 문자열1.contains(문자열2)를 사용하여 문자열1내에 문자열2가 존재한다면 1을 반환
2. 그렇지 않다면 2를 반환


```java
class Solution {
    public int solution(String str1, String str2) { 
        if(str1.contains(str2))
            return 1;
        return 2;
    }
}
```
