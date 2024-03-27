class Solution {
    public String reorganizeString(String s) {
        int[] charFreq = new int[26];
        int maxFreq = 0, n = s.length();
        char maxFreqChar = 'a';
        for(char c: s.toCharArray()) {
            charFreq[c - 'a']++;
            if(charFreq[c - 'a'] > maxFreq) {
                maxFreq = charFreq[c - 'a'];
                maxFreqChar = c;
            }
        }
        if(maxFreq > Math.ceil((double) n/2)) return "";
        char[] newString = new char[n];
        int index = 0;
        while(charFreq[maxFreqChar-'a'] > 0) {
            newString[index] = maxFreqChar;
            charFreq[maxFreqChar - 'a']--;
            index = index + 2;
        }
        for(int i=0; i<charFreq.length; i++) {
            while(charFreq[i] > 0) {
                if(index >= s.length()) index = 1;
                newString[index] = (char) (i + 'a');
                charFreq[i]--;
                index += 2;
            }
        }
        return new String(newString);
    }
}