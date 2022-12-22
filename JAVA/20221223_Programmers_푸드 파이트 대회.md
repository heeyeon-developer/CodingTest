# Level 1
> 초기값을 잡아 활용할 생각 하기
1. 주어진 음식의 리스트의 각 갯수를 2로 나누어 참가자가 공평하게 사용할 수 있는지 확인
2. 2로 나누어지는 몫만큼 두명의 참가자 공평하게 나눌 수 있음
3. 한쪽의 참가자 목록을 만든 뒤에 가운데 물을 표시하는 "0"을 두고 반대편은 거꾸로 음식 리스트 만들어 반환


```java
class Solution {
    public String solution(int[] food) {
        String answer = "";
        
        for(int i=1; i<food.length; i++){
            for(int j=0; j<food[i]/2; j++){
                answer += i;
            }
        }
        
        answer += "0";
        int len = answer.length();
        
        for(int i=len-2; i>=0; i--){
            answer += Character.toString(answer.charAt(i));
        }
        
        return answer;
    }
}
```

> 초기값을 "0"으로 잡아 엄청 깔끔한 풀이
```java
class Solution {
    public String solution(int[] food) {
        String answer = "0";

        for (int i = food.length - 1; i > 0; i--) {
            for (int j = 0; j < food[i] / 2; j++) {
                answer = i + answer + i; 
            }
        }

        return answer;
    }
}
```
