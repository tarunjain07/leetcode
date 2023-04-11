class Solution {
    public String removeStars(String s) {
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()){
            if(c == '*'){
                stack.pop();
            }else{
                stack.push(c);   
            }
            
        }
        
        System.out.println(stack);
        StringBuilder str = new StringBuilder();
        while(!stack.isEmpty()){
            str.append(stack.pop());
        }
        
        
        return str.reverse().toString();
    }   
}