class Solution {
    int[][] t;
    int MOD = (int) 1e9 + 7;
    int arrLen;
    int solve(int curr, int remaining){
        if(remaining == 0){
            if(curr == 0)
                return 1;
            return 0;
        }

        if(t[curr][remaining] != -1){
            return t[curr][remaining];
        }

        int ans = solve(curr, remaining-1);
        if(curr > 0){
            ans = (ans+ solve(curr-1, remaining-1))%MOD;
        }
        if(curr < arrLen-1){
            ans = (ans + solve(curr+1, remaining-1))%MOD;
        }

        t[curr][remaining] = ans;
        return ans;

    }
    public int numWays(int steps, int arrLen) {
        int minSize = Math.min(arrLen, steps);
        this.arrLen = minSize;
        this.t = new int [minSize][steps+1];

        for(int[] x: t){
            Arrays.fill(x, -1);
        }

        return solve(0, steps);
    }
}