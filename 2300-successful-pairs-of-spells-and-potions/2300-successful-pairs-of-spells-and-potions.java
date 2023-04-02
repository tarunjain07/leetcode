class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int[] result = new int[spells.length];
        
        Arrays.sort(potions);
        
        for(int i = 0; i < spells.length; i++){
            int spell = spells[i];
            int count = 0;
            int foundIndex = findIndex(spell, potions, success);
            count = potions.length-foundIndex;
            
            result[i] = count;
        }
        
        return result;
    }
    
    public int findIndex(int spell, int[] potions, long success){
        int lo = -1, hi = potions.length;
        while(lo + 1 < hi){
            int mid = lo + (hi-lo)/2;
            if((long)potions[mid]*spell >= success){
                hi = mid;
            }else{
                lo = mid;
            }
        }
        
        //System.out.println("hi "+ hi+" lo "+lo);
        //return (long)potions[lo]*spell>= success ? lo : hi;
        return  hi;
    }
}