class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        int n = nums.length;
        int[] dp = new int[n];
        int[] dp2 = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(dp[0], nums[1]);
        for (int i=2; i<n-1; i++) {
            dp[i] = Math.max(dp[i-2] + nums[i], dp[i-1]);
        }
        dp2[0] = 0;
        dp2[1] = nums[1];
        for (int i=2; i<n; i++) {
            dp2[i] = Math.max(dp2[i-2] + nums[i], dp2[i-1]);
        }
        // for (int i=0; i<n; i++) {
        //     System.out.println("Without First House " + dp2[i]);
        //     System.out.println("With First House " + dp[i]);
        // }
        return Math.max(dp[n-2], dp2[n-1]);
    }
}