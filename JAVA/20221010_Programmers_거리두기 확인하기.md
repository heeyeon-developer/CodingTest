# 2021 카카오 채용연계형 인턴십
1. 응시자의 '위,아래,오른쪽,왼쪽' 에 다른 응시자가 앉을 경우 거리두기를 지키지 않아 1로 입력
2. 응지사의 대각선 4가지 방향에 다른 응시자가 않을 경우 대각선 옆으로 파티션이 하나라도 존재하지 않는다면 거리두기를 지키지 않은것이므로 1로 입력  
   대각선 방향 양옆으로 파티션이 존재한다면 거리두기를 지킨것이므로 넘어감
3. 응시자의 '위,아래,오른쪽,왼쪽' 으로 2칸씩 떨어진 곳에 다른 응시자가 앉을 경우 응시자와 다른 응시자 사이에 파이션이 존재할 경우 거리두기를 지킨것이고   
   파이션이 존재하지 않는다면 거리두기를 지키지 않은 것으로 1로 입력
4. 5개의 대기실을 모두 확인한 결과인 answer 을 반환


```java
class Solution {
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        int[][] disf = {{-1,0},{0,-1},{1,0},{0,1}};
        int[][] disx = {{-1,-1},{1,-1},{1,1},{-1,1}};
        int[][] dis = {{-2,0},{0,-2},{2,0},{0,2}};
        boolean check = true;
        
        for(int i=0; i<5; i++){
            check = true;
            char[][] temp = new char[5][5];
            for(int j=0; j<5; j++){
                for(int k=0; k<5;k++){
                    temp[j][k] = places[i][j].charAt(k);
                }
            }
            for(int j=0; j<5; j++){
                for(int k=0; k<5;k++){
                    if(temp[j][k] == 'P'){
                        //바로
                        for(int d=0; d<4; d++){
                            if(0 <= j+disf[d][0] && j+disf[d][0] < 5
                               && 0<= k+disf[d][1] && k+disf[d][1] <5
                               && temp[j+disf[d][0]][k+disf[d][1]] == 'P'){
                                check = false;
                                break;
                            }
                        }
                        if(!check)
                            break;
                        //대각선
                        for(int d=0; d<4; d++){
                            if(0<= j+disx[d][0] && j+disx[d][0] <5
                               && 0<= k+disx[d][1] && k+disx[d][1] <5
                               && temp[j+disx[d][0]][k+disx[d][1]] == 'P'){
                                if(temp[j+disx[d][0]][k] != 'X' || temp[j][k+disx[d][1]] != 'X'){
                                    check = false;
                                    break;
                                }
                            }
                        }
                        if(!check)
                            break;
                        //2칸
                        for(int d=0; d<4; d++){
                            if(0<= j+dis[d][0] && j+dis[d][0] <5
                               && 0<= k+dis[d][1] && k+dis[d][1] <5
                               && temp[j+dis[d][0]][k+dis[d][1]] == 'P'){
                                if(temp[(j+j+dis[d][0])/2][(k+k+dis[d][1])/2] != 'X'){
                                    check = false;
                                    break;
                                }
                            }
                        }
                        if(!check){
                            break;
                        }
                    }
                    if(!check){
                        break;
                    }
                }
            }
            answer[i] = check == false ? 0 : 1;
        }
        return answer;
    }
}
```
