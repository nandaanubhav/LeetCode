class Solution {
    public int longestValidSubstring(String word, List<String> forbidden) {
        Set<String> forbiddenWords = new HashSet<>(forbidden);
        int left = 0, right = 0, n = word.length(), longestValidSubStrLen = 0;
        while(right < n) {
            for(int i=right; i>=right - 10 && i>=left; i--) {
                String subString = word.substring(i, right + 1);
                if(forbiddenWords.contains(subString)) {
                    left = i + 1;
                    break;
                }
            }
            longestValidSubStrLen = Math.max(longestValidSubStrLen, right - left + 1);
            right++;
        }
        return longestValidSubStrLen;
    }
}