# Others
1. 주어진 배열의 길이까지의 숫자가 존재하는지 체크할 check[] 배열 생성
2. nums[] 배열에 존재하는 숫자는 check[]++로 체크하기
3. 모두 체크한 후 check[] 배열이 0인 숫자가 존재하지 않는 숫자이므로 반환


```java
class Solution {
    public int missingNumber(int[] nums) {
        int[] check = new int[nums.length];
        
        for(int i=0; i<nums.length; i++){
            if(nums[i] == 0)
                continue;
            check[nums[i]-1]++;
        }
        
        for(int i=0; i<nums.length; i++){
            if(check[i] == 0)
                return i+1;
        }
        
        return 0;
    }
}
```
