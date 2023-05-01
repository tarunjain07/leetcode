class Solution {
    public int earliestAcq(int[][] logs, int n) {
        
        java.util.Arrays.sort(logs, new java.util.Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return Integer.compare(a[0], b[0]);
            }
        });
        
        UnionFind uf = new UnionFind(n);
        int etime = 0;
        for(int[] log: logs){
            int time = log[0];
            int x = log[1];
            int y = log[2];
            
            if(uf.find(x) == uf.find(y)){
                continue;    
            }else{
                uf.union(x, y);
                etime = time;
            }
        }
        
        return uf.getCount()>1?-1:etime;
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