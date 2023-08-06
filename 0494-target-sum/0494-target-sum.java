class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int sum = Arrays.stream(nums).sum();
        
        int sumPlusTarget = sum+target;
        
        if(sumPlusTarget%2 != 0 || sumPlusTarget < 0){
            return 0;
        }
        
        int targetVal = sumPlusTarget/2;
        
        int[][] dp = new int[n+1][targetVal+1];
        dp[0][0] = 1;
        
        for(int row = 1; row <n+1; row++){
            for(int col = 0; col < targetVal+1; col++){
                int val = nums[row-1];
                if(val > col){
                    dp[row][col] = dp[row-1][col];
                }else{
                    dp[row][col] = dp[row-1][col] + dp[row-1][col-val];
                }
            }
        }
        
        return dp[n][targetVal];
        
    }
}