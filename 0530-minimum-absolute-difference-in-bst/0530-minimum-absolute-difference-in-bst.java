/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int getMinimumDifference(TreeNode root) {
        
        List<Integer> elements = new ArrayList<>();
        
        inOrder(root, elements);
        
        return getMinDiff(elements);
    }
    
    private void inOrder(TreeNode root, List<Integer> elements){
        if(root == null){
            return;
        }
        
        if(root.left != null)
            inOrder(root.left, elements);
        
        elements.add(root.val);
        
        if(root.right != null)
            inOrder(root.right, elements);
    }
    
    private int getMinDiff(List<Integer> elements){
        int minDiff = Integer.MAX_VALUE;
        
        for(int i = 0; i < elements.size()-1; i++){
            int diff = elements.get(i+1)- elements.get(i);
            minDiff = Math.min(diff, minDiff);
        }
        
        return minDiff;
    }
    
}