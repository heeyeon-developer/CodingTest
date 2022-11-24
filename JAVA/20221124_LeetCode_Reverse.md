# String
> Reverse String
1. 주어진 문자열을 뒤집기 위해 문자열의 길이 절반을 기준으로 양 위치를 변경

```java
class Solution {
    public void reverseString(char[] s) {
        for(int i=0; i<s.length/2; i++){
            char temp = s[i];
            s[i] = s[s.length-i-1];
            s[s.length-i-1] = temp;
        }
    }
}
```

> Reverse Integer
1. 주어진 숫자를 뒤집기 위해 10으로 나눈 나머지와, 몫을 활용
2. 주어진 숫자가 int 범위를 넘어간다면 0 을 출력하기
3. 삼항연산자를 사용하기 위해 long 변수를 int 로 변경
```java
class Solution {
    public int reverse(int x) {
        int nx = Math.abs(x), remain = 0;;
        long result = 0;
        while(nx > 0){
            remain = nx%10;
            nx /= 10;
            result = result*10 + remain;
        }
        if(result > Math.pow(2,31)-1 || result < -1*Math.pow(2,31))
            return 0;
        int re = (int)result;
        return x > 0 ? re : -1*re;
    }
}
```
