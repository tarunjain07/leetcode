class Solution {
    public int longestPalindromeSubseq(String s) {
        String t = new StringBuilder(s).reverse().toString(); // This is the only difference than LCS
        
        int a = s.length();
        int b = t.length();
        
        int[][] dp = new int[a+1][b+1];
        
        for(int row = 1; row < a+1; row++){
            for(int col = 1; col < b+1; col++){
                if(s.charAt(row-1) == t.charAt(col-1)){
                    dp[row][col] = dp[row-1][col-1] +1;
                }else{
                    dp[row][col] = Math.max(dp[row][col-1] , dp[row-1][col]);
                }
            }
        }
        
        
        return dp[a][b];
    }
}