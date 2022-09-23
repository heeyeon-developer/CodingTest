# 2022 KAKAO BLIND RECRUITMENT
1. records 의 문장의 마지막 단어가 IN 일 경우 hashmap 에 '차량 번호, 시각' 넣기
2. records 의 문장의 마지막 단어가 OUT 일 경우 hashmap 에 담긴 입차시간 시, 분을 inh, inm 으로 받기
3. 현재 순서의 차량의 출차시간 outh, outm 으로 받아서 outm 이 inm 보다 작을경우 outh-1, outm+60 을 하여 주차한 시간 계산
4. records 를 모두 확인한 뒤에 아직 hashmap 에 차랑이 존재한다면 23 시 59 분을 기준으로 주차한 시간 계산
5. 차량을 오름차순으로 정렬하여 각 차량의 주차요금을 주어진 fees 기준에 따라 계산하여 반환


```java
import java.util.*;

class Solution {
    public List<Integer> solution(int[] fees, String[] records) {
        List<Integer> answer = new ArrayList<>();
        HashMap<String, String> map = new HashMap<>();
        HashMap<String, Integer> result = new HashMap<>();
        //in이면 hash map에 넣기
        for(String str : records){
            String[] temp = str.split(" ");
            if(temp[2].equals("IN")){
                map.put(temp[1],temp[0]);
            }else if(temp[2].equals("OUT")){//out이면 hash map 에서 빼고 시간 계산해서 
                String[] in = map.get(temp[1]).split(":");
                String[] out = temp[0].split(":");
                Integer inh = Integer.parseInt(in[0]), inm = Integer.parseInt(in[1]);
                Integer outh = Integer.parseInt(out[0]), outm = Integer.parseInt(out[1]);
                map.remove(temp[1]);
                if(inm > outm){
                    result.put(temp[1], result.getOrDefault(temp[1],0) + (outh-inh-1)*60 + (outm+60-inm));
                }else{
                    result.put(temp[1], result.getOrDefault(temp[1],0) + (outh-inh)*60 + (outm-inm));
                }
            }
        }
        //hashamp이 비어있지 않다면23:59 시간에서 빼기
        if(!map.isEmpty()){
            for(String key : map.keySet()){
                String[] in = map.get(key).split(":");
                Integer inh = Integer.parseInt(in[0]), inm = Integer.parseInt(in[1]);
                result.put(key, result.getOrDefault(key,0) + (23-inh)*60 + (59-inm));
            }
        }
        List<String> list = new ArrayList<>(result.keySet());
        Collections.sort(list);
        //차량번호가 작은 수부터 넣기
        for(String key : list){
            int t = result.get(key);
            answer.add(t >= fees[0] ? fees[1] + (int)(Math.ceil((t-fees[0])/(fees[2]*1.0))*fees[3]) : fees[1]);
        }
        
        return answer;
    }
}
```
