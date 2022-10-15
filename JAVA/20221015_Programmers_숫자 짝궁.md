# 연습문제
> HashMap, StringBuilder 를 이용하는게 포인트!!
1. 주어진 두개의 문자열 X,Y 를 hashmap을 이용하여 0~9까지 가진 숫자수를 저장
2. 두개의 맵의 키셋에서 더 큰 키셋을 고르고 내림차순 정렬
3. 키셋을 돌면서 두 맵에 모두 존재하는 키일때 키값이 더 작은 수만큼 키값을 answer 에 추가
4. 최종 answer 값을 stinrg 형태로 반환


```java
import java.util.*;

class Solution {
    public String solution(String X, String Y) {
        StringBuilder answer = new StringBuilder();
        HashMap<Character, Integer> xmap = new HashMap<>();
        HashMap<Character, Integer> ymap = new HashMap<>();
        
        for(int i=0; i<X.length(); i++){
            char xc = X.charAt(i);
            xmap.put(xc, xmap.getOrDefault(xc, 0)+1);
        }
        for(int i=0; i<Y.length(); i++){
            char yc = Y.charAt(i);
            ymap.put(yc, ymap.getOrDefault(yc, 0)+1);
        }
        Set<Character> keys;
        if(xmap.keySet().size() > ymap.keySet().size()){
            keys = xmap.keySet();
        }else{
            keys = ymap.keySet();
        }
        ArrayList<Character> klist = new ArrayList<>(keys);
        Collections.sort(klist, Collections.reverseOrder());
        for(Character c : klist){
            if(xmap.get(c)!= null&& ymap.get(c) != null){
                int len = Math.min(xmap.get(c),ymap.get(c));
                for(int i=0; i<len; i++){
                    answer.append(c);
                }
            }
        }
        if(answer.toString().equals(""))
            return "-1";
        else if(answer.toString().charAt(0) == '0')
             return "0";
        return answer.toString();
    }
}
```
