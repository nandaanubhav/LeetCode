class Solution {
    public String reorganizeString(String s) {
        int[] charSet = new int[26];
        int n = s.length();
        for(char c : s.toCharArray()) charSet[c - 'a']++;
        int maxFreq = 0, letter = 0;
        for(int i=0; i<26; i++) {
            if(charSet[i] > maxFreq) {
                maxFreq = charSet[i];
                letter = i;
            }
        }
        if(maxFreq > Math.ceil((double)n/2)) return "";
        char[] ans = new char[n];
        int index = 0;
        while(charSet[letter] > 0) {
            ans[index] = (char) (letter + 'a');
            index += 2;
            charSet[letter]--;
        }
        for (int i = 0; i < charSet.length; i++) {
            while (charSet[i] > 0) {
                if (index >= s.length()) {
                    index = 1;
                }
                ans[index] = (char) (i + 'a');
                index += 2;
                charSet[i]--;
            }
        }
        return String.valueOf(ans);
    }
}