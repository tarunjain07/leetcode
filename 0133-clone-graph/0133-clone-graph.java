/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    
    
    //DFS Traversal
    public Node cloneGraph(Node node){
        if(node == null)
            return node;
        
        
        //Original Node vs Clone Node
        Map<Node, Node> nodeMap = new HashMap<>();
        Set<Integer> visitedNodes =new HashSet<>();
        
        
        return dfs(node, nodeMap, visitedNodes);
        
        
    }
    
    private Node dfs(Node node, Map<Node, Node> nodeMap, Set<Integer> visitedNodes){
        
        if(visitedNodes.contains(node.val)){
            return nodeMap.get(node);
            
        }
        
        visitedNodes.add(node.val);
        Node cloneNode = nodeMap.getOrDefault(node, new Node(node.val)); //4'
        nodeMap.put(node, cloneNode);
        
        for(Node neighbor: node.neighbors){ //1,3
            Node neighborClone = nodeMap.get(neighbor); //1'

            if(neighborClone  == null){
                neighborClone = dfs(neighbor, nodeMap, visitedNodes);   
                nodeMap.put(neighbor, neighborClone);
            }

            cloneNode.neighbors.add(neighborClone); //2'-->1'
            //neighborClone.neighbors.add(cloneNode);
        }
        return cloneNode;

    }
    
    
    //BFS Traversal
    public Node cloneGraph_BFS(Node node) {
        if(node == null)
            return node;
        
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        
        Map<Integer, Node> nodeMap = new HashMap<>();
        nodeMap.put(node.val, new Node(node.val));
        
        while(!queue.isEmpty()){
            Node polledNode = queue.poll();
            Node cloneNode = nodeMap.get(polledNode.val);

            for(Node neighbor : polledNode.neighbors){
                Node neighborClone = nodeMap.getOrDefault(neighbor.val, new Node(neighbor.val));
                cloneNode.neighbors.add(neighborClone);

                 if(nodeMap.get(neighbor.val) == null){
                     nodeMap.put(neighbor.val, neighborClone);
                     queue.add(neighbor);
                 }
            }
        }
            
        
        
        
        return nodeMap.get(node.val);
    }
}