class Solution {
    public boolean makeEqual(String[] words) {
        int[] charCount = new int[26];
        int n = words.length;
        for(String s : words) {
            for(int j=0; j<s.length(); j++) {
                charCount[s.charAt(j) - 'a']++;
            }
        }
        for(int i=0; i<26; i++) {
            if(charCount[i] > 0 && charCount[i] % n != 0) return false;
        }
        return true;
    }
}