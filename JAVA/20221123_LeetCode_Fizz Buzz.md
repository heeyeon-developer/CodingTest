# Math
1. idx가 3과 5로 나누어 진다면 'FizzBuzz'
2. idx가 3으로만 나누어 진다면 'Fizz'
3. idx가 5로만 나누어 진다면 'Buzz'
4. idx 가 3과 5로 모두 나누어 지지 않는다면 idx 를 list에 추가하여 반환


```java
class Solution {
    public List<String> fizzBuzz(int n) {
        ArrayList<String> list = new ArrayList<>();
        for(int i=1; i<=n; i++){
            if(i%3 == 0 && i%5 == 0){
                list.add("FizzBuzz");
            }else if(i%3 == 0){
                list.add("Fizz");
            }else if(i%5 == 0){
                list.add("Buzz");
            }else{
                list.add(Integer.toString(i));
            }
        }
        return list;
    }
}
```
