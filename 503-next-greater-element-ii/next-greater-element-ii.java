class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<2*n-1; i++) {
            while(!stack.isEmpty() && nums[i % n] > nums[stack.peek() % n]) {
                int index = stack.pop() % n;
                ans[index] = nums[i % n];
            }
            stack.add(i % n);
        }
        return ans;
    }
}