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

    // Is mid ^ 2 <= x
    //TT'T'FFFFFF
    private boolean ok(int x, int mid){
        return mid <= x/mid;
    }
    
    
    // Sqrt with float result - start
    public double mySqrt_6Decimal(int x){
        if(x == 0) return 0;
        double lo = 1, hi = x, epsilon = 1e-6;
        while(lo + epsilon < hi){
            double mid = lo + (hi-lo)/2;
            if(ok2(x, mid)){
                lo = mid;
            }else{
                hi = mid;
            }
        }
        
        return lo;
    }
    
    private boolean ok2(int x, double mid){
        return mid <= x/mid;
    }
    // Sqrt with float result - end
    
    
    // Sqrt with float result using for loop- start
    public double sqrt2(int x){
        if(x==0) return 0;
        double lo = 1, hi = x;
        for(int i = 0; i < 80; i++){  
            //why 80? ->  to guess 10 we need 7 guess => 2^7 = 128,
            //double is 8bytes i.e 64 bit so 80 just a conservative number
            double mid = lo + (hi - lo)/2;
            if(ok2(x, mid)){
                lo = mid;
            }else{
                hi = mid;
            }
        }
        return lo;
        
    }
    // Sqrt with float result using for loop- end

    
}