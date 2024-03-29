class Solution {
    public int longestValidSubstring(String word, List<String> forbidden) {
        Set<String> set = new HashSet<>(forbidden);
        int n = word.length();
        int l = 0, r = 0, ans = 0;
        while(r < n) {
            for(int i=r; i>r-10 && i>=l; i--) {
                String subString = word.substring(i, r+1);
                // System.out.println(subString);
                if(set.contains(subString)) {
                    l = i+1;
                    // System.out.println("Match found moving l to " + l);
                    break;
                }
            }
            // System.out.println("Checking for length: " + r + " " + l + " + 1");
            ans = Math.max(ans, r - l + 1);
            r++;
        }
        return ans;
    }
}