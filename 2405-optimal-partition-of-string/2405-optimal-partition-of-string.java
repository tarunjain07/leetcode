class Solution {
    public int partitionString_UsingMap(String s) {
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
    
    //little smarter way
    public int partitionString(String s) {
        int[] lastSeen = new int[26];
        Arrays.fill(lastSeen, -1);
        
        int count = 1, subStringStart = 0;
        for(int i = 0; i < s.length(); i++){
            if(lastSeen[s.charAt(i) - 'a'] >= subStringStart){
                count++;
                subStringStart = i;
            }
            lastSeen[s.charAt(i) -'a'] = i;
        }
        
        return count;
    }
    //little smarter way end
    
    
    // using Bit manipluation - TODO - couldn't understand it rightnow
    // What's the use of 1<<shift?
     public int partitionString_BitManipluation(String s) {
        int ans = 1;
        int mask = 0;
        for (char ch : s.toCharArray()) {
            int shift = ch - 'a';
            if ((mask & (1 << shift)) > 0) {
                ans++;
                mask = 0;
            }
            mask |= 1 << shift;
        }
        return ans;
    }
    
}