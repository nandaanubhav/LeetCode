class Solution {
    public int countSubstrings(String s) {
        if (s.length() == 1) return 1;
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int ans = 0;
        for(int i=0; i<n; i++) {
            dp[i][i] = true;
            ans++;
        }
        for(int i=0; i<n-1; i++) {
            if(s.charAt(i) == s.charAt(i+1)) {
                dp[i][i+1] = true;
                ans++;
            }
        }
        for(int diff = 2; diff<n; diff++) {
            for(int i=0; i<n-diff; i++) {
                int j = i + diff;
                if(s.charAt(i) == s.charAt(j) && dp[i+1][j-1]) {
                    dp[i][j] = true;
                    ans++;
                }
            }
        }
        return ans;
    }
}