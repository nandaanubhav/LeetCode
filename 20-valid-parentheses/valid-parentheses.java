class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()) {
            if(c == ')' || c == '}' || c == ']') {
                if(stack.isEmpty()) return false;
                if( (c == ')' && stack.peek() == '(') ||
                    (c == '}' && stack.peek() == '{') ||
                    (c == ']' && stack.peek() == '[')) {
                        stack.pop();
                        continue;
                    } else return false;
            }
            stack.add(c);
        }
        return stack.size() == 0;
    }
}