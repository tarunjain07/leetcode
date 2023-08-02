class Solution {
    
    public boolean canPartition(int[] nums) {
        int totalSum = Arrays.stream(nums).sum();
        
        if(totalSum%2 != 0)
            return false;
        
        int n = nums.length;
        int sum = totalSum/2;
        
        boolean[][] dp = new boolean[n+1][sum+1];
    
        for(int row = 0; row <= n; row++){
            dp[row][0] = true;
        }
       

        
        
        for(int row = 1; row <= n; row++){  // elements from array
            for(int col = 1; col <= sum; col++){ // sum value
                int val = nums[row-1];
                if(val > col){
                    dp[row][col] = dp[row-1][col];
                }else{
                    dp[row][col] = dp[row-1][col] || dp[row-1][col-val];
                }
            }
            
        }
        
        return dp[n][sum];
    
    }
            
    public boolean canPartition_memo(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        
        if(sum%2 != 0)
            return false;
        
        int n = nums.length;

        Boolean[][] t = new Boolean[n+1][sum+1];

        boolean result = helper(n, nums, sum/2, t);
        
        return result;
    }
    
    private boolean helper(int n, int[] nums, int sum, Boolean[][] t){
        if(sum ==  0)
            return true;
        if(n == 0)
            return false;
        
        if(t[n][sum] != null){
            return t[n][sum];
        }
        
        if(nums[n-1] <= sum){
            return t[n][sum] =  helper(n-1, nums, sum-nums[n-1], t) || helper(n-1, nums, sum, t);
            
        }else{
            return t[n][sum] = helper(n-1, nums, sum, t);
        }
    }
}