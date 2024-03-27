class Solution {
    public int numTilings(int n) {
        if(n <= 2) return n;
        int MOD = 1_000_000_007;
        long[] fullyCovered = new long[n+1];
        long[] partiallyCovered = new long[n+1];
        fullyCovered[1] = 1L;
        fullyCovered[2] = 2L;
        partiallyCovered[2] = 1L;
        for(int k=3; k<=n; k++) {
            fullyCovered[k] = (fullyCovered[k-1] + fullyCovered[k-2] + 2 * partiallyCovered[k-1]) % MOD;
            partiallyCovered[k] = (partiallyCovered[k-1] + fullyCovered[k-2]) % MOD;
        }
        return (int) fullyCovered[n];
    }
}