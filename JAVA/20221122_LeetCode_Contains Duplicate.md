# Array
1. 중복된 수가 있다면 set에 추가시 기존의 nums[] 배열의 길이보다 작아짐
2. set.size() 와 nums.length 가 다르다면 true 같다면 false 를 반환


```java
import java.util.*;

class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i=0; i<nums.length; i++)
            set.add(nums[i]);
        return set.size() == nums.length ? false : true;
    }
}
```

- set 을 사용하지 않고 정렬하여 확인하는 방법


```java
import java.util.*;

class Solution {
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for(int i=0; i<nums.length-1; i++){
            if(nums[i] == nums[i+1])    return true;
        }
        return false;
    }
}
```
