class Solution {
    public boolean isValid(String s) {
        if(s.length() <2){
            return false;
        }
        
        Stack<Character> stack = new Stack<>();
        
        for(char c: s.toCharArray()){
            if(c == '(' || c == '[' || c == '{'){
                stack.push(c);
            }else{
                if(stack.isEmpty()){
                    return false;
                }
                
                char popChar = stack.pop();
                
                if(c == ')'){
                    if(popChar != '(') return false;
                }
                else if(c == ']'){
                   if(popChar != '[') return false;
                }
                else if(c == '}'){
                    if(popChar != '{') return false;
                }
                
            }
        }
        
        return stack.isEmpty();
    }
}