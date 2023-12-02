class Solution {
    public int countCharacters(String[] words, String chars) {
        int[] charCount = new int[26];
        for(char c: chars.toCharArray()) charCount[c - 'a']++;
        int res = 0;
        for(String s : words) {
            int[] wordCharCount = new int[26];
            for(char c: s.toCharArray()) wordCharCount[c - 'a']++;
            boolean matched = true;
            for(int i=0; i<26; i++) {
                if(wordCharCount[i] > charCount[i]) matched = false;
            }
            if (matched) res += s.length();
        }
        return res;
    }
}