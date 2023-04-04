class Solution {
    public int partitionString(String s) {
        Set<Character> charSet = new HashSet<>();
        int count = 0;
        for(char c:s.toCharArray()){
            if(charSet.contains(c)){
                count++;
                charSet.clear();
            }
             charSet.add(c);
        }
        
        return (charSet.isEmpty()) ? count : count+1;
        
    }
}