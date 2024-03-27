class Solution {
    public String countAndSay(int n) {
        String[] dp = new String[n];
        dp[0] = "1";
        for(int i=1; i<n; i++) {
            StringBuilder sb = new StringBuilder();
            String prev = dp[i-1];
            int count = 1;
            for(int j=1; j<prev.length(); j++) {
                if(prev.charAt(j) == prev.charAt(j-1)) count++;
                else {
                    sb.append(count).append(prev.charAt(j-1));
                    count = 1;
                }
            }
            sb.append(count).append(prev.charAt(prev.length() - 1));
            dp[i] = sb.toString();
        }
        return dp[n-1];
    }
}