class Solution {
    public int change(int amount, int[] coins) {
        
        int n = coins.length;
        //return changeHelper_recursion(amount, coins, n);
        return changeHelper(amount, coins, n);
    }
    
    private int changeHelper(int totalAmount, int[] coins, int n){
        int[][] dp = new int[n+1][totalAmount+1];
        
        dp[0][0] = 1;
        
        for(int row = 1; row < n+1; row++){
            for(int amount = 0; amount < totalAmount+1; amount++){
                int currentCoin = coins[row-1];
                
                if(currentCoin > amount){
                    dp[row][amount] = dp[row-1][amount];
                }else{
                    dp[row][amount] = dp[row-1][amount] + dp[row][amount-currentCoin];
                }
            }
        }
        
        return dp[n][totalAmount];
    }
    
    private int changeHelper_recursion(int amount, int[] coins, int n){        
        if(amount == 0){
            return 1;
        }
        
        if(n == 0){
            return 0;
        }
        
        if(coins[n-1] > amount){
            return changeHelper_recursion(amount, coins, n-1);
        }else{
            return changeHelper_recursion(amount, coins, n-1)  + changeHelper_recursion(amount-coins[n-1], coins, n);
            
        }
    
    }
}