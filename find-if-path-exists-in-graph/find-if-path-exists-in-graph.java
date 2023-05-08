class Solution {
    
    //BFS
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        
        Map<Integer, List<Integer>> paths = new HashMap<>();
        for(int[] edge: edges){
            paths.computeIfAbsent(edge[0], k-> new ArrayList<>()).add(edge[1]);
            paths.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(edge[0]);

        }
        
        boolean[] seen  = new boolean[n];
        
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(source);
        seen[source] = true;
        
        while(!queue.isEmpty()){
            int polledElement = queue.poll();
            //seen[polledElement] = true; //this condition here will "allow" same element to be added in 
                                          //queue multiple times - bad performance

            if(polledElement == destination) return true;
                        
            for(int next: paths.get(polledElement)){
                if(!seen[next]){
                    seen[next] = true; //this condition here will "avoid" same element to be added in queue 
                                        // good performance

                    queue.offer(next);
                }
            }
        }
        
        return false;
        
    }
    //BFS end 
    
    // Union Find - start
    public boolean validPath_unionFind(int n, int[][] edges, int source, int destination) {
        UnionFind_UnionByRank_PathCompression uf = new UnionFind_UnionByRank_PathCompression(n);
        
        for(int[] edge: edges){
            uf.union(edge[0], edge[1]);    
        }
        
        return uf.find(source) == uf.find(destination);
    }
    // Union Find - end

    
    public boolean validPath_dfs(int n, int[][] edges, int source, int destination) {

        Map<Integer, List<Integer>> paths = new HashMap<>();
        for(int[] edge: edges){
            paths.computeIfAbsent(edge[0], k-> new ArrayList<>()).add(edge[1]);
            paths.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(edge[0]);

        }

        boolean[] visited = new boolean[n];

        boolean result = dfs(source, destination, paths, visited);
        System.out.println(result);
        return result;
    }

    public boolean dfs(int node, int destination, Map<Integer, List<Integer>> paths, boolean[] visited){
            
        visited[node] = true;

        if(node == destination){
            return true;
        }else{
            List<Integer> nextNodes = paths.get(node);
            if(nextNodes != null){
                for(int next: nextNodes){
                    if(!visited[next]){
                        boolean result  = dfs(next, destination, paths, visited);
                        if(result){
                            return true;
                        }
                    }
                }
            }
        }

        return false;
    }
    
    
    //Union Find with path compression and union by rank
     class UnionFind_UnionByRank_PathCompression {

        private int[] parent;
        // Use a rank array to record the height of each vertex, i.e., the "rank" of each vertex.
        private int[] rank;

        public UnionFind_UnionByRank_PathCompression(int size) {
            parent = new int[size];
            rank = new int[size];
            for (int i = 0; i < size; i++) {
                parent[i] = i;
                rank[i] = 1; // The initial "rank" of each vertex is 1, because each of them is
                // a standalone vertex with no connection to other vertices.
            }
        }

        // The find function here is the same as that in the disjoint set with path compression.
        public int find(int x) {
            if (x == parent[x]) {
                return x;
            }
            return parent[x] = find(parent[x]);
        }

        // The union function with union by rank
        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) {
                if (rank[rootX] > rank[rootY]) {
                    parent[rootY] = rootX;
                } else if (rank[rootX] < rank[rootY]) {
                    parent[rootX] = rootY;
                } else {
                    parent[rootY] = rootX;
                    rank[rootX] += 1;
                }
            }
        }


        public boolean connected(int x, int y) {
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