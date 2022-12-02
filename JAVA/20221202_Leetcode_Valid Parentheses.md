# Others
1. 주어진 문자열에 닫힌 괄호가 입력되려면 길이가 1보다 커야하므로 체크
2. 1보다 큰 문자열일 경우 '(,[,{' 시작 괄호일 경우 stack 에 추가
3. '),],}' 닫는 괄호일 경우 stack에 시작괄호가 존재해야 하고(stack.size() > 0) 짝이 맞는지 체크
4. 짝이 맞지 않는다면 false를 반환
5. 모든 문자열을 확인하고 stack에 아직 남은 문자가 있다면 닫힌 괄호가 아니므로 false 반환
6. 모든 문자열을 확인하고 stack이 비었다면 닫힌 괄호가 맞으므로 true 반환


```java
class Solution {
    public boolean isValid(String s) {
        if(s.length() == 1) return false;
        
        Stack<Integer> stack = new Stack<>();
        
        for(int i=0; i<s.length(); i++){
            switch(s.charAt(i)){
                case '(':   {stack.push(1);  break;}
                case '[':   {stack.push(2);  break;}
                case '{':   {stack.push(3);  break;}
                case ')':   {   
                    if(stack.size() > 0 && stack.peek() == 1)
                            stack.pop();
                    else return false;
                        break;
                    }
                case ']':   {
                    if(stack.size() > 0 && stack.peek() == 2)
                            stack.pop();
                    else return false;
                        break;
                }
                case '}':   {
                    if(stack.size() > 0 && stack.peek() == 3)
                            stack.pop();
                    else return false;
                        break;
                }
            }
        }
        if(stack.size() > 0)
            return false;
        else 
            return true;
    }
}
```
