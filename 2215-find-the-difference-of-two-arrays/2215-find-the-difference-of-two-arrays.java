class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<List<Integer>> result = new ArrayList<>();
        
        
        Set<Integer> setOfNum1 = new HashSet<>();
        for(int num1 : nums1){
           setOfNum1.add(num1);
        }
        
        Set<Integer> setOfNum2 = new HashSet<>();

        for(int num2 : nums2){
            setOfNum2.add(num2);
        }
        
        List<Integer> nums1NotInNums2 = new ArrayList<>();
        for(int num1: nums1){
            if(!setOfNum2.contains(num1) && !nums1NotInNums2.contains(num1)){
                nums1NotInNums2.add(num1);
            }
        }
        result.add(nums1NotInNums2);
        
        List<Integer> nums2NotInNums1 = new ArrayList<>();

        for(int num2: nums2){
            if(!setOfNum1.contains(num2) && !nums2NotInNums1.contains(num2)){
                nums2NotInNums1.add(num2);
            }
        }
        result.add(nums2NotInNums1);
        
        return result;
    }
}