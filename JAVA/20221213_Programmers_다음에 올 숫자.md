# 입문
1. 등차수열인지 등비수열인지 판단하기 위해서는 0,1,2의 규칙을 파악하면 됨
2. 0,1의 차이와 1,2의 차이를 각각 a,b변수에 저장 후 두 값이 같다면 등차수열, 두 값이 다르다면 등비수열로 판단하여 answer 값 반환


```java
class Solution {
    public int solution(int[] common) {
        int answer = 0;
        int a = common[1] - common[0], b = common[2] - common[1];
        
        if(a == b){
            answer = common[common.length-1] + a;
        }else{
            answer = common[common.length-1] * (b/a);
        }
        
        return answer;
    }
}
```
