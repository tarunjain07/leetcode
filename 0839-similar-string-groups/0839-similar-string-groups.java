class Solution {


    //DFS Approach - Start
    public int numSimilarGroups(String[] strs) {
        int nodes = strs.length;
        ArrayList<Integer>[] adj = new ArrayList[nodes];
        
        for(int i = 0; i < nodes; i++){
            adj[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < strs.length; i++) {
            for (int j = i + 1; j < strs.length; j++) {
                if (isSimilar(strs[i], strs[j])){
                    adj[i].add(j);
                    adj[j].add(i);          
                }
            }
        }
        
        
        boolean[] visited = new boolean[nodes];
        
        int count = 0;
        for(int i = 0; i < nodes; i++){
            if(!visited[i]){
                count++;
                dfs(i, adj, visited);
            }
        }
        
        
        return count;
    }
    
    void dfs(int i,  ArrayList<Integer>[] adj, boolean[] visited){
        
        if(visited[i]){
            return;
        }
        
        visited[i] = true;
        
        ArrayList<Integer> nodes = adj[i];
        for(Integer node: nodes){
            dfs(node, adj, visited);
        }
    }

    //DFS Approach - End    

    
    //DSU Approach - Start
    public int numSimilarGroups_DSU(String[] strs) {
        
        UnionFind uf = new UnionFind(strs.length);
        System.out.println(uf.size());
        for (int i = 0; i < strs.length; i++) {
            for (int j = i + 1; j < strs.length; j++) {
                if (isSimilar(strs[i], strs[j]))
                    uf.Union(i, j);
            }
        }

        return uf.size();
        
    }
    
    
    
    class UnionFind {
        int[] parent;
        int[] rank;
        
        public UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];

            for (var i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int Find(int x) {
            if (x == parent[x]) {
                return x;
            }
            // compress the paths
            return parent[x] = Find(parent[x]);
        }

        public void Union(int x, int y){
            int lx = Find(x);
            int ly = Find(y);
            
            if(lx != ly){
                if(rank[lx] > rank[ly]){
                parent[ly] = lx;
                } else if(rank[lx] < rank[ly]){
                parent[lx] = ly;
                } else{
                parent[lx] = ly;
                rank[ly]++;
                }
            }
        }

        public int size() { // number of groups
            int ans = 0;
            for (int i = 0; i < parent.length; ++ i) {
                if (i == parent[i]) ans ++;
            }
            return ans;
        }  
    }
    //DSU Approach - End
    
    
    //common code
    //Asumption - All words in strs have the same length and are anagrams of each other.
    boolean isSimilar(String s, String t){
        int diff = 0;
        if(s.length() != t.length())
            return false;
        
        int n = s.length();
        for(int i = 0; i < n; i++){
            if(s.charAt(i) != t.charAt(i)){
                diff++;
            }
        }
        //no ned to check characters - due to above assumptions
        return (diff == 0 || diff == 2);
    }

}