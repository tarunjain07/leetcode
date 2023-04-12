class Solution {
    
    //Testcases
    //  "/home/"
    //  "/home//foo/"
    //  "/../"
    //  "/home/../foo/"
    //  "/home/../..//../foo/"
    //  "/a/./b/../../c/"
    public String simplifyPath(String path) {
        String[] splittedPaths = path.split("/");
        
        Deque<String> stack = new ArrayDeque<>();
        
        for(String splitPathVal: splittedPaths){
            if(splitPathVal.equals("") || splitPathVal.equals(".")){
                continue;
            }
            
            else if(splitPathVal.equals("..")){
                if(stack.isEmpty()){
                    continue;
                }else{
                    stack.removeLast();
                }
            }
            else{
                stack.addLast(splitPathVal);
            }
            
       }
        
        StringBuilder result  = new StringBuilder();
        
        while(!stack.isEmpty()){
            result.append("/");
            String val = stack.removeFirst();
            result.append(val);
        }
        
        return result.toString().isEmpty()?"/" :  result.toString();
            
        
    }
}