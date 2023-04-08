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
    
    //BFS Traversal
    public Node cloneGraph(Node node) {
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