class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l = 0, i = 0, longestSubString = 0;
        Map<Character, Integer> charSet = new HashMap<>();
        while(i < s.length()) {
            char c = s.charAt(i);
            if(charSet.containsKey(c)) {
                int index = charSet.get(c);
                if (index + 1 > l) l = index + 1;
            }
            charSet.put(c, i);
            longestSubString = Math.max(longestSubString, i - l + 1);
            i++;
        }
        return longestSubString;
    }
}