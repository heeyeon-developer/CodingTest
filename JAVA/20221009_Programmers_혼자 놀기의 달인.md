# 연습문제
1. 주어진 cards 의 배열을 i번째, i+1번째 위치 에서 시작할때 오픈하는 상자의 수를 one 변수에 저장
2. one 을 구한뒤 두번째 순서에서 one 에서 선택한 숫자를 제외하고(visited 이용)    
   one 에서 선택하지 않은 j번째, j+1번째 위치에서 시작할때 오픈하는 상자의 수를 two 변수에 저장
3. two의 값은 가장 큰값으로 구하여 one*two 가 answer 보다 클 경우 갱신
4. 가장 큰 answer 값을 반환


```java
class Solution {
    public int solution(int[] cards) {
        int answer = 0;
        for(int i=0; i<cards.length; i++){
            int[] visited = new int[cards.length];
            int one = check(cards[i]-1,visited,cards);
            int two = 0;
            for(int j=0; j<cards.length; j++){
                two = Math.max(two,check(j,visited,cards));
            }
            answer = Math.max(answer,one*two);
        }
        return answer;
    }
    public int check(int idx, int[] visited, int[] cards){
        int num = 0;
        while(visited[idx] == 0){
            visited[idx] = 1;
            num++;
            idx = cards[idx]-1;
        }
        return num;
    }
}
```
