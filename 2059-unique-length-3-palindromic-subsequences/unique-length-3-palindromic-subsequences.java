class Solution {
    public int countPalindromicSubsequence(String s) {
        Set<Character> chars = new HashSet<>();
        int ans = 0;
        for(int i=0; i<s.length(); i++) chars.add(s.charAt(i));

        for(char c: chars) {
            int i = -1, j = 0;
            for(int k=0; k<s.length(); k++) {
                if(s.charAt(k) == c) {
                    if(i == -1) i = k;
                    j = k;
                }
            }
            Set<Character> between = new HashSet<>();
            for(int k=i+1; k<j; k++) between.add(s.charAt(k));
            ans += between.size();
        }
        return ans;
        
    }
}