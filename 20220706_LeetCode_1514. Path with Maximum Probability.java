//속도개선 필요
class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        Queue<Integer> node = new LinkedList<>();
        Map<Integer, Double> list = new HashMap<>();
        int s = 0;
        int nn = 0;
        double temp = 0;
        
        //처음에 확률 계산하기 위해 넣어주기
        for(int i=0; i<edges.length; i++)
            if(edges[i][0] == start){
                list.put(edges[i][1], succProb[i]);
                node.add(edges[i][1]);
            }else if(edges[i][1] == start){
                list.put(edges[i][0], succProb[i]);
                node.add(edges[i][0]);
            }
        
        while(node.size() > 0){
            s = node.poll();
            if(s == end)
                break;
            
            for(int i=0; i<edges.length; i++){
                if(edges[i][0] == s || edges[i][0] == s){
                    if(edges[i][0] == s)
                        nn = edges[i][1];
                    else
                        nn = edges[i][0];
                    
                    if(!list.containsKey(s))
                        continue;
                    temp = list.get(s) * succProb[i];
                    
                    if(list.containsKey(nn)){
                        if(temp > list.get(nn))
                            list.put(nn, temp);
                        else continue;
                    }
                    else
                        list.put(nn, temp);
                    }
                    node.add(nn);
                }
            }
        
        if(list.size() > 0 && list.containsKey(end))
            return list.get(end);
        else
            return 0;
    }
}
