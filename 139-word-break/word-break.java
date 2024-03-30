class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        HashSet<String> wordDictSet = new HashSet<>(wordDict);
        dp[0] = true;
        for(int i=1; i<=n; i++) {
            for(int j=0; !dp[i] && j < i; j++) {
                // System.out.println("checking for " + s.substring(j, i));
                dp[i] = dp[j] && wordDictSet.contains(s.substring(j, i));
            }
        }
        return dp[n];
    }
}