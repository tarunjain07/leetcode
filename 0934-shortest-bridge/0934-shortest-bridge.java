class Solution {
    public int shortestBridge(int[][] grid) {
        
        int n = grid.length;
        
        int[] found_cordinate = find_1(grid, n);
        
        //nxn
        boolean[][] visited = new boolean[n][n];
        
        Queue<int[]> queue = new LinkedList<>();
        
        dfs(grid, found_cordinate[0], found_cordinate[1], visited, queue, n);
                
        return bfs(grid, queue, visited, n);

    }
    
    int[][] dirs = new int[][]{
                {-1,0},
    {0,-1},               {0,1},
                {1, 0}
    };
    
    int bfs(int[][] grid, Queue<int[]> queue, boolean[][] visited, int n){
        int level = 0;
        
        while(!queue.isEmpty()){
            int size = queue.size();
            //System.out.println("size "+ size);

            for(int i = 0; i < size; i++){
                int[] pollVal = queue.poll();
                 //System.out.println("pollVal[0] "+pollVal[0]+" pollVal[1] "+pollVal[1]);
                
                for(int[] dir_temp : dirs){

                    int new_x = pollVal[0]+dir_temp[0];
                    int new_y = pollVal[1]+dir_temp[1];
                    

                    if(new_x >= 0 &&  new_x < n && new_y >= 0 && new_y < n && visited[new_x][new_y] == false ){

                         //System.out.println("newx "+new_x+" newy "+new_y+ " level "+level);

                        if(grid[new_x][new_y] == 1 ){
                            return level;
                        }
                        queue.add(new int[]{new_x, new_y});
                        visited[new_x][new_y] = true;
                    }
                }
            }
            level++;
        }
            
        
        return level;
    }
    
    int[] find_1(int[][] grid, int n){
        int[] result = new int[2];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }

        }
        
        return result;
    }
    
    void dfs(int[][] grid, int x, int y, boolean[][] visited, Queue<int[]> queue, int n){
               
        if(x < 0 || x >=n || y < 0 || y >= n || grid[x][y] == 0 || visited[x][y] == true){
            return;
        }
        
        //System.out.println("dfs x "+x+ " y "+y);
        
        queue.add(new int[]{x,y});
        
        visited[x][y] = true;
        for(int[] dir: dirs){
            int x_ = x+dir[0];
            int y_ = y+dir[1];
            dfs(grid, x_, y_, visited, queue,n);
        }
        
    }
}