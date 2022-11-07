# Level 1
> 주어진 햄버거의 재료의 구조를 파악 '1231231'일 경우 처음부터 1개의 햄버거 만들기 가능
1. 햄버거의 재료가 숫자로 나타나진 '1231의 check 틀 구성
2. 주어진 재료를 list에 차례대로 추가 후 while 문을 통해 list의 길이가 4 이상일때 까지 햄버거 만들기 가능여부 확인
3. 4개의 재료가 순서대로 들어있는지 확인 후 '1231' 순서로 들어있을 경우 해당 재료를 list에서 제거 후 answer++
4. 재료를 제거한 뒤에 idx-3 이 아닌 idx-2를 하는 이유는 idx-3이 차례대로 햄버거 재료일 경우   
   현재 만든 햄버거의 시작인 '1'로 이미 햄버거가 만들어졌을 것이기 때문
5. 시간초과가 발생하지 않기 위해 idx-2를 통해 다시 재료를 확인하며 최종 햄버거 포장 갯수인 answer 반환


```java
import java.util.*;

class Solution {
    public int solution(int[] ingredient) {
        int answer = 0, idx = 0, cnt = 0;
        int[] check = new int[4];
        ArrayList<Integer> list = new ArrayList<>();
        //햄버거 재료 정보 저장
        check[0] = 1;
        check[1] = 2;
        check[2] = 3;
        check[3] = 1;
        //list 에 재료 넣기
        for(int i=0; i<ingredient.length; i++){
            list.add(ingredient[i]);
        }
        //주어진 배열의 순서가 1 2 3 1 인지 확인
        while(list.size()>=4 && idx < ingredient.length){
            cnt = 0;
            for(int i=0; i<4; i++){
                if(i+idx >= list.size() || check[i] != list.get(i+idx))
                    break;
                cnt++;
            }
            if(cnt == 4){//1 2 3 1 일 경우 삭제
                for(int i=0; i<4; i++)
                    list.remove(idx);
                answer++;
                idx = Math.max(idx-2,0);
            }else{
                idx++;
            }
        }

        return answer;
    }
}
```
