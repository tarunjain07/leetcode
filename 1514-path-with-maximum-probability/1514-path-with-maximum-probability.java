class Solution {
    
    public Map<Integer, List<Data>> getAdj(int[][] edges, double[] succProb){
        Map<Integer, List<Data>> adj = new HashMap<>();
        for(int i = 0 ; i < edges.length; i++){
            int x = edges[i][0];
            int y = edges[i][1];
            double prob = succProb[i];
            adj.computeIfAbsent(x, k->new ArrayList<Data>()).add(new Data(y, prob));
            adj.computeIfAbsent(y, k->new ArrayList<Data>()).add(new Data(x, prob));   
        }
      
        
        return adj;
    }
    
    //Dijkstra's with twist
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        
        Map<Integer, List<Data>> adj = getAdj(edges, succProb);
        
        //System.out.println(adj);
        
        PriorityQueue<Data> pq = new PriorityQueue<Data>(new DataComparator());
        double[] minDistance = new double[n];
        
        minDistance[start] = 1d; //start --> start 100% probability
        pq.add(new Data(start, 1));
        
        while(pq.size()>0){
            Data d = pq.poll();
            int source = d.e;
            double current_prob = d.distance;
            
            List<Data> neighbours = adj.get(source);
            if(neighbours != null){
                for(Data neighbour: neighbours){
                    double neighbourProb = neighbour.distance;
                    double totalProb = neighbourProb*current_prob;

                    int n_e = neighbour.e;

                    if (minDistance[n_e] < totalProb){
                        minDistance[n_e] = totalProb;
                        pq.add(new Data(n_e, totalProb));

                    }
                }
            }
        }
        return minDistance[end];
    }
}

class DataComparator implements Comparator<Data>{
    
    public int compare(Data d1, Data d2){
        return Double.compare(d2.distance, d1.distance);
    }
}
class Data{
    int e;
    double distance;
    
    public Data(int e, double distance){
        this.e = e;
        this.distance = distance;
    }
    
    public String toString(){
        return e + " "+ distance;
    }
}