class Solution {
    
    //Since constraint is that there will be no cycle so we don't need a visited array
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
         int n = graph.length;
        int source = 0;
        int destination = n - 1;

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(graph, source, destination, path, result);
        
        return result;
    }
    
    public void dfs(int[][] graph, int node, int destination, List<Integer> path, List<List<Integer>> result) {

        path.add(node);

        if (node == destination) {
            List<Integer> copy = new ArrayList<>(path);
            result.add(copy);
        } else {
            for (int neighbourNodes : graph[node]) {
                dfs(graph, neighbourNodes, destination, path, result);
            }
        }

        path.remove(path.size() - 1);

    }
}