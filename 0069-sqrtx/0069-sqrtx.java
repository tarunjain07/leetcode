class Solution {
    public int mySqrt(int x) {
        if(x == 0) return 0;
        int lo =1, hi = x;
        while(hi > lo +1){
            int mid = lo + (hi-lo)/2;
            if(ok(x, mid)){
                lo = mid;
            }else{
                hi = mid;
            }
        }
        return lo;
    }
    
    private boolean ok(int x, int mid){
        return mid <= x/mid;
    }
}