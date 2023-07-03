class Solution {
    public boolean buddyStrings(String s, String goal) {
        if(s.length() != goal.length()){
            return false;
        }
        
        // -------------------- Equal Strings ---------------
        //aa aa  - true;
        //ab ab  - false;
        //abcda abcda - true
        //abcd abcd - false
        if(s.equals(goal)){
            return checkFreq(s);
        }
        
        // -------------------- Unequal strings ---------------
        List<Integer> unequalIndicies = new ArrayList<>();
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) != goal.charAt(i)){
                unequalIndicies.add(i);
            }
        }
        
        if(unequalIndicies.size() !=2){
            return false;
        }
        
        char[] sCharArray = s.toCharArray();
        char temp = sCharArray[unequalIndicies.get(0)];
        sCharArray[unequalIndicies.get(0)] = sCharArray[unequalIndicies.get(1)];
        sCharArray[unequalIndicies.get(1)] = temp;
        
        if(new String(sCharArray).equals(goal)){
            return true;
        }
        
        return false;
    }
    
    boolean checkFreq(String s){
        int[] arr = new int[26];
        for(char c: s.toCharArray()){
            arr[c-'a']++;
            if(arr[c - 'a'] > 1){
                return true;
            }
        }
        
        return false;
    }
    
    
}