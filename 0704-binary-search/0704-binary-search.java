class Solution {
    public int search(int[] nums, int target) {
        int lo = -1, hi = nums.length -1;
        while(lo + 1 < hi){
            int mid = lo + (hi - lo)/2;

            if(ok(nums, mid, target)){
                hi = mid;
            } else{
                lo = mid;
            }
        }
        return nums[hi] == target ? hi: -1;
    }
    
    private boolean ok(int[] nums, int idx, int target){
        return nums[idx] >= target;
    }
}