//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String str = br.readLine().trim();
            Solution ob = new Solution();
            int ans = ob.LongestRepeatingSubsequence(str);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int LongestRepeatingSubsequence(String str1)
    {
        String str2 = str1;
        int l,m;
        l = m = str1.length();
        
        int[][] dp = new int[l+1][m+1];
        
        for(int row = 1; row < l+1; row++){
            for(int col = 1; col < m+1; col++){
                if(str1.charAt(row-1) == str2.charAt(col-1) && row != col){
                    dp[row][col] = dp[row-1][col-1]+1;
                }else{
                    dp[row][col] = Math.max(dp[row][col-1], dp[row-1][col]);
                }
            }
        }
        
        return dp[l][m];
    }
}