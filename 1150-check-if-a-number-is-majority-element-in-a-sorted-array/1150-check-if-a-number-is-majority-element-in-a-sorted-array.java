class Solution {
    public boolean isMajorityElement(int[] nums, int target) {
        
        int count = 0;
        for(int num: nums){
            if(num == target)
                count++;
        }
        
        return count > (nums.length/2);
    }
}