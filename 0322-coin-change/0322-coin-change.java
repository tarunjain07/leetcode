class Solution {
    
    //bottom up / tabulation - 2d array
    //TODO - is it possible with 1d array?
    public int coinChange(int[] coins, int amount) {
        int[][] dp = new int[coins.length+1][amount+1];
        for(int i = 0; i < amount+1; i++){
            dp[0][i] = Integer.MAX_VALUE;  
        } 
        
        for(int i = 0; i < coins.length+1; i++){
            dp[i][0] = 0;  
        }
        
        
        
        
        for(int j = 1; j < coins.length+1; j++){
            for(int i = 1; i < amount+1; i++){
                int val = coins[j-1];
                if(val > i){
                    dp[j][i] = dp[j-1][i];
                }else{
                    dp[j][i] = Math.min(dp[j-1][i], 
                                        (dp[j][i-val]==Integer.MAX_VALUE?Integer.MAX_VALUE:dp[j][i-val]+1));
                }
            }
        }
        
        return dp[coins.length][amount] == Integer.MAX_VALUE ? -1: dp[coins.length][amount] ;
    }
    
    //recursion
    public int coinChange_recursion(int[] coins, int amount) {
        if (amount < 1) return 0;
        return coinChange_recursion(coins, amount, new int[amount]);
    }
    
    private int coinChange_recursion(int[] coins, int rem, int[] count) {
        if (rem < 0) return -1;
        if (rem == 0) return 0;

        int min = Integer.MAX_VALUE;

          for (int coin : coins) {
          int res = coinChange_recursion(coins, rem - coin, count);
          if (res >= 0 && res < min)
            min = 1 + res;
        }
        return (min == Integer.MAX_VALUE) ? -1 : min;
    }
}

