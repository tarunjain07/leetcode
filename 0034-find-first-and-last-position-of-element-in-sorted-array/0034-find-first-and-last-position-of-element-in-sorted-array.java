class Solution {
    public int[] searchRange(int[] nums, int target) {
        
        //3rd Template
        //int left = searchLeft(nums, target);
        //int right = searchRight(nums, target);
        //return new int[]{left, right};

        //4th Template
        int left = searchLeftLoop(nums, target);
        int right = searchRightLoop(nums, target);
        return new int[] {left, right};

    }
    
    //4th template Start
    private int searchLeftLoop (int[] nums, int target){
        //Starting lo at -1 helps with edge case when we couldn't make a single jump
        //if we start with 0 then still we can do it, but then we will have to add one extra
        // check before returning
        int lo = -1, n = nums.length;
        for(int jump = n/2; jump >= 1; jump/=2){
            while((lo + jump < n) && isNumberSmallerThanTarget(nums, lo+jump, target)){
                lo += jump;
            }
        }
        if(lo +1 >= n)
            return -1;
        return nums[lo+1] == target ? lo+1 : -1;
    }

    //TTTTTT'F'FFFF
    private boolean isNumberSmallerThanTarget(int[] nums, int x, int target){
        return nums[x] < target;
    }


    private int searchRightLoop(int[] nums, int target){
        int lo = 0, n = nums.length;
        for(int jump = n/2; jump >= 1; jump/=2){
            while((lo + jump < n) && isNumberSmallerEqualThanTarget(nums, lo+jump, target)){
                lo += jump;
            }
        }
        if(lo >= n)
            return -1;
        return nums[lo] == target ? lo : -1;
    }

    //TTTTT'T'FFFFF
    private boolean isNumberSmallerEqualThanTarget(int[] nums, int x, int target){
        return nums[x] <= target;
    }
    //4th template End
    
    //3rd Template Start
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
    //3rd Template End
}