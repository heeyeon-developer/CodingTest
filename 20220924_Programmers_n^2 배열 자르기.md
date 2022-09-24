# 월간 코드 챌린지 시즌3
> long 타입 체크 중요
1. left ~ right 사이의 배열값을 구하면 되므로 모든 반복 x 
2. idx 초기값을 left/n*n, 반복문 높이를 right/n 으로 주기

```java
class Solution {
    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int)(right-left)+1];
        long idx = (left/n > 0 ? (left/n)-1 : 0)*n;
        for(long i=(left/n > 0 ? (left/n)-1 : 0); i<=(right/n); i++){
            for(long j=0; j<n; j++){
                if(idx >= left && idx <= right){
                    if(i>=j){
                        answer[(int)(idx - left)] = (int)(i+1);
                    }else{
                        answer[(int)(idx - left)] = (int)(j+1);
                    }  
                }
                idx++;
            }
        }
        return answer;
    }
}
```
