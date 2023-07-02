class Solution {
    int n;
    
    public int distributeCookies(int[] cookies, int k) {
        
        n = cookies.length;
        int[] children = new int[k];
        
        return solve(0, cookies, children, k, k);
    }
    
    int solve(int idx, int[] cookies, int[] children, int k, int childrenLeft) {

        // if cookies left < children left then unfair distribution
        // so break
        var cookiesLeft = cookies.length - idx;
        if (cookiesLeft < childrenLeft) {
            return Integer.MAX_VALUE;
        }

        if (idx == cookies.length) {
            int unfairness = Math.max(Integer.MIN_VALUE, Arrays.stream(children).max().getAsInt());
            return unfairness;
        }

        int cookie = cookies[idx];
        int result = Integer.MAX_VALUE;
        for (int c = 0; c < k; c++) {
            childrenLeft -= children[c] == 0 ? 1 : 0;
            children[c] += cookie;
            if(children[c] == 0){
                break;
            }
            result = Math.min(result, solve(idx + 1, cookies, children, k, childrenLeft));
            children[c] -= cookie;
            childrenLeft += children[c] == 0 ? 1 : 0;
        }

        return result;
    }
}