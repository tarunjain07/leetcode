class Solution {
    
    
    /*
    * This solution was submitted by another user and it has good runtime 
    * yet solution is also simple
    */
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        
	     PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> (a[0] + a[1]) - (b[0] + b[1]));

        for(int i=0; i < nums1.length && i < k; i++)
            minHeap.add(new int[]{nums1[i], nums2[0], 0});
        
        List<List<Integer>> result = new ArrayList<>();
        
        for(int i=0; i < k && !minHeap.isEmpty(); i++){
            int[] curr = minHeap.poll();
            result.add(List.of(curr[0], curr[1]));
            int nums2Idx = curr[2];
            if(nums2Idx < nums2.length - 1)
                minHeap.add(new int[]{curr[0], nums2[nums2Idx + 1], nums2Idx + 1});
        }
        return result;
    }
    
    public List<List<Integer>> kSmallestPairs_my(int[] nums1, int[] nums2, int k) {
    
        List<List<Integer>> result = new ArrayList<>();
        int n1 = nums1.length;
        int n2 = nums2.length;
        
        PriorityQueue<Value> pq = new PriorityQueue<Value>(k+1, new ValueComparator());
        
        for(int i = 0 ; i < n1 ; i++){
            for(int j = 0; j < n2 ; j++){
                int sum = nums1[i]+nums2[j];
                Value valueTemp = new Value(Arrays.asList(nums1[i], nums2[j]), sum);
                if(pq.size() < k){
                    pq.add(valueTemp);
                }else if(pq.peek().sum > sum){
                    pq.poll();
                    pq.add(valueTemp);
                }else{
                    break; //this is the optimization
                }
            }
        }
        
        int count = 0;
        while(count < k && pq.size()>0){
            result.add(pq.poll().val);
            count++;
        }
        
        Collections.reverse(result);
        return result;
    }
}


class ValueComparator implements Comparator<Value>{
    public int compare(Value v1, Value v2){
        return v2.sum - v1.sum;
    }
}

class Value{
    List<Integer> val;
    int sum;
    
    public Value(List<Integer> val, int sum){
        this.val = val;
        this.sum = sum;
    }
}