class Solution {


    /// DP - Bottom Up - Start
    public int longestArithSeqLength(int[] nums) {
       int n = nums.length;

       if(n <=2)
        return n;

        int ans = 0;
        //Map<Integer, Integer>[] dp = new HashMap[n+1];
        int[][] dp = new int[1001][1003];

        for(int[] temp: dp){
            Arrays.fill(temp, -1);
        }
        
        int maxValue = 0;
        for(int i = 1; i < n; i++){
            for(int j = 0; j <i; j++){
                int cnt = 1;
                int diff = nums[i]-nums[j] + 500;

                dp[i][diff] = dp[j][diff]>0 ? dp[j][diff]+1 : 2;
                //if(dp[j] != null && dp[j].get(diff) != null){
                //    cnt = dp[j].get(diff);
                //}
                //if(dp[j][diff+501] != -1){
                //    cnt = dp[j][diff+501];
                //}

                //if(dp[i] == null){
                //    dp[i] =  new HashMap<Integer, Integer>();
                //}

                //int newCount = cnt+1;
                maxValue = Math.max(maxValue, dp[i][diff]);
                //dp[i].put(diff, newCount);
                //dp[i][diff+501] = newCount;
            }
        }
        return maxValue;
    }

    /// DP - Bottom Up - End
    
    //----------------------------------------------

    //DP Memoization Start -  Array
    private int getNumberOfSubsequence_memo2(int[] nums, int index, int diff, int[][] dp){

        int ans = 0;

        if(index >= nums.length)
            return ans;
        
        if(dp[index][diff+501] != -1){
            return dp[index][diff+501];
        }


        for(int j = index+1; j < nums.length; j++){
            if(nums[j] - nums[index] == diff){
                ans =  Math.max(ans, 1 + getNumberOfSubsequence_memo2(nums, j, diff, dp));
            }
        }


        dp[index][diff+501] =  ans;
        return ans;
    }
    
    public int longestArithSeqLength_memo2(int[] nums) {
        
        if(nums.length <=2){
            return nums.length;
        }

        int[][] dp = new int[1001][1003];
        for(int[] temp: dp){
            Arrays.fill(temp, -1);
        }
        
        int pairs = 0;
        for(int i = 0; i < nums.length; i++){
            for(int j = i+1; j < nums.length; j++){
                int diff = nums[j]-nums[i];
                int length = 2 + getNumberOfSubsequence_memo2(nums, j, diff, dp);
                pairs = Math.max(length, pairs);
            }
        }

        return pairs;
    }
    
    //DP Memoization End -  HashMap 
    

    //----------------------------------------------

    //DP Memoization Start -  HashMap
    private int getNumberOfSubsequence_memo(int[] nums, int index, int diff, Map<Integer, Integer>[] dp){

        int ans = 0;

        if(index >= nums.length)
            return ans;
        
        if(dp[index] != null && dp[index].get(diff) != null){
            return  dp[index].get(diff);
        }


        for(int j = index+1; j < nums.length; j++){
            if(nums[j] - nums[index] == diff){
                ans =  Math.max(ans, 1 + getNumberOfSubsequence_memo(nums, j, diff, dp));
            }
        }


        if(dp[index] ==null){
            dp[index] = new HashMap<Integer, Integer>();
        }
        dp[index].put(diff, ans);
        return ans;
    }
    
    public int longestArithSeqLength_memo(int[] nums) {
        
        if(nums.length <=2){
            return nums.length;
        }

        Map<Integer, Integer>[] dp = new HashMap[nums.length+1];

        int pairs = 0;
        for(int i = 0; i < nums.length; i++){
            for(int j = i+1; j < nums.length; j++){
                int diff = nums[j]-nums[i];
                int length = 2 + getNumberOfSubsequence_memo(nums, j, diff, dp);
                pairs = Math.max(length, pairs);
            }
        }

        return pairs;
    }
    
    //DP Memoization End -  HashMap 
    
    ///------------------------------------------------------

    /// RECURSION - START
    private int getNumberOfSubsequence_recursion(int[] nums, int index, int diff){

        int ans = 0;
        for(int j = index+1; j < nums.length; j++){
            if(nums[j] - nums[index] == diff){
                ans =  1 + getNumberOfSubsequence_recursion(nums, j, diff);
            }
        }
        return ans;
    }
    public int longestArithSeqLength_recursion(int[] nums) {
        
        if(nums.length <=2){
            return nums.length;
        }

        int pairs = 0;
        for(int i = 0; i < nums.length; i++){
            for(int j = i+1; j < nums.length; j++){
                int diff = nums[j]-nums[i];
                int length = 2 + getNumberOfSubsequence_recursion(nums, j, diff);
                pairs = Math.max(length, pairs);
            }
        }

        return pairs;
    }
    /// RECURSION - END

}