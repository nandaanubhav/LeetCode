class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        dp[0] = 0;
        for(int i=1; i<=amount; i++) {
            int noOfWays = amount + 1;
            System.out.println(noOfWays);
            for(int j=0; j<coins.length; j++) {
                if(i - coins[j] >= 0)
                   noOfWays = Math.min(noOfWays, dp[i - coins[j]] + 1);
            }
            dp[i] = noOfWays;
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}