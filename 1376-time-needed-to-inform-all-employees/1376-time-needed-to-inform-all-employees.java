class Solution {
    int maxTime = 0;
    
    //No need of visited array as tree doesn't have a cycle
    void DFS(Map<Integer, List<Integer>> adj, int[] informTime, int current_employee, int current_time){
        
        maxTime = Math.max(maxTime, current_time);
        
        List<Integer> subordinates = adj.getOrDefault(current_employee, new ArrayList<>());
    
        
        for(int subordinate: subordinates){
            DFS(adj, informTime, subordinate, current_time+informTime[current_employee]);
        }
    }
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        
        for(int i = 0; i < manager.length; i++){
            int employee = i;
            int manager_i = manager[i];
            
            if(manager_i != -1)
                adj.computeIfAbsent(manager_i, k->new ArrayList<Integer>()).add(employee);
        }
        
        //DFS
        DFS(adj, informTime, headID, 0);
        
        
        //System.out.println(adj);
        
        return maxTime;
    }
}