class Solution {
    public boolean checkValidString(String s) {
        Stack<Integer> bracketStack = new Stack<>();
        Stack<Integer> aestrickStack = new Stack<>();
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(c == '(') {
                bracketStack.add(i);
            } else if(c == '*') {
                aestrickStack.add(i);
            }
            else {
                if(bracketStack.isEmpty() && aestrickStack.isEmpty()) return false;
                if(!bracketStack.isEmpty()) bracketStack.pop();
                else if(!aestrickStack.isEmpty()) aestrickStack.pop();
            }
        }
        while(!aestrickStack.isEmpty() && !bracketStack.isEmpty()) {
            if(bracketStack.peek() > aestrickStack.peek()) return false;
            aestrickStack.pop();
            bracketStack.pop();
        }
        return bracketStack.isEmpty();
    }
}