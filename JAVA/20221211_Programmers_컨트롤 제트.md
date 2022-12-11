# 입문
1. 주어진 문자열을 " "으로 구분하여 nums[] 배열에 넣기
2. 만약 nums[i] 에 담긴 문자열이 "Z"일 경우 nums[i-1]을 제거하고 "Z"가 아닐 경우 answer에 더해주어 최종 answer 값 반환


```java
class Solution {
    public int solution(String s) {
        int answer = 0;
        String[] nums = s.split(" ");
        
        for(int i=0; i<nums.length; i++){
            if(nums[i].equals("Z") && i > 0){
                answer -= Integer.parseInt(nums[i-1]);
            }else if(!nums[i].equals("Z")){
                answer += Integer.parseInt(nums[i]);
            }
        }
        
        return answer;
    }
}
```
