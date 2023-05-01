class Solution {
    //Tree is a graph which doesn't have a cycle and all nodes are connected
    public boolean validTree(int n, int[][] edges) {
        UnionFind uf = new UnionFind(n);
        int numOfComponent = n;
        for(int[] edge: edges){
            if(uf.find(edge[0]) == uf.find(edge[1]))
                return false;
            uf.union(edge[0], edge[1]);
            numOfComponent--;
        }
        
        
        
        return numOfComponent>1?false:true;
    }
    
    class UnionFind {
        private int[] root;
        private int[] rank;
        private int count;

        UnionFind(int size) {
            root = new int[size];
            rank = new int[size];
            count = size;
            for (int i = 0; i < size; i++) {
                root[i] = i;
                rank[i] = 1;
            }
        }

        int find(int x) {
            if (x == root[x]) {
                return x;
            }
            return root[x] = find(root[x]);
        }

        void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) {
                if (rank[rootX] > rank[rootY]) {
                    root[rootY] = rootX;
                } else if (rank[rootX] < rank[rootY]) {
                    root[rootX] = rootY;
                } else {
                    root[rootY] = rootX;
                    rank[rootX] += 1;
                }
                count--;
            }
        }

        int getCount() {
            return count;
        }
    }
}