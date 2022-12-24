# Level1
1. 주어진 문자열의 길이만큼 자신의 앞에 존재하는 같은 문자열까지의 거리를 찾아야 하므로 new int[s.length()]로 초기화
2. 첫번째 문자는 자신보다 앞선 문자열이 존재하지 않으므로 항상 -1
3. 자신보다 앞선 문자열에 동일한 문자가 존재하는지 체크하는 변수 check
4. s문자열의 i-1부터 0까지 현재 i위치의 문자열과 같은 문자열 있는지 체크
5. 만약 존재한다면 거리를 i-j로 계산하여 answer[i]에 추가하고 중단
6. 만약 i-1부터 0까지 확인했을때 동일한 문자가 없다면 check로 확인후 answer[i] = -1 로 변경하여 모두 확인후 answer 반환


```java
class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        answer[0] = -1;
        
        for(int i=1; i<s.length(); i++){
            boolean check = true;
            for(int j=i-1; j>=0; j--){
                if(s.charAt(j) == s.charAt(i)){
                    check = false;
                    answer[i] = i-j;
                    break;
                }
            }
            if(check)
                answer[i] = -1;
        }
        
        return answer;
    }
}
```
