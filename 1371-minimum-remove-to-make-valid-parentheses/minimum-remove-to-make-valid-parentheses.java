class Solution {
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder(s);
        for(int i=0; i<sb.length(); i++) {
            char c = sb.charAt(i);
            if(c == ')' && stack.isEmpty()) {
                sb.deleteCharAt(i);
                i--;
            } else if(c == '(') {
                stack.add(i);
            } else if(c == ')') {
                stack.pop();
            }; 
        }
        while(!stack.isEmpty()) sb.deleteCharAt(stack.pop());
        return sb.toString();
    }
}