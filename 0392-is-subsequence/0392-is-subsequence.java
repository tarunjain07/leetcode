class Solution {
    public boolean isSubsequence(String s, String t) {
        int len1 = s.length();
        int len2 = t.length();
        
        int[][] dp = new int[len1+1][len2+1];
        
        for(int row = 1; row < len1+1; row++){
            for(int col = 1; col < len2+1; col++){
                if(s.charAt(row-1) == t.charAt(col-1)){
                    dp[row][col] = dp[row-1][col-1]+1;
                }else{
                    dp[row][col] = Math.max(dp[row-1][col], dp[row][col-1]);
                }
            }
        }
        
        int lcsLen = dp[len1][len2];
        
        return len1 == lcsLen;
    }
    public boolean isSubsequence_recursion(String s, String t) {
        return isSubsequence_recursion(s, s.length()-1, t, t.length()-1, 0);
    }
    
    public boolean isSubsequence_recursion(String s, int x, String t, int y, int count){
        if(x < 0 || y < 0){
            return s.length() == count;
        }
        
        if(s.charAt(x) == t.charAt(y)){
            return isSubsequence_recursion(s, x-1, t, y-1, count+1);
        }else{
            return isSubsequence_recursion(s, x-1, t, y, count) || isSubsequence_recursion(s, x, t, y-1, count);
        }
    }
}