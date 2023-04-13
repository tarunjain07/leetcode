class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        
        int j = 0;
        for(int i = 0; i < pushed.length; i++){
            int elementToPush = pushed[i];
            
            while(!stack.isEmpty() && popped[j] == stack.peek()){
                stack.pop();
                j++;
            }

            stack.push(elementToPush);            
            
        }
        
        
        while(!stack.isEmpty()){
            if(popped[j] != stack.pop()){
                return false;
            }
            j++;
        }
        
        return true;
    }
}