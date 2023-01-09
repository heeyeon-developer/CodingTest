# Level 0
1. 주어진 array[]의 배열에 담긴 수들 중 7의 갯수를 찾아야 하므로 각 숫자를 반복문을 통해 확인
2. i번째 숫자를 10으로 나누어서 나머지가 7일 경우 answer++
3. 나머지를 체크한 후 i번째 숫자를 10으로 나눈 몫으로 바꾸어 0보다 클때까지 확인
4. array[]배열의 모든 숫자를 확인 후 answer 반환


```java
class Solution {
    public int solution(int[] array) {
        int answer = 0;
        
        for(int i=0; i<array.length; i++){
            while(array[i] > 0){
                if(array[i]%10 == 7){
                    answer++;
                }
                array[i]/=10;
            }
        }
        
        return answer;
    }
}
```
