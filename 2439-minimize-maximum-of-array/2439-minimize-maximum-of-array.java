class Solution {
    public int minimizeArrayValue(int[] nums) {
        int lo = 0;
        int hi = 0;
        for(int num: nums){
            hi = Math.max(num, hi);
        }
        
        //System.out.println("hi "+ hi);
        int result = 0;
        while(lo <= hi){
            int mid = lo + (hi-lo)/2;
            if(ok(nums, mid)){
                result = mid;
                hi = mid-1;
            }else{
                lo = mid+1;
            }
        }
        
        return result;
        
    }
    
    private boolean ok(int[] nums, int mid){
        //long[] nums_copy = Arrays.copyOf(nums, nums.length);
        long[] nums_copy = Arrays.stream(nums).mapToLong(i -> i).toArray();

        int n = nums_copy.length;
        for(int i = 0; i < n-1; i++){
            if(nums_copy[i] > mid){
                return false;
            }
            
            long buffer = mid - nums_copy[i];
            nums_copy[i+1] -= buffer;
        }
        
        return nums_copy[n-1] <= mid;
    }
}