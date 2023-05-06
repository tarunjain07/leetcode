class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {

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
}