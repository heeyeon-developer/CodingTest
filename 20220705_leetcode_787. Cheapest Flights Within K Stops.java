//예외상황 체크하여 고치기
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int answer = -1;
        int start = 0;
        int price = 0;
        int cnt = 0;
        int[] check = new int[n];
        PriorityQueue<Integer> node = new PriorityQueue<>();
        PriorityQueue<Integer> sum = new PriorityQueue<>();
        PriorityQueue<Integer> nn = new PriorityQueue<>();
        ArrayList<Integer> ans = new ArrayList<>();
        
        node.add(src);
        sum.add(0);
        nn.add(0);
        
        while(node.size() > 0){
            start = node.poll();
            price = sum.poll();
            cnt = nn.poll();
            
            //System.out.println(start);
            for(int i=0; i<flights.length; i++){
                if(flights[i][0] == start && check[flights[i][0]] == 0){
                    node.add(flights[i][1]);
                    sum.add(price + flights[i][2]);
                    nn.add(cnt + 1);
                    if(cnt <= k && flights[i][1] == dst)
                        ans.add(price + flights[i][2]);
                }
            }
            check[start] = 1;
            if(cnt > k)
                break;
        }
        
        if(ans.size() > 0)
            return Collections.min(ans);
        return answer;
    }
}
