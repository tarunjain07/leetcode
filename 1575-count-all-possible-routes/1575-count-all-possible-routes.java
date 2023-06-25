class Solution {
    
    
    // Memo - start
    public int countRoutes(int[] locations, int start, int finish, int fuel) {
        
        int[][] dp = new int[105][205];
    
        for(int[] d: dp){
            Arrays.fill(d, -1);
        }
        
        return getCount(locations, start, finish, fuel, dp);
    }
    
    int getCount(int[] locations, int start, int finish, int fuel,  int[][] dp){
        int n = locations.length;
        
        int count = 0;
        
        if(start == finish){
            count++;
            
        }
        if(dp[start][fuel] != -1){
                return dp[start][fuel];
        }
        
        for(int i = 0; i < n; i++){
            int rem_fuel = fuel - Math.abs(locations[i]- locations[start]);
            
            if(rem_fuel < 0 || i == start){
                continue;
            }

            
            count += getCount(locations, i, finish, rem_fuel, dp);
            count %=1000000007;
            
        }
        
        dp[start][fuel] = count;
        return count;
        
    }
    //Memo end
    
    
    //recursion - start
    public int countRoutes_recursion(int[] locations, int start, int finish, int fuel) {
        int count = start == finish ? 1 : 0; // if start = end are same then we count is 1
        
        return count + countRoutes_recursion(locations, start, finish, fuel);
    }
    
    int getCount_recursion(int[] locations, int start, int finish, int fuel){
        int n = locations.length;
        
        int count = 0;
        for(int i = 0; i < n && fuel >=0; i++){
            if(i == start){
                continue;
            }
            
            int rem_fuel = fuel - Math.abs(locations[i]- locations[start]);
            if(rem_fuel < 0){
                continue;
            }
            
            if(i == finish){
                count = count+1;
            }
            
            if(rem_fuel > 0){
                count += countRoutes_recursion(locations, i, finish, rem_fuel);
            }
            
        }
        return count;
        
    }
    //recursion end
}