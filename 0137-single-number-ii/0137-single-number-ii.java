class Solution {
    public int singleNumber(int[] nums) {

        // Loner
        int result = 0;

        // Iterate over all bits
        for (int shift = 0; shift < 32; shift++) {
            int temp = (1<<shift);
            int countOnes = 0;
            int countZeros = 0;

            // For this bit, iterate over all integers
            for (int num : nums) {

                // Compute the bit of num, and add it to bitSum
                if((num & temp) == 0){
                    countZeros++;
                }else{
                    countOnes++;
                }
            }

            if(countOnes%3 == 1){
                result = (result |temp);
            }
        }
        return result;
    }
}