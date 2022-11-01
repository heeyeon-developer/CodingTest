# 2022 KAKAO TECH INTERNSHIP
1. 주어진 지표 배열 survey 와 선택지 배열 choices 에서 survey 의 왼쪽이 비동의 답변의 점수, 오른쪽이 긍정적인 동의 점수 
2. 해쉬맵을 사용하여 8개의 지표의 값을 0으로 초기화, 만약 같은 종류의 지표의 답변 점수가 같을 경우 사전순으로 빠른 알파벳이 반환되어야 함
3. 비동의 선택지쪽 지표는 '4-선택지 숫자' 로 점수가 증가하고 동의 선택지쪽 지표는 '선택지 숫자-4' 만큼 점수가 증가, 4일 경우는 점수가 증가되지 않음
4. 모든 지표의 설문을 끝낸 후 같은 종류의 지표의 점수를 비교하여 점수가 높거나 사전순으로 빠른 알파벳으로 성격 유형 결과를 반환


```java
import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        Map<String, Integer> map = new HashMap<>();
        String[][] kind = {{"R","T"},{"C","F"},{"J","M"},{"A","N"}};
        String left, right;
        
        for(int i=0; i<4; i++){
            map.put(kind[i][0],0);
            map.put(kind[i][1],0);
        }
        
        for(int i=0; i<survey.length; i++){
            if(choices[i] < 4){
                left = Character.toString(survey[i].charAt(0));
                map.put(left, map.getOrDefault(left, 0)+(4-choices[i]));
            }else if(choices[i] > 4){
                right = Character.toString(survey[i].charAt(1));
                map.put(right, map.getOrDefault(right, 0)+(choices[i]-4));
            }
        }
                        
        for(int i=0; i<4; i++){
            if(map.get(kind[i][0]) < map.get(kind[i][1])){
                answer += kind[i][1];
            }else{
                answer += kind[i][0];
            }
        }
        
        return answer;
    }
}
```
