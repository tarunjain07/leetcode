class Solution {
    
    //odd  length cycle  is not bipartite
    //even length cylce  is     bipartite
    
    //DFS
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        
        int[] colors = new int[n];
        Arrays.fill(colors, -1);

        
        Map<Integer, List<Integer>> adj = getAdj(graph);
        System.out.println(adj);
        
        boolean result = true;
        for(int i = 0; i < n; i++){
            if(colors[i] == -1)
                if(dfs(adj, i, colors, 0) == false){
                    return false;
                }        
        }
        
        return result;
    }
    
    boolean dfs(Map<Integer, List<Integer>> adj, int currNode, int[] colors, int currColor ){
        
        colors[currNode] = currColor;
        
        List<Integer> neighbours = adj.get(currNode);
        
        for(int node: neighbours){
            if(colors[node] == colors[currNode]){
                return false;
            }
            
            //not colored/visited
            if(colors[node] == -1){
                int newColor = 1 - currColor;
                 if(dfs(adj, node, colors, newColor) == false)
                    return false;
                
            }
            
        }
        return true;
    }
    
    Map<Integer, List<Integer>> getAdj(int[][] graph){
        Map<Integer, List<Integer>> adj = new HashMap<>();
        
        for(int i = 0; i<graph.length; i++){
            int[] nodes = graph[i];
            if(nodes.length == 0){
                adj.put(i, new ArrayList<>());
            }
            for(int j = 0; j < nodes.length; j++){
                int node = nodes[j];
                adj.computeIfAbsent(i, k->new ArrayList<>()).add(node);
            }
            
        }
        return adj;
    }
}