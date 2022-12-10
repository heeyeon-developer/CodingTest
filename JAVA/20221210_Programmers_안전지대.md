# 입문
1. 지뢰 주변지역을 체크하기 위해 xy 리스트 만들기
2. 지뢰인 주변지역을 xy 리스트로 체크하고 만약 지뢰일 경우 주변지역이라고 체크하지 않기 위해 조건에 'board[ty][tx] != 1' 추가
3. 지뢰의 주변지역 체크 후 안전지역 카운팅 하여 answer 반환


```java
class Solution {
    public int solution(int[][] board) {
        int answer = 0;
        int[][] xy = {{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};
        
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board.length; j++){
                if(board[i][j] == 1){
                    for(int k=0; k<8; k++){
                        int ty = i+xy[k][0], tx = j+xy[k][1];
                            if(ty >= 0 && ty < board.length && tx >=0 && tx < board.length
                               && board[ty][tx] != 1 && board[ty][tx] != -1){
                                board[ty][tx] = -1;
                            }
                    }
                }
            }
        }
        
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board.length; j++){
                if(board[i][j] == 0){
                    answer++;
                }
            }
        }
        
        return answer;
    }
}
```
