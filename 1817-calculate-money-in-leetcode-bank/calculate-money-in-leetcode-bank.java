class Solution {
    public int totalMoney(int n) {
        int count = 0, ans = 0;
        while(n > 0) {
            int lastTerm = 0;
            if (n > 7) lastTerm = 7 + count;
            else lastTerm = n + count;
            ans += ((lastTerm * (lastTerm + 1)) / 2) - ((count * (count + 1)) / 2);
            n = n - 7;
            count++;
        }
        return ans;
    }
}