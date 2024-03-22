class Solution {
    public int firstUniqChar(String s) {
        int[] charFreq = new int[26];
        for(char c : s.toCharArray()) charFreq[c-'a']++;
        for(int index = 0; index<s.length(); index++) {
            if(charFreq[s.charAt(index)-'a'] == 1) return index;
        }
        return -1;
    }
}