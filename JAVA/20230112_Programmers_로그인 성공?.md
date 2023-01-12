# Level 0
1. 주어진 db[] 배열에서 id_pw[]배열의 값과 id,pw 동일 여부를 판단
2. 모두 동일할 경우 "login", 아이디만 동일할 경우 "wrong pw", 모두 일치하지 않을 경우 "fail" 반환


```java
class Solution {
    public String solution(String[] id_pw, String[][] db) {
        for(int i=0; i<db.length; i++){
            if(id_pw[0].equals(db[i][0])) {
                if(id_pw[1].equals(db[i][1])){
                    return "login";
                }
                return "wrong pw";
            }
        }
        return "fail";
    }
}
```
