# 2018 KAKAO BLIND RECRUITMENT
> 포인트는 주어진 블럭과 동일한 크기의 체크하는 블럭을 만드는 것
1. 주어진 board 의 문장을 이용해 map 을 채우고 0으로 초기화된 check 배열 생성
2. 4개의 블럭이 동일할 경우 check 에 1로 표시
3. map 을 전체다 확인후 check[i][j] == 1 일 경우 map[i][j] = ' ' 으로 세팅
4. check[i][j] == 0 일 경우 아래로 내려와야 하는 블럭이므로 바닥부터 확인하여 que 에 저장
5. que 에 저장된 문자들을 바닥부터 채우고 que 가 비어지면 그만하고 다시 map 확인
6. map 에 더이상 4개의 블럭이 동일한 경우가 없을때 끝내고 map 의 공백의 수 체크하여 return


```java
import java.util.*;

class Solution {
    public int solution(int m, int n, String[] board) {
        int answer = 0, cnt = 1;
        int h = board.length, w = board[0].length();
        char[][] map = new char[h][w];
        int[][] check = new int[h][w];
        
        for(int i=0; i<h; i++){
            for(int j=0; j<w; j++){
                map[i][j] = board[i].charAt(j);
            }
        }
        
        while(cnt != 0){
            cnt = 0;
            for(int i=0; i<h-1; i++){
                for(int j=0; j<w-1; j++){
                    char temp = map[i][j];
                    if(temp == ' ')
                        continue;
                    if(temp == map[i][j+1] && temp == map[i+1][j] && temp == map[i+1][j+1]){//주변이 2*2 가 되는지 확인
                        check[i][j] = 1;
                        check[i][j+1] = 1;
                        check[i+1][j] = 1;
                        check[i+1][j+1] = 1;
                        cnt++;
                    }
                }
            }     
            //사라져야 할 경우 공백으로 변환
            for(int i=0; i<h; i++){
                for(int j=0; j<w; j++){
                    if(check[i][j] == 1)
                        map[i][j] = ' ';
                }
            }
            //빈곳을 위에서부터 내려와 채우기
            for(int i=0; i<w; i++){
                Queue<String> que = new LinkedList<>();
                int th = h-1;
                for(int j=h-1; j>=0; j--){
                    if(check[j][i] == 0){
                        que.add(Character.toString(map[j][i]));
                        map[j][i] = ' ';
                    }                        
                }
                while(!que.isEmpty()){
                    map[th--][i] = que.poll().charAt(0);
                }
            }  
            check = new int[h][w];
            
        }
        
        for(int i=0; i<h; i++){
            for(int j=0; j<w; j++){
                if(map[i][j] == ' ')
                    answer++;
            }
        }
        
        return answer;
    }
}
```
