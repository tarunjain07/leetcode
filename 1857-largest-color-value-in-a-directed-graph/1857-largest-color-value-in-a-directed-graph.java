class Solution {
    
    //TODO - dry run the solution - Revise and do it later again myself
    public int largestPathValue(String colors, int[][] edges) {
        Map<Integer, List<Integer>> adj = new HashMap<>();

        int N = colors.length();
        int[] indegree = new int[N];

        for (int[] edge : edges) {
            int s = edge[0];
            int d = edge[1];

            List<Integer> neighbors = adj.getOrDefault(s, new ArrayList<>());
            neighbors.add(d);

            adj.put(s, neighbors);

            indegree[d]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        int[][] t = new int[N][26];

        for (int i = 0; i < N; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
                t[i][colors.charAt(i) - 'a'] = 1;
            }
        }

        int answer = 0;
        int countNodes = 0;
        while (!queue.isEmpty()) {
            int u = queue.remove();
            countNodes++;

            answer = Math.max(answer, t[u][colors.charAt(u) - 'a']);

            final List<Integer> neighbors = adj.get(u);
            if (neighbors != null) {
                for (int neighbor : neighbors) {
                    for (int c = 0; c < 26; c++) {

                        final int i1 = colors.charAt(neighbor) - 'a' == c ? 1 : 0;
                        t[neighbor][c] = Math.max(t[neighbor][c], t[u][c] + i1);
                    }

                    indegree[neighbor]--;
                    if (indegree[neighbor] == 0) {
                        queue.add(neighbor);
                    }
                }
            }
        }
        return countNodes < N ? -1 : answer;

    }
    
    
}