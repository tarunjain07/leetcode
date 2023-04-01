class Solution {
    
    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);

        int n = satisfaction.length;
        
        int[][] dp = new int[501][501];
        for(int[] d : dp){
            Arrays.fill(d, -10000000);
        }
        
        
        //dp[i][j] = max value till 0...i food and time is j currently
        
        //at time 0, we have no value i.e, 0 - COOKING HAS NOT YET STARTED
        for(int i = 0; i < 501; i++){
            dp[i][0] = 0;
        }
        
        //COOKING STARTED at TIME = 1 and let's start with 0th food: t[0][1]
        dp[0][1] = satisfaction[0]*1; //first value can be at 1st index
        
        for(int index = 1; index < n; index++){
             for(int time = 1; time <= n; time++){
                 int include  = satisfaction[index]*time + dp[index-1][time-1];
                 int exclude = dp[index-1][time];
                 dp[index][time] = Math.max(include, exclude);
                 
             }
        }
        
        int ans = 0;
        for(int i = 0; i <=n; i++){
            ans = Math.max(ans, dp[n-1][i]);
        }
        
        return ans;
    }
    
    
    //Recursion + Memoization - Top Down
    public int maxSatisfaction_TopDown(int[] satisfaction) {
        int[][] memo = new int[501][501]; //501 is max value from constraint 
        
        for(int[] subMemo : memo)
            Arrays.fill(subMemo, -1);
        
        Arrays.sort(satisfaction);
        return solveStartToEnd(satisfaction, memo, 0, 1);
    }
    
    private int solveStartToEnd(int[] satisfaction, int[][] memo, int index, int time){
        if(index >= satisfaction.length){
            return 0;
        }
        
        if(memo[index][time] != -1){
            return memo[index][time];
        }
        int withCurrentIndex = (satisfaction[index]*time) + solveStartToEnd(satisfaction, memo, index+1, time+1);
        int withoutCurrentIndex =  solveStartToEnd(satisfaction, memo, index+1, time);
        
        int max = Math.max(withCurrentIndex, withoutCurrentIndex);
        
        memo[index][time] = max;
        return max;
        
    }

    
}