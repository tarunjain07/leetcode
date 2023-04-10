class Solution {
    
    public boolean isValid_approach1(String s) {
        return false;
    }
    //approach - 1
    public boolean isValid(String s) {
        
        Stack<Character> stack = new Stack<>();
        
        for(char c: s.toCharArray()){
            if(stack.isEmpty() || c == '(' || c == '[' || c == '{'){
                stack.push(c);
                continue;
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
        
        return stack.isEmpty();
    }
}