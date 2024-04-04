class Solution {
    public boolean canJump(int[] nums) {  
        int n = nums.length;
        boolean[] dp = new boolean[n];
        dp[0] = true;
        for (int i=0; i<n; i++) {
            if (dp[i] == true) {
                int stepReachable = Math.min(nums[i] + i, n - 1);
                for (int j=i+1; j<=stepReachable; j++) {
                    dp[j] = true;
                }
            }
        }
        return dp[n-1];
    }
}