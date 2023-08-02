class Solution {
    Boolean[][] t;
    
    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        
        if(sum%2 != 0)
            return false;
        
        int n = nums.length;

        this.t = new Boolean[n+1][sum+1];

        boolean result = helper(n, nums, sum/2);
        
        return result;
    }
    
    private boolean helper(int n, int[] nums, int sum){
        if(sum ==  0)
            return true;
        if(n == 0)
            return false;
        
        if(t[n][sum] != null){
            return t[n][sum];
        }
        
        if(nums[n-1] <= sum){
            return t[n][sum] =  helper(n-1, nums, sum-nums[n-1]) || helper(n-1, nums, sum);
            
        }else{
            return t[n][sum] = helper(n-1, nums, sum);
        }
    }
}