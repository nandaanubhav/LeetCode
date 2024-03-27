class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(String s: tokens) {
            if(s.equals("+")) {
                int a = stack.pop();
                int b = stack.pop();
                stack.add(a + b);
            } else if (s.equals("-")) {
                int a = stack.pop();
                int b = stack.pop();
                stack.add(b - a);
            } else if (s.equals("*")) {
                int a = stack.pop();
                int b = stack.pop();
                stack.add(a * b);
            } else if (s.equals("/")) {
                int a = stack.pop();
                int b = stack.pop();
                stack.add(b / a);
            } else {
                stack.add(Integer.valueOf(s));
            }
        }
        return stack.peek();
    }
}