class Solution {
    
    //approach - 2
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(char c: s.toCharArray()){
            if(c == '('){
                stack.push(')');
            } else if(c == '['){
                stack.push(']');
            } else if(c == '{'){
                stack.push('}');
            } else if(stack.isEmpty() || stack.peek() != c){
                return false;
            } else{
              stack.pop();  
            }
        }
        return stack.isEmpty();
    }
    
    //approach - 1
    public boolean isValid_approach_1(String s) {
        
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