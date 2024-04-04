class Solution {
    public int integerBreak(int n) {
        if (n <= 3) return n-1;

        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;

        for (int i=4;i<=n;i++) {
            int maxProduct = i;
            for(int j=2; j < i; j++) {
                maxProduct = Math.max(maxProduct, j * dp[i-j]);
            }
            dp[i] = maxProduct;
        }
        return dp[n];
    }
}