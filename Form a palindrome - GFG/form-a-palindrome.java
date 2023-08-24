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
            
            String S = read.readLine().trim();
            Solution ob = new Solution();
            System.out.println(ob.findMinInsertions(S));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    int findMinInsertions(String S){
        String T = new StringBuilder(S).reverse().toString();
        
        int len1 = S.length();
        int len2 = T.length();
        
        int[][] dp = new int[len1+1][len2+1];
        
        for(int row = 1; row < len1+1; row++){
            for(int col = 1; col < len2+1; col++){
                if(S.charAt(row-1) == T.charAt(col-1)){
                    dp[row][col] = dp[row-1][col-1]+1;
                }else{
                    dp[row][col] = Math.max(dp[row-1][col], dp[row][col-1]);
                }
            }
        }
        
        int lcsLen = dp[len1][len2];
        
        return S.length()-lcsLen;
    }
}