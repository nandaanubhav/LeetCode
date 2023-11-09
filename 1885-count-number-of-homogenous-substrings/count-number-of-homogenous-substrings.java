class Solution {
    public int countHomogenous(String s) {
        int MOD = 1_000_000_007;
        long sum = 0, currCount = 1;
        for(int i=1; i<s.length(); i++) {
            if(s.charAt(i) == s.charAt(i-1)) {
                currCount++;
            } else {
                sum += ((currCount * (currCount + 1)) / 2);
                currCount = 1;
            }
        }
        sum += ((currCount * (currCount + 1)) / 2);
        return (int) (sum % MOD);
    }
}