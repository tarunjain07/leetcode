class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        int n = costs.length;
        PriorityQueue<Integer> pq1 = new PriorityQueue<Integer>(n);             
        PriorityQueue<Integer> pq2 = new PriorityQueue<Integer>(n);
        
        int left = 0;
        int right = n-1;
        int hired = 0;
        long totalCost = 0;
        while(hired<k){
            
             while(pq1.size() < candidates && left <= right){
                pq1.add(costs[left++]);
            }

            while(pq2.size() < candidates && right >= left){
                pq2.add(costs[right--]);
            }

            
            int min_p1 = pq1.size() == 0 ? Integer.MAX_VALUE: pq1.peek();
            int min_p2 = pq2.size() == 0 ? Integer.MAX_VALUE: pq2.peek();

            
            if(min_p1 <= min_p2){
                totalCost += min_p1;
                pq1.poll();
            }else{
                totalCost += min_p2;
                pq2.poll();
            }
            hired++;
        }

        return totalCost;
    }
}

class KeyComparator implements Comparator<Key>{
    public int compare(Key k1, Key k2){
        if(k1.value != k2.value){
            return k1.value - k2.value;
        }else {
            return k1.index - k2.index;
        }
    }
}
class Key{
    int value;
    int index;

    public Key(int value, int index){
        this.value = value;
        this.index = index;
    }
}