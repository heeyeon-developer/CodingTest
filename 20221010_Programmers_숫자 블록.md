# 연습문제
1. 문제를 이해하여 내린 결론은 n번째에 존재하는 수는 n번째 수의 가장 큰 약수를 의미
2. 주의해야 할 점은 10000000 보다 큰 수는 사용되지 않는다는 점
3. i번째 위치의 가장 큰 약수를 구하고 해당 약수가 1000000보다 크다면 1로 추가하여 최종 배열을 반환


```java
class Solution {
    public int[] solution(long begin, long end) {
        int len = (int)(end-begin)+1;
        int[] answer = new int[len];
        
        for(int i=0; i<len; i++){
            answer[i] = begin+i == 1 ? 0 : (int)find(begin+i);
        }
        
        return answer;
    }
    public long find(long num){
        for(long i=2; i<=Math.sqrt(num); i++){
            if(num%i == 0 && num/i <= 10000000){
                return num/i;
            }
        }
        return 1;
    }
}
```
