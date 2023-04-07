class Solution {
    public int closedIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        //boundary DFS
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i * j == 0 || i == n - 1 || j == m - 1) {
                    if (grid[i][j] == 0) {
                        dfs(i, j, n, m, grid);
                        
                    }
                }
            }
        }

        //call DFS in whole grid
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 0) {
                    ans++;
                    dfs(i, j, n, m, grid);
                    
                }

            }
        }

        return ans;
    }

    private void dfs(int i, int j, int n, int m, int[][] grid) {
        grid[i][j] = 1;

        int[] ax = new int[]{1, -1, 0, 0};
        int[] ay = new int[]{0, 0, 1, -1};

        for (int k = 0; k < 4; k++) {
            int nx = i + ax[k];
            int ny = j + ay[k];

            if (isValid(nx, ny, n, m, grid)) {
                dfs(nx, ny, n, m, grid);
            }
        }
    }

    private boolean isValid(int nx, int ny, int n, int m, int[][] grid) {
        if(nx >= 0 && nx < n && ny >=0 && ny < m && grid[nx][ny] == 0){
            return true;
        }
        return false;
    }
}