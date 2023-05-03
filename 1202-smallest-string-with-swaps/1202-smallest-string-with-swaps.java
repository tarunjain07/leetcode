class Solution {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        UnionFind uf = new UnionFind(s.length());

        for(List<Integer> pair: pairs){
            int source = pair.get(0);
            int dest = pair.get(1);
            uf.union(source, dest);
            
        }
        
        Map<Integer, List<Integer>> rootToVertexMapping = new HashMap<>();
        
        for(int i = 0; i < s.length(); i++){
            int root = uf.find(i);
            
            List<Integer> foundVal;
            if(rootToVertexMapping.get(root) == null){
                foundVal = new ArrayList<>();
            }else{
                foundVal = rootToVertexMapping.get(root);
            }
            foundVal.add(i);
            rootToVertexMapping.put(root, foundVal);
        }
        
        
        char[] sortedString = new char[s.length()];
        for(List<Integer> values: rootToVertexMapping.values()){
            
            List<Integer> indices = new ArrayList<>();
            List<Character> chars = new ArrayList<>();
            
            for(int val: values){
                indices.add(val);
                chars.add(s.charAt(val));
            }
            
            //System.out.println(indices);
            Collections.sort(chars);
            
            int i = 0;
            for(int index: indices){
                sortedString[index] = chars.get(i);
                i++;
            }            
        }
        
        return new String(sortedString);
    }
}

class UnionFind {
    private int[] root;
    private int[] rank;

    // Initialize the array root and rank
    // Each vertex is representative of itself with rank 1
    public UnionFind(int size) {
        root = new int[size];
        rank = new int[size];
        for (int i = 0; i < size; i++) {
            root[i] = i;
            rank[i] = 1;
        }
    }

    // Get the root of a vertex
    public int find(int x) {
        if (x == root[x]) {
            return x;
        }
        return root[x] = find(root[x]);
    }

    // Perform the union of two components
    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            if (rank[rootX] >= rank[rootY]) {
                root[rootY] = rootX;
                rank[rootX] += rank[rootY];
            } else {
                root[rootX] = rootY;
                rank[rootY] += rank[rootX];
            }
        }
    }
}