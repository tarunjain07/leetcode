class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
    
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