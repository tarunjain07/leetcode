class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> zero = new ArrayList<>();
        zero.add(1);
        result.add(zero);
        
        if(numRows == 1){
            return result;
        }
        
        
        for(int i = 1; i < numRows; i++){
            List<Integer> current = new ArrayList<>();
            current.add(0,1);

            for(int j = 1; j < i; j++){
                current.add(result.get(i-1).get(j-1)+result.get(i-1).get(j));
            }
            current.add(i, 1);
            result.add(current);
        }
        return result;
    }
}