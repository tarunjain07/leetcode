//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String input_line[] = in.readLine().trim().split("\\s+");
            int arr[]= new int[N];
            for(int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            System.out.println(ob.matrixMultiplication(N, arr));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    static int matrixMultiplication(int N, int arr[])
    {
        //return matrixMultiplication_recursive(arr, 1, N-1);
        Integer[][] memo = new Integer[N][N];
        //for(int[] x: memo){
        //    Arrays.fill(x, -1);
        //}
        
        return matrixMultiplication_memo(arr, 1, N-1, memo);
        
    }
    
    static int matrixMultiplication_memo(int[] arr,int i, int j, Integer[][] memo){
        if(i >= j){
            return 0;
        }
        
        if(memo[i][j] != null){
            return memo[i][j];
        }
        
        int min = Integer.MAX_VALUE;
        for(int k = i; k <= j-1; k++){
            int temp = matrixMultiplication_memo(arr, i, k, memo) 
                        + matrixMultiplication_memo(arr, k+1, j, memo) 
                        + arr[i-1]*arr[k]*arr[j];
                        
            min = Math.min(temp, min);
        }
        memo[i][j] = min;

        return min;
    }
    
    static int matrixMultiplication_recursive(int[] arr,int i, int j){
        if(i >= j){
            return 0;
        }
        
        int min = Integer.MAX_VALUE;
        for(int k = i; k <= j-1; k++){
            int temp = matrixMultiplication_recursive(arr, i, k) 
                        + matrixMultiplication_recursive(arr, k+1, j) 
                        + arr[i-1]*arr[k]*arr[j];
                        
            min = Math.min(temp, min);
        }
        
        return min;
    }
}