class Solution {
    int ans = 0;
    int[][] requests;
    public int maximumRequests(int n, int[][] requests) {
        this.requests = requests;
        int[] transfers = new int[n];
        solve(0, transfers, 0);
        return ans;
    }
    
    private void solve(int idx, int[] transfers, int req_num){
        if(idx == requests.length){
            for(int state: transfers){
                if(state != 0){
                    return;
                }   
            }
            ans =  Math.max(ans, req_num);
            return;

        }
        
        transfers[requests[idx][0]]--;
        transfers[requests[idx][1]]++;
        solve(idx+1, transfers, req_num+1);
        
        transfers[requests[idx][0]]++;
        transfers[requests[idx][1]]--;
        solve(idx+1, transfers, req_num);
    }
}