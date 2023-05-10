class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        
        int r_max  = matrix.length;
        int c_max = matrix[0].length;
        
        int r1 = 0, r2 = r_max-1, c1 = 0, c2 = c_max-1;
        
        while(r1<=r2 && c1 <=c2){
            
            //System.out.println("r1 "+r1 +" r2 "+r2 +" r2-1 "+(r2-1) +" c1 "+c1);
            //System.out.println("c1 "+c1 +" c2 "+c2 +" c2-1 "+(c2-1));

            //left to right
            for(int c = c1; c <= c2; c++){
                result.add(matrix[r1][c]);
            }
            
            //top to bottom
            for(int r = r1+1; r <= r2; r++){
                result.add(matrix[r][c2]);
            }
            
                
            //right to left
            //r1 < r2 is needed because we don't want to move right to left on same row
            for(int c = c2-1;  r1 < r2 && c >= c1; c--){
                result.add(matrix[r2][c]);
            }
                
                
            //bottom to top
            for(int r = r2-1; c1 < c2 && r > r1; r--){
                result.add(matrix[r][c1]);
            }
            
            r1++;
            r2--;
            c1++;
            c2--;
        }
        
        return result;
    }
}