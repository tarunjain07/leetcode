//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String input[] = read.readLine().trim().split(" ");
            int n = Integer.parseInt(input[0]);
            int m = Integer.parseInt(input[1]);
            
            String S1 = read.readLine().trim();
            String S2 = read.readLine().trim();

            Solution ob = new Solution();
            System.out.println(ob.longestCommonSubstr(S1, S2, n, m));
        }
    }
}
// } Driver Code Ends


class Solution{
   
    int longestCommonSubstr(String S1, String S2, int n, int m){
        
        //int l = n < m?n:m;
        //Integer[][][] dp = new Integer[n+1][m+1][l+1];
        
        return longestCommonSubstr_bottomUp(S1, S2, n, m);
        
    }

    int longestCommonSubstr_bottomUp(String s1, String s2, int n, int m){
        int[][] dp = new int[n+1][m+1];
        
        int result = 0;
        for(int row = 1; row < n+1; row++){
            for(int col = 1; col < m+1; col++){
                if(s1.charAt(row-1) == s2.charAt(col-1)){
                    dp[row][col] = 1+dp[row-1][col-1];
                    result = Math.max(result, dp[row][col]);
                }else{
                    dp[row][col] = 0;
                }
            }
        }
        
        return result;
    }
    //memoized
    int longestCommonSubstr_memo(String s1, String s2, int n, int m, int res, Integer[][][] dp){
        if(n == 0 || m == 0)
            return res;
        
        int lForT3d = res;

        if(dp[n][m][res] != null){
            return dp[n][m][res];
        }
        
        if(s1.charAt(n-1) == s2.charAt(m-1)){
            //maxSubString = Math.max(maxSubString, size+1);
            res = longestCommonSubstr_memo(s1,s2, n-1, m-1, res+1, dp);
        }
        
        int x = longestCommonSubstr_memo(s1, s2, n, m-1, 0, dp);
        int y = longestCommonSubstr_memo(s1, s2, n-1, m, 0, dp); 
        
        return dp[n][m][lForT3d] = Math.max(res, Math.max(x,y));

    }
    
    //recursive
    int longestCommonSubstr_recursive(String s1, String s2, int n, int m, int res){
        // code here
        if(n == 0 || m == 0)
            return res;
        
        if(s1.charAt(n-1) == s2.charAt(m-1)){
            //maxSubString = Math.max(maxSubString, size+1);
            return longestCommonSubstr_recursive(s1,s2, n-1, m-1, res+1);
        }else{
            return Math.max(res, Math.max(longestCommonSubstr_recursive(s1,s2, n, m-1, 0),
                            longestCommonSubstr_recursive(s1,s2, n-1, m, 0)));
        }
    }
}