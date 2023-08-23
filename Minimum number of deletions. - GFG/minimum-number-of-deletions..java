//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            int n = Integer.parseInt(read.readLine());
            String str = read.readLine().strip();
            Solution ob = new Solution();
            long ans = ob.minDeletions(str, n); 
            System.out.println(ans);
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java
class Solution 
{ 
    int minDeletions(String str1, int n)
    {
        String str2 = new StringBuilder(str1).reverse().toString();
        
        int a = str1.length();
        int b = str2.length();
        
        int[][] dp = new int[a+1][b+1];
        
        for(int row = 1; row < a+1; row++){
            for(int col = 1; col < b+1; col++){
                if(str1.charAt(row-1) == str2.charAt(col-1)){
                    dp[row][col] = 1 + dp[row-1][col-1];
                }else{
                    dp[row][col] = Math.max(dp[row-1][col], dp[row][col-1]);
                }
            }
        }
        
        int len = dp[a][b];
        if(str1.length() == len){
            return 0;
        }
        
        return str1.length() - len;
    }
} 