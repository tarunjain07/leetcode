class Solution {
    //BFS - shortest path
    int[][] directions = new int[][]{{0,1}, {1,0}, {0,-1}, {-1,0}};
    
    public int shortestPathAllKeys(String[] grid) {
        
        int m = grid.length;
        int n = grid[0].length();
        
        int count_keys = 0;
        Queue<int[]> queue =new LinkedList<>();
        int shortestPath = -1;

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length(); j++){
                char ch = grid[i].charAt(j);
                if(ch >= 'a' && ch <= 'z'){
                    count_keys++;
                }
                if(ch == '@'){
                     queue.add(new int[]{i, j, 0, 0});
                }
            }
        }
        
        int final_key_status_decimal = (int)Math.pow(2, count_keys) - 1;
        int[][][] visited = new int[m][n][final_key_status_decimal+1];

        while(!queue.isEmpty()){
            int[] q = queue.poll();
            int x                           = q[0];
            int y                           = q[1];
            int steps                       = q[2];
            int current_key_status_decimal  = q[3];
            
            if(current_key_status_decimal == final_key_status_decimal){
                return steps;
            }
            
            for(int[] dir : directions){
                int new_x = x + dir[0];
                int new_y = y + dir[1];
                
                if(new_x >= 0 && new_x < m && new_y >= 0 && new_y < n &&  grid[new_x].charAt(new_y) != '#'){
                    
                    char charAtInGrid = grid[new_x].charAt(new_y);
                    
                    if(charAtInGrid >= 'A' && charAtInGrid <= 'Z'){ //lock
                        if(visited[new_x][new_y][current_key_status_decimal] == 0 && 
                            ((current_key_status_decimal >> (charAtInGrid -'A'))&1) == 1){
                            visited[new_x][new_y][current_key_status_decimal] = 1;
                            queue.add(new int[]{new_x, new_y, steps+1, current_key_status_decimal});
                        }
                    }else if(charAtInGrid >= 'a' && charAtInGrid <= 'z'){
                        int new_key_status_decimal = current_key_status_decimal | (1<<(charAtInGrid - 'a'));
                        
                        if(visited[new_x][new_y][new_key_status_decimal] == 0){
                            visited[new_x][new_y][new_key_status_decimal] = 1;
                            queue.add(new int[]{new_x, new_y, steps+1, new_key_status_decimal});
                        }
                    }else{
                        if(visited[new_x][new_y][current_key_status_decimal] == 0){
                            visited[new_x][new_y][current_key_status_decimal] = 1;
                            queue.add(new int[]{new_x, new_y, steps+1, current_key_status_decimal});

                        }
                    }

                }
            }
        }
        
        return -1;
    }
    
  
    
 
}