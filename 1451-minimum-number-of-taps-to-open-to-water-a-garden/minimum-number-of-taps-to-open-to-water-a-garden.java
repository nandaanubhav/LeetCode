class Solution {
    public int minTaps(int n, int[] ranges) {
        final int INF = (int) 1e9;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, INF);
        dp[0] = 0;
        for(int i=0; i<=n; i++) {
            int rangeStart = Math.max(0, i - ranges[i]);
            int rangeEnd = Math.min(n, i + ranges[i]);
            for(int j=rangeStart; j<= rangeEnd; j++) {
                dp[rangeEnd] = Math.min(dp[j] + 1, dp[rangeEnd]); 
            }
        }
        
        return (dp[n] == INF) ? -1 : dp[n];
    }
}