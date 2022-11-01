# 월간 코드 챌린지 시즌2
1. 문제에서 2진수로 바꾸었을 경우 최대 2개의 비트만 다른 가장 작은 수를 찾는 것이 포인트
2. 3가지로 경우를 나누어서 생각
    - 이진수가 모두 1일때 : i번째 수에 2^(i번째 수의 이진수의 길이-1) 을 더한 수
    - 이진수의 마지막이 0일때 : i번째 수에 1을 더한 수
    - 이진수의 마지막이 0이 아니지만 0이 존재할때 : i번째 수에 2^(i번째 수의 이진수의 끝에서 부터 가장 처음 나온 0의 위치-1) 을 더한 수
3. 2개의 비트값만 달라야 하므로 주어진 수에서 최대 2개의 비트만 다른경우를 나열하면 위와 같은 규칙으로 원하는 숫자를 얻을 수 있음


```java
class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];     
        
        for(int i=0; i<numbers.length; i++){
            String num = Long.toBinaryString(numbers[i]);
            if(!num.contains("0")){//이진수로 변경시 모두 1일 경우
                answer[i] = numbers[i] + (long)Math.pow(2,num.length()-1);
            }else if(num.charAt(num.length()-1) == '0'){//마지막 수가 0일 경우
                answer[i] = numbers[i] + 1;
            }else{//이진수로 변경시 0이 존재할 경우 
                int idx = 1;
                for(int j=num.length()-2; j>=0; j--){
                    if(num.charAt(j) == '0'){
                        break;
                    }
                    idx++;
                }
                answer[i] = numbers[i] + (long)Math.pow(2,idx-1);
            }
        }
        
        return answer;
    }
}
```
