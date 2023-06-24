class Solution {
    
    
    //memoization - start
    int solve(int[] rods, int idx, int diff, int[][] t){
        int n = rods.length;
        
        if(idx >= n){
            if(diff == 0){
                return 0;
            }
            return Integer.MIN_VALUE;
        }
        
        if(t[idx][diff+5000] != -1){
            return t[idx][diff+5000];
        }
        
        int nothing = solve(rods, idx+1, diff, t);
        int add_l1  = rods[idx] + solve(rods, idx+1, diff+rods[idx], t);
        int add_l2  = rods[idx] + solve(rods, idx+1, diff-rods[idx], t);
        
        t[idx][diff+5000] = Math.max(Math.max(nothing, add_l1), add_l2);
        return t[idx][diff+5000];
    }
    public int tallestBillboard(int[] rods) {
        
        int[][] t = new int[21][10003];
        for(int[] t_temp: t){
            Arrays.fill(t_temp, -1);
        }
        
        return solve(rods, 0, 0, t)/2;
    }
    
    //memoization - end
    
    //Recursion - start
    int solve_recursion(int[] rods, int idx, int l1, int l2){
        int n = rods.length;
        
        if(idx >= n){
            if(l1 == l2){
                return l1;
            }
            return 0;
        }
        
        int nothing = solve_recursion(rods, idx+1, l1, l2);
        int add_l1  = solve_recursion(rods, idx+1, l1+rods[idx], l2);
        int add_l2  = solve_recursion(rods, idx+1, l1, l2+rods[idx]);
        
        return Math.max(Math.max(nothing, add_l1), add_l2);

    }
    public int tallestBillboard_recursion(int[] rods) {
        
        return solve_recursion(rods, 0, 0, 0);
    }
    
    //Recursion - end

}