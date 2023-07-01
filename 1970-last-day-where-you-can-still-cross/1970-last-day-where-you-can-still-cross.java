class DSU {
    int[] root, size;
    
    public DSU(int n) {
        root = new int[n];
        for (int i = 0; i < n; i++) {
            root[i] = i;
        }
        size = new int[n];
        Arrays.fill(size, 1);
    }
    
    public int find(int x) {
        if (root[x] != x) {
            root[x] = find(root[x]);
        }
        return root[x];
    }
    
    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX == rootY) {
            return;
        }
        
        if (size[rootX] > size[rootY]) {
            int tmp = rootX;
            rootX = rootY;
            rootY = tmp;
        }
        root[rootX] = rootY;
        size[rootY] += size[rootX];
    }
}

class Solution {
    
    public int latestDayToCross(int row, int col, int[][] cells) {
        DSU dsu = new DSU(row * col + 2);
        int[][] grid = new int[row][col];
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
        
        for (int i = 0; i < row * col; ++i) {
            int r = cells[i][0] - 1, c = cells[i][1] - 1;
            grid[r][c] = 1;
            int index1 = r * col + c + 1;
            for (int[] d : directions) {
                int newR = r + d[0], newC = c + d[1];
                int index2 = newR * col + newC + 1;
                if (newR >= 0 && newR < row && newC >= 0 && newC < col && grid[newR][newC] == 1) {
                    dsu.union(index1, index2);
                }
            }
            if (c == 0) {
                dsu.union(0, index1);
            }
            if (c == col - 1) {
                dsu.union(row * col + 1, index1);
            }
            if (dsu.find(0) == dsu.find(row * col + 1)) {
                return i;
            }
        }
        return -1;
    }
    
    //DFS + Binary Search
    public int latestDayToCross_dfs_binarySearch(int row, int col, int[][] cells) {
        
        int day = 0;

        int n = cells.length;
        int lo = -1; 
        int hi = n-1;
        
        while(lo+1 < hi){
            int mid = lo + (hi-lo)/2;
            if(canCross(row, col, mid, cells)){  //can cross
                lo  = mid;
            }else{
                hi = mid;
            }
            day = lo;
        }
        
        return day;
        
    }
    
    boolean canCross(int row, int col, int mid, int[][] cells){
        boolean[][] visited = new boolean[row][col];

        for(int i = 0; i < mid; i++){
            int[] cellToBeSubmerged = cells[i];
            int x = cellToBeSubmerged[0]-1;
            int y = cellToBeSubmerged[1]-1;
                
            visited[x][y] = true;
        }
        
        boolean canVisit = canVisitLasRow(row, col, visited);
        return canVisit;
    }
    
    boolean canVisitLasRow(int row, int col, boolean[][] visited){
        for(int row_i = 0, col_i = 0; col_i < col; col_i++){
            if(!visited[0][col_i]){
                boolean canVisit = dfs(0, col_i, row, col, visited);
                if(canVisit){
                    return canVisit;
                }
            }
        }
        
        return false;
    }
    
    
    //down, up, left, right
    int[][] dirs = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
    
    boolean dfs(int start_r, int start_c, int row, int col, boolean[][] visited){
         

        if(start_r == row-1){
            return true;
        }
        
        boolean result = false;
        
        visited[start_r][start_c] = true;

        for(int[] dir: dirs){
            int new_r = start_r + dir[0];
            int new_c = start_c + dir[1];


            if(new_r >= 0 && new_r < row && new_c >= 0 && new_c < col && !visited[new_r][new_c]){
                boolean canReachBottom =  dfs(new_r, new_c, row, col, visited);

                if(canReachBottom){
                    result = true;
                    break;
                }

            }
        }

        //visited[start_r][start_c] = false;
    
        return result;
    }
    //DFS + Binary Search

    
}