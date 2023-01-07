# Array
1. 주어진 nums[] 배열에서 두 수를 더했을 때 target과 동일한 값이 될 때의 index를 찾기
2. 같은 위치의 두 수를 더하지 않기 위해 'i != j' 조건 추가
3. 더한 두 수가 target과 같다면 answer[] 배열에 index를 저장 하고 find 변수를 통해 반복문 종료하여 answer[]값 반환


```java
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] answer = new int[2];
        boolean find = false;
        
        for(int i=0; i<nums.length; i++){
            for(int j=0; j<nums.length; j++){
                if(i != j && nums[i] + nums[j] == target){
                    answer[0] = i;  answer[1] = j;
                    find = true;
                    break;
                }
            }
            if(find)
                break;
        }
        
        return answer;
    }
}
```

> (참고) HashMap과 1개의 for문을 이용한 풀이
```java
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n=nums.length;
        Map<Integer,Integer> map=new HashMap<>();
        int[] result=new int[2];
        for(int i=0;i<n;i++){
            if(map.containsKey(target-nums[i])){
                result[1]=i;
                result[0]=map.get(target-nums[i]);
                return result;
            }
            map.put(nums[i],i);
        }
        return result;
    }
}
```
