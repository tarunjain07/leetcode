class Solution {
    int n;
    int result = Integer.MAX_VALUE;
    
    public int distributeCookies(int[] cookies, int k) {
        
        n = cookies.length;
        int[] children = new int[k];
        
        solve(0, cookies, children, k);
        return result;
    }
    
    void solve(int idx, int[] cookies, int[] children, int k){
        
        if(idx>= n){
            int unfairness = Arrays.stream(children).max().getAsInt();
            result = Math.min(result, unfairness);
            return;
        }
        int cookie = cookies[idx];
        for(int c = 0; c < k; c++){
            children[c] += cookie;
            if(children[0] == 0){
                break;
            }
            solve(idx+1, cookies, children, k);
            children[c] -= cookie;
        }
    }
}