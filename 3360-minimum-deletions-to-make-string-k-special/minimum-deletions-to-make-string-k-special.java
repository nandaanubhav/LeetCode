class Solution {
    public int minimumDeletions(String word, int k) {
        int[] charFreq = new int[26];
        for(char c: word.toCharArray()) charFreq[c - 'a']++;
        int deletionCount = Integer.MAX_VALUE;
        for(int i=0; i<26; i++) {
            int currentDeletion = 0;
            for(int j=0; j<26; j++) {
                if(i == j) continue;
                if(charFreq[j] < charFreq[i]) currentDeletion += charFreq[j];
                else if(charFreq[j] > charFreq[i] + k) currentDeletion += charFreq[j] - charFreq[i] - k;
            }
            // System.out.println(i + " " + currentDeletion);
            deletionCount = Math.min(deletionCount, currentDeletion);
        }
        return deletionCount;
    }
}