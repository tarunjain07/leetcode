class Solution {
    public int findCircleNum(int[][] isConnected) {
        UnionFind uf = new UnionFind(isConnected[0].length);
        
        for(int j = 0; j < isConnected.length; j++){
            for(int i = 0; i < isConnected[j].length; i++){
                if(isConnected[j][j] == 1 && isConnected[j][i] == 1 && i != j){
                    uf.union(i, j);

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
}