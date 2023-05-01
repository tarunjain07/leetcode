class Solution {
    
    ///DSU Approach - Start
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        UnionFind uf = new UnionFind(n);
        //int numberOfComponents = n;

        for(int j = 0; j < n ; j++){
            for(int i = j+1; i < n ; i++){
                if(isConnected[j][j] == 1 && isConnected[j][i] == 1 && i != j){
                    uf.union(i, j);
                    //numberOfComponents--;
                }
            }
        }
        
        return uf.size();
    }
    
    class UnionFind{
        int[] parent;
        int[] rank;
        
        UnionFind(int n){
            parent = new int[n];
            rank = new int[n];
            for(int i =0; i <n ; i++){
                parent[i] = i;
                rank[i] = 1;
            }
        }
        
        public int find(int x){
            if(x == parent[x]){
                return x;
            }
            return parent[x] = find(parent[x]);
        }
        
        public void union(int x, int y){
            int p_x = find(x);
            int p_y = find(y);
            if(p_x != p_y){
                if(rank[p_x] < rank[p_y]){
                    parent[p_x] = p_y;
                }else if(rank[p_x] > rank[p_y]){
                    parent[p_y] = p_x;
                }else{
                    parent[p_y] = p_x;
                    rank[p_x]+=1;
                }
            }
        }
        
        public boolean isConnected(int x, int y){
            return find(x) == find(y);
        }
        
        public int size(){
            Set<Integer> values = new HashSet<>();
            for(int val: parent){
                values.add(find(val));
            }
            
            //System.out.println(values);
            return values.size();
        }
    }
    
    ///DSU Approach - End 
    
}