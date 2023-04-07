class Solution {
    //0 - sea
    //1 - land
    public int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        
        //boundary dfs
        for(int i = 0; i <n; i++){
            for(int j = 0; j < m; j++){
                if((i*j == 0 || i == n-1 || j == m-1) && grid[i][j] == 1){
                    dfs(i, j, n, m, grid);
                }
            }
        }
        
        int ans = 0;
        for(int i = 0; i <n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1){
                    ans+=dfs(i, j, n, m, grid);
                }
            }
        }
        
        return ans;
    }
    
    int[][] directions = new int[][]{{1,0}, {0,1}, {-1,0}, {0,-1}};
    
    private boolean isValid(int r, int c, int n, int m, int[][] grid){
        if(r >= 0 && c >= 0 && r < n && c < m && grid[r][c] == 1){
            return true;
        }
        
        return false;
        
    }
    private int dfs(int r, int c, int n, int m, int[][]grid){
        
        int count = 1; 
        grid[r][c] = 0;
        
        for(int[] dir: directions){
            int new_r = r+dir[0];
            int new_c = c+dir[1];
            if(isValid(new_r, new_c, n, m, grid)){
                count+=dfs(new_r, new_c, n, m, grid);
            }
        }
        
        return count;
    }
}