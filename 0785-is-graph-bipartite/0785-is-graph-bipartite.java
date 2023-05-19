class Solution {
    
    //odd  length cycle  is not bipartite
    //even length cylce  is     bipartite
    
    //BFS - start
    boolean isBipartiteBfs(Map<Integer, int[]> adj, int currNode, int[] colors, int currColor){
        colors[currNode] = currColor;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(currNode);
        
        while(!queue.isEmpty()){
            int ele = queue.poll();
                    
            int[] neighbours = adj.get(ele);
            for(int node: neighbours){
                if(colors[node] == colors[ele]){
                    return false;
                }
                
                if(colors[node] == -1){
                    queue.add(node);
                    colors[node] = 1-colors[ele];
                }
            }
            
        }
        
        return true;
    }
    public boolean isBipartite(int[][] graph){
        int n = graph.length;
        
        int[] colors = new int[n];
        Arrays.fill(colors, -1);

        
        Map<Integer, int[]> adj = getAdj(graph);
        //System.out.println(adj);
        
        for(int i = 0; i < n; i++){
            if(colors[i] == -1)
                if(isBipartiteBfs(adj, i, colors, 0) == false){
                    return false;
                }        
        }
        
        return true;
        
    }
    //BFS end
    
    //DFS start
    public boolean isBipartite_dfs(int[][] graph) {
        int n = graph.length;
        
        int[] colors = new int[n];
        Arrays.fill(colors, -1);

        
        Map<Integer, int[]> adj = getAdj(graph);
        //System.out.println(adj);
        
        boolean result = true;
        for(int i = 0; i < n; i++){
            if(colors[i] == -1)
                if(dfs(adj, i, colors, 0) == false){
                    return false;
                }        
        }
        
        return result;
    }
    
    boolean dfs(Map<Integer, int[]> adj, int currNode, int[] colors, int currColor ){
        
        colors[currNode] = currColor;
        
        int[] neighbours = adj.get(currNode);
        
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
    //DFS end
    
    //Not needed rather can simply put array in map
    
    Map<Integer, int[]> getAdj(int[][] graph){
        Map<Integer, int[]> adj = new HashMap<>();
        
        for(int i = 0; i<graph.length; i++){
            int[] nodes = graph[i];
            adj.put(i, nodes);

        }
        return adj;
    }
}