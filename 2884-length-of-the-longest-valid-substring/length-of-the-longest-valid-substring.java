class Solution {
    public int longestValidSubstring(String word, List<String> forbidden) {
        HashSet<String> set = new HashSet<>();
        for(String s: forbidden) set.add(s);

        int n = word.length();
        int l = 0, r = 0, ans = 0;
        while(r < n) {
            for(int i=r; i>r-10 && i>=l; i--) {
                if(set.contains(word.substring(i, r+1))) {
                    l = i+1;
                    break;
                }
            }
            ans = Math.max(ans, r - l +1);
            r++;
        }
        return ans;
    }
}