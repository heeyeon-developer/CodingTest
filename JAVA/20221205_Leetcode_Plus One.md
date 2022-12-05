# Array
1. 주어진 배열보다 1개 더 큰 배열을 만들기
2. i번째 배열의 수에 1을 더하였을 경우 10보다 커질때에 나머지를 result[] 배열에 추가하고 next값 저장
3. i번째 배열의 수에 1을 더하였을 경우 10보다 작으면 digits[] 배열의 값 그대로 result[] 배열에 추가
4. 마지막의 next 값이 0보다 크다면 result[] 배열의 첫번째 수를 next로 저장후 result[] 배열 반환
5. 마지막의 next 값이 0이라면 크기가 n인 배열을 재 생성하여 reresult[] 배열 반환


```java
import java.util.*;

class Solution {
    public int[] plusOne(int[] digits) {
        int[] result = new int[digits.length+1];
        int next = 1;
        
        for(int i=digits.length; i>= 1; i--){
            if(next > 0){
                int temp = digits[i-1]+next;
                result[i] = temp%10;
                next = temp/10;
            }else{
                result[i] = digits[i-1];
                next = 0;
            }
        }
        
        if(next > 0){
            result[0] = next;
            return result;
        }else{
            int[] reresult = new int[result.length-1];
            for(int i=0; i<result.length-1; i++){
                reresult[i] = result[i+1];
            }
            return reresult;
        }
    }
}
```

> 문제를 이해하여 참고한 간단한 풀이

> 포인트는 마지막 수에 1을 더할 경우 9보다 작은 수일 경우 다른 수에 영향을 미치지 않음


```java
public int[] plusOne(int[] digits) {
        
    int n = digits.length;
    for(int i=n-1; i>=0; i--) {
        if(digits[i] < 9) {
            digits[i]++;
            return digits;
        }
        
        digits[i] = 0;
    }
    
    int[] newNumber = new int [n+1];
    newNumber[0] = 1;
    
    return newNumber;
}
```
