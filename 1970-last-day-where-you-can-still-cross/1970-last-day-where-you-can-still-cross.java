class Solution {
    
 
    public int latestDayToCross(int row, int col, int[][] cells) {
        
        return getDay(row, col, cells);
        
    }
    
    public int getDay(int row, int col, int[][] cells){
        
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
    
    
}