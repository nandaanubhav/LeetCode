class Solution {
    public int knightDialer(int n) {
        if(n == 1) return 10;
        int[][] jumps = {
            {4, 6},
            {6, 8},
            {7, 9},
            {4, 8},
            {3, 9, 0},
            {},
            {1, 7, 0},
            {2, 6},
            {1, 3},
            {2, 4}
        };
        int MOD = 1_000_000_007;
        int[][] dp = new int[n][10];   
        for (int square = 0; square < 10; square++) {
            dp[0][square] = 1;
        }

        for(int i=1; i<n; i++) {
            for(int button=0; button<10; button++) {
                int ans = 0;
                for(int nextSquare : jumps[button]) {
                    ans =  (ans + dp[i-1][nextSquare]) % MOD;
                }
                dp[i][button] = ans;
            }
        }
        int ans = 0;
        for(int button=0; button<10; button++)
            ans = (ans + dp[n-1][button]) % MOD;

        return ans;

    }
}