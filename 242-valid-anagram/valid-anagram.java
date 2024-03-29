class Solution {
    public boolean isAnagram(String s, String t) {
        int[] charSet = new int[26];
        if (s.length() != t.length()) return false;
        for(int i=0; i<s.length(); i++) {
            charSet[s.charAt(i) - 'a']++;
            charSet[t.charAt(i) - 'a']--;
        }
        for(int i=0; i<26; i++) {
            if(charSet[i] != 0) return false;
        }
        return true;
    }
}