//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    String s1 = sc.next();
                    String s2 = sc.next();
                    Solution ob = new Solution();
                    System.out.println(ob.minOperations(s1,s2));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java

class Solution
{
	public int minOperations(String str1, String str2) 
	{ 
	    int a = str1.length();
	    int b = str2.length();
	    
	    int[][] dp = new int[a+1][b+1];
	    
	    StringBuilder lcs = new StringBuilder();
	    for(int row = 1; row < a+1; row++){
	        for(int col = 1; col < b+1; col++){
	            if(str1.charAt(row-1) == str2.charAt(col-1)){
	                //lcs.append(str1.charAt(row-1));
	                dp[row][col] = dp[row-1][col-1]+1;
	            }else {
	                dp[row][col] = Math.max(dp[row][col-1], dp[row-1][col]);
	            }
	        }
	    }
	    
	    int lcsLen = dp[a][b];
	    //System.out.println("lcsLen "+lcsLen);
	    
	    int ans = a + b - 2*lcsLen;
	    return ans;
	} 
}