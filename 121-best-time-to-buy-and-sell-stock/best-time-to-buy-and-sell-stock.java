class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[] suffixMax = new int[n+1];
        suffixMax[n] = 0;
        for(int i=n-1; i>0; i--) {
            suffixMax[i] = Math.max(prices[i], suffixMax[i+1]);
        }
        int maxProfit = 0;
        for(int i=0; i<n; i++) {
            maxProfit = Math.max(suffixMax[i+1] - prices[i], maxProfit);
        }
        return maxProfit;
    }
}