//{ Driver Code Starts
import java.io.*;
import java.util.*;

class RodCutting {

    public static void main(String args[])throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        
        int t = Integer.parseInt(in.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(in.readLine().trim());
            String s[]=in.readLine().trim().split(" ");
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(s[i]);

            Solution ob = new Solution();
            out.println(ob.cutRod(arr, n));
        }
        out.close();
    }
}

// } Driver Code Ends


class Solution{
    public int cutRod(int price[], int n) {
        
        int size = price.length;

        int[][] dp = new int[size+1][n+1];
        
        for(int row = 1; row < size+1; row++){
            for(int col = 1; col < n+1; col++){
                
                int val = price[row-1];
                int length = row;
                
                if(length > col){
                    //no change on length and consider last answer
                    dp[row][col] = dp[row-1][col];
                }else{
                    //consider last answer or
                    // current val + currentsize - currenvalue
                    dp[row][col] = Math.max(dp[row-1][col], (val + dp[row][col-length]));
                }
            }
        }
        
        return dp[size][n];
        
    }
}