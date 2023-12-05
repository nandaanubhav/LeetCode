class Solution {
    public int numberOfMatches(int n) {
        int matchCount = 0;
        while(n > 1) {
            matchCount += n / 2;
            if (n%2 != 0) {
                n = (n/2) + 1;
            } else {
                n = n / 2;
            }
        }
        return matchCount;
    }
}