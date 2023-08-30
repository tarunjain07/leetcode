class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int N = nums.length;

        return nextGreaterElements_brute_force(nums, N);
    }
    
    //O(n^2) --> brute force
    public int[] nextGreaterElements_brute_force(int[] nums, int N) {
        int[] result = new int[N];
        Arrays.fill(result, -1);
        
        for(int i = 0; i < N; i++ ){

            int j = (i+1)%N;
            while(j != i) { // circular loop
                if(nums[j] > nums[i]){
                    result[i] = nums[j];
                    break;
                }
                j = (j+1)%N;
            }
            
        }
        
        return result;
    }
}