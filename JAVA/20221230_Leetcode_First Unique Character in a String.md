# String
1. 주어진 문자열에 각 문자가 몇개씩 존재하는지 HashMap<>을 이용하여 저장
2. 모두 확인 후 문자열의 문자를 순서대로 확인하면서 중복되어 사용되지 않은 문자열일 경우 idx 반환
3. 모든 문자가 2개 이상 사용된 경우 -1을 출력


```java
import java.util.*;

class Solution {
    public int firstUniqChar(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        
        for(int i=0; i<s.length(); i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i),0)+1);
        }           
        
        for(int i=0; i<s.length(); i++){
            if(map.get(s.charAt(i)) == 1)
                return i;
        }
        
        return -1;
    }
}
```
