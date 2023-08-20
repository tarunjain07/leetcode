class Solution {
    
    
    //Memoization
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length()][text2.length()];
        for(int[] subDP: dp){
            Arrays.fill(subDP, -1); //check base condition --> base value is 0
        }
        return longestCommonSubsequence_memo(text1, 0, text2, 0, dp);
    }
    
    
    private int longestCommonSubsequence_memo(String text1, int s1, String text2, int s2, int[][] dp){
        if(s1 == text1.length() || s2 == text2.length()){
            return 0;
        }
        
        if(dp[s1][s2] != -1){
            return dp[s1][s2];
        }
        
        if(text1.charAt(s1) == text2.charAt(s2)){
            return dp[s1][s2] =  1+longestCommonSubsequence_memo(text1, s1+1, text2, s2+1, dp);
        }else{
            return dp[s1][s2] = Math.max(longestCommonSubsequence_memo(text1, s1+1, text2, s2, dp),
                           longestCommonSubsequence_memo(text1, s1, text2, s2+1, dp));
        }
    }
    
    
    //Recursive aproach -
    //TLE for input
    //          "mhunuzqrkzsnidwbun"
    //          "szulspmhwpazoxijwbq"
    public int longestCommonSubsequence_recursive(String text1, String text2) {
        return longestCommonSubsequence_recursive(text1, 0, text2, 0);
    }
    
    private int longestCommonSubsequence_recursive(String text1, int s1, String text2, int s2){
        if(s1 == text1.length() || s2 == text2.length()){
            return 0;
        }
        
        if(text1.charAt(s1) == text2.charAt(s2)){
            return 1+longestCommonSubsequence_recursive(text1, s1+1, text2, s2+1);
        }else{
            return Math.max(longestCommonSubsequence_recursive(text1, s1+1, text2, s2),
                           longestCommonSubsequence_recursive(text1, s1, text2, s2+1));
        }
    }
}