# Level 0
1. 1부터 num 갯수만큼 누적하여 check 변수에 저장
2. check 값이 total 과 같다면 answer[] 에 1부터 증가하는 num개의 숫자 추가하여 반환
3. check 값이 total 과 다르다면 while문을 사용하여 check 값이 total 보다 큰지 작은지 체크하여 left, right 값을 더하고 빼주기
4. check 값이 total과 같아질 경우 while문 중단 후 left로 시작하여 증가하는 num개의 숫자를 answer[] 배열에 추가하여 반환


```java
class Solution {
    public int[] solution(int num, int total) {
        int[] answer = new int[num];
        int check = 0, left = 1, right = num;
        
        for(int i=left; i<=right; i++){
            check += i;
        }
        
        if(check == total){
            for(int i=0; i<num; i++){
                answer[i] = i+1;
            }
            return answer;
        }else{
            while(check != total){
                if(check > total){
                    check += --left;
                    check -= right--;
                }else if(check < total){
                    check -= left++;
                    check += ++right;
                }
            }
        }
        
        for(int i=0; i<num; i++){
            answer[i] = left++;
        }
        
        return answer;
    }
}
```
