class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        
        int lo = 0, hi = people.length-1;
        int count = 0;
        while(lo<=hi){
            if(lo == hi){
                count+=1;
                lo++;
                hi--;
            }
            else if(people[hi]==limit || people[hi]+people[lo] > limit){
                count+=1;
                hi--;
            }
            else if( people[hi]+people[lo] <= limit){
                count+=1;
                hi--;
                lo++;
            }
        }
        
        return count;
    }
}