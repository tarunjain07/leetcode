class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        if(str1.equals(str2)){
            return str1;
        }
        
        int l = str1.length();
        int m = str2.length();
        
        int[][] dp = new int[l+1][m+1];
        
        for(int row =1; row < l+1; row++){
            for(int col = 1; col < m+1; col++){
                if(str1.charAt(row-1) == str2.charAt(col-1)){
                    dp[row][col] = dp[row-1][col-1]+1;
                }else{
                    dp[row][col] = Math.max( dp[row][col-1],  dp[row-1][col]);
                }
            }
        }
        
        int row = l;
        int col = m;
        
        StringBuilder scs = new StringBuilder();
        while(row > 0 && col > 0){
            if(str1.charAt(row-1) == str2.charAt(col-1)){
                scs.append(str1.charAt(row-1));
                row--;
                col--;
            }else{
                if(dp[row-1][col] > dp[row][col-1]){
                    scs.append(str1.charAt(row-1));
                    row--;
                }else{
                    scs.append(str2.charAt(col-1));
                    col--;
                }
            }
        }
        
        while(row > 0){
            scs.append(str1.charAt(row-1));
            row--;
        }
        
        while(col > 0){
            scs.append(str2.charAt(col-1));
            col--;
        }
     
        return scs.reverse().toString();
    }
}