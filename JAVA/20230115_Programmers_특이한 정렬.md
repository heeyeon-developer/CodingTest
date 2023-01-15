# Level 0
1. 주어진 numlist[]배열의 수와 n의 차이를 Math.abs()을 이용해 절댓값으로 계산하여 HashMap<>()에 저장
2. 'key : value = n과 numlist[i]의 차이 절댓값 : numlist[i] 번째 수'의 형식으로 저장
3. map의 key값들을 ArrayList<>()로 받아서 오름차순 정렬
4. key값들에 해당하는 숫자들을 ArrayList<>()로 받아 내림차순 정렬하여 answer[] 배열에 저장하여 최종 answer[]배열 반환


```java
import java.util.*;

class Solution {
    public int[] solution(int[] numlist, int n) {
        int[] answer = new int[numlist.length];
        int idx = 0;
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        
        for(int i=0; i<numlist.length; i++){
            int num = Math.abs(n-numlist[i]);
            if(map.get(num) != null)
                map.get(num).add(numlist[i]);
            else{
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(numlist[i]);
                map.put(num, temp);
            }
        }
        
        ArrayList<Integer> keys = new ArrayList<>(map.keySet());
        Collections.sort(keys);
        
        for(Integer k : keys){
            ArrayList<Integer> tempK = map.get(k);
            Collections.sort(tempK, Collections.reverseOrder());
            for(int i=0; i<tempK.size(); i++){
                answer[idx++] = tempK.get(i);
            }
        }
        
        return answer;
    }
}
```
