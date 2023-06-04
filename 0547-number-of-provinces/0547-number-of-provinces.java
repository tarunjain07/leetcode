class Solution {
    
    //DFS Start
    public int findCircleNum(int[][] isConnected) {
        Map<Integer, List<Integer>> adj = getAdj(isConnected);
        int size = adj.size();
        boolean[] visited = new boolean[size];

        int number_of_province = 0;
        for(int i = 0; i < size; i++){

            if(!visited[i]){
                number_of_province++;
                dfs(i, adj, visited);
            }
        }
        return number_of_province;
    }

    Map<Integer, List<Integer>> getAdj(int[][] connected){
        Map<Integer, List<Integer>> map = new HashMap<>();

        for(int i = 0; i < connected.length; i++){
            int[] connections = connected[i];
            map.putIfAbsent(i, new ArrayList<>());

            for(int j = 0; j < connections.length; j++){
                if(i != j && connections[j] == 1){
                    map.get(i).add(j);
                }
            }
        }

        System.out.println(map);
        return map;
    }

    public void dfs(int currentNode, Map<Integer, List<Integer>> adj, boolean[] visited){
        visited[currentNode] = true;

        List<Integer> neighbours = adj.get(currentNode);

        for(int neighbour: neighbours){
            if(!visited[neighbour]){
                dfs(neighbour, adj, visited);
            }
        }
    }
    //DFS End


    ///DSU Approach - Start
    public int findCircleNum_DSU(int[][] isConnected) {
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