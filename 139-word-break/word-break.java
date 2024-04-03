class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        HashSet<String> wordDictSet = new HashSet<>(wordDict);
        dp[0] = true;
        for(int right=1; right<=n; right++) {
            for(int left=0; !dp[right] && left < right; left++) {
                // System.out.println("checking for " + s.substring(j, i));
                dp[right] = dp[left] && wordDictSet.contains(s.substring(left, right));
            }
        }
        return dp[n];
    }
}