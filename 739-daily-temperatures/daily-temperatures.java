class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int n = temperatures.length;
        int[] ans = new int[n];
        for(int i=n-1; i>=0; i--) {
            if(!stack.isEmpty()) {
                if(temperatures[i] < temperatures[stack.peek()]) {
                    ans[i] = stack.peek() - i;
                    stack.add(i);
                } else {
                    while(!stack.isEmpty() && temperatures[i] >= temperatures[stack.peek()]) {
                        stack.pop();
                    }
                    ans[i] = stack.isEmpty() ? 0 : stack.peek() - i;
                    stack.add(i);
                }
            } else {
                ans[i] = 0;
                stack.add(i);
            }
        }
        return ans;
    }
}