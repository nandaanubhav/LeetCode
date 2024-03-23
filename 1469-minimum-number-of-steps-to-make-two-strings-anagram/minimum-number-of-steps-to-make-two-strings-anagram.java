class Solution {
    public int minSteps(String s, String t) {
        int[] sCharFreq = new int[26];
        int[] tCharFreq = new int[26];
        for(char c: s.toCharArray()) sCharFreq[c - 'a']++;
        for(char c: t.toCharArray()) tCharFreq[c - 'a']++;
        int steps = 0;
        for(int i=0; i<26; i++) {
            steps += Math.abs(sCharFreq[i] - tCharFreq[i]);
        }
        return steps/2;
    }
}