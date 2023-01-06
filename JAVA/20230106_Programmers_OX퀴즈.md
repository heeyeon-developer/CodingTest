# Level0
1. 주어진 수식은 '숫자1,연산자,숫자2,등호,숫자3' 형식으로 고정되어 있으므로 이를 활용
2. 연산자가 '-'일 경우에는 '숫자1 + (-1)*숫자2' 형식으로 더하여 '숫자3'과 비교
3. 연산자가 '+'일 경우에는 '숫자1 + 숫자2' 를 더하여 '숫자3'과 비교
4. 더한값과 숫자3이 동일할 경우 answer[]배열에 'O'를 추가하고 다를 경우 'X'를 추가하여 최종 answer[]배열 반환


```java
class Solution {
    public String[] solution(String[] quiz) {
        String[] answer = new String[quiz.length];
        
        for(int i=0; i<answer.length; i++){
            String[] temp = quiz[i].split(" ");
            answer[i] = Integer.parseInt(temp[4]) == (Integer.parseInt(temp[0]) + (temp[1].equals("-") ? -1 : 1)*Integer.parseInt(temp[2])) ? "O" : "X";
        }
        
        return answer;
    }
}
```
