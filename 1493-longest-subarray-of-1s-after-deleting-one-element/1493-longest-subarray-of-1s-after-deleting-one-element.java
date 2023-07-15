class Solution {
    
    public int longestSubarray(int[] nums) {
        int lastZeroIndex = -1;
        int result = 0;
        int i = 0, j = 0;
        while(j < nums.length){
            if(nums[j] == 0){
                i = lastZeroIndex+1;
                lastZeroIndex = j;
            }
            
            result = Math.max(result, j-i);
            j++;
        }
        
        return result;
    }
    
    
    // Time complexity - every element is being touched max 2 times
    // O(n+n) ~ O(n)
    public int longestSubarray_slidingWindowBasic(int[] nums) {
        
        int zeroCount = 0, i = 0, result = 0, n = nums.length;
        
        for(int j = 0; j < n; j++){
            int val = nums[j];
            if(val == 0){
                zeroCount++;
            }
            while(zeroCount > 1){
                int valAtI = nums[i];
                if(valAtI == 0){
                    zeroCount--;
                }
                i++;
            }
            
            result = Math.max(result, Math.abs(j-i));
        }
        
        return result;
    }
    // Brute Force
    public int longestSubarray_bruteForce(int[] nums) {
        
        int n = nums.length;
        int zeroCount = 0;
        int result = 0;
        for(int i = 0; i < n; i++){
            for(int j = i; j < n; j++){
                int val = nums[j];
                if(val == 0 ){
                    if(zeroCount == 0){
                        zeroCount++;
                        result = Math.max(result, j-i);
                    }
                    else{
                        zeroCount = 0;
                        break;
                    }
                        
                }
                else if(val == 1){
                    result = Math.max(result, j-i);
                } 
            }
        }
        
        
        return result;
    }
}