class Solution {
    public int[] searchRange(int[] nums, int target) {
        
        int left = searchLeft(nums, target);
        int right = searchRight(nums, target);
        
        return new int[]{left, right};
    }
    
    private int searchLeft(int[] nums, int target){
        if(nums == null || nums.length == 0){
            return -1;
        }
        int lo = -1, hi = nums.length-1;
        while(lo + 1 < hi){
            int mid = lo + (hi-lo)/2;
            if(nums[mid] >= target){
                hi = mid;
            }else{
                lo = mid;
            }
        }
        
        //System.out.println("hi "+hi+" lo "+lo);
        return nums[hi]==target? hi : -1;
    }
    
    
    private int searchRight(int[] nums, int target){
         if(nums == null || nums.length == 0){
            return -1;
        }
        
        int lo = 0, hi = nums.length;
        while(lo + 1 < hi){
            int mid = lo + (hi-lo)/2;
            if(nums[mid] <= target){
                lo = mid;
            }else{
                hi = mid;
            }
        }
        
        return nums[lo]==target? lo : -1;
    }
    
}