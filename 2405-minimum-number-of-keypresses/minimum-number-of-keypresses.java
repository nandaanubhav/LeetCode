class Solution {
    public int minimumKeypresses(String s) {
        int[] charFreq = new int[26];
        int keyPressRequired = 0;
        for(char c: s.toCharArray()) {
            charFreq[c - 'a']++;
        }
        int[] descCharFreq = Arrays.stream(charFreq).map(i -> -i).sorted().map(i -> -i).toArray();
        for(int i=0; i<26; i++) {
            if(i < 9) keyPressRequired += descCharFreq[i];
            else if (i >= 9 && i < 18) keyPressRequired += 2 * descCharFreq[i];
            else keyPressRequired += 3 * descCharFreq[i];
        }
        return keyPressRequired;

    }
}