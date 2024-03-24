class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        for(int i=0; i<2*n; i++) {
            while(!stack.isEmpty() && nums[i % n] > nums[stack.peek() % n]) {
                ans[stack.pop() % n] = nums[i % n];
            }
            stack.add(i % n);
        }
        return ans;
    }
}