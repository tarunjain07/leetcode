//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String str = in.readLine();
            Solution ob = new Solution();
            System.out.println(ob.palindromicPartition(str));
        }
    }
}
// } Driver Code Ends




//User function Template for Java

class Solution{
    
    static int palindromicPartition(String str)
    {
        int N = str.length();
        Integer[][] t = new Integer[501][501];
        
        return palindromicPartition_memo(str, 0, str.length()-1, t);
        
    }
    
    static int palindromicPartition_memo(String str, int start, int end, Integer[][] t){
        if(start >= end){
            return 0;
        }
        
         if(t[start][end] != null){
            return t[start][end];
        }
        
        if(isPalindrome(str, start, end)){
            return 0;
        }
        
       
        


        int minCut = Integer.MAX_VALUE;
        for(int k = start; k < end; k++){
            
            int result1 = t[start][k] != null ? t[start][k]: palindromicPartition_memo(str, start, k, t);
            int result2 = t[k+1][end] != null ? t[k+1][end]: palindromicPartition_memo(str, k+1, end, t);
            int result = result1+result2+1;
            minCut = Math.min(result, minCut);
        
        }
        return t[start][end] = minCut;
        
    }
    
    static int palindromicPartition_recursive(String str, int start, int end){
        if(start >= end){
            return 0;
        }
        
        if(isPalindrome(str, start, end)){
            return 0;
        }
        else{
            int minCut = Integer.MAX_VALUE;

            for(int k = start; k < end; k++){
                int result = palindromicPartition_recursive(str, start, k)+
                                palindromicPartition_recursive(str, k+1, end)+
                                1;
                minCut = Math.min(result, minCut);
            
            }
            return minCut;
        }
        
    }
    
    static boolean isPalindrome(String str, int start, int end){
        int startIdx = start;
        int endIdx = end;
        
        if(startIdx >= endIdx){
            return true;
        }
        while(startIdx < endIdx){
            if(str.charAt(startIdx) != str.charAt(endIdx))
                return false;
            startIdx++;
            endIdx--;
        }
        return true;
    }
}