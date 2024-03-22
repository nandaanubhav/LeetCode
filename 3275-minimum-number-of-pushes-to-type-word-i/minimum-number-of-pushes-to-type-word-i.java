class Solution {
    public int minimumPushes(String word) {
        int[] charFreq = new int[26];
        for(char c : word.toCharArray()) charFreq[c - 'a']++;
        int[] sorttedArray = Arrays.stream(charFreq).boxed().sorted(Collections.reverseOrder()).mapToInt(i->i).toArray();
        int keyPress = 0;
        for(int i=0; i<26; i++) {
            keyPress += (sorttedArray[i] * (i+8)/8);
        }
        return keyPress;
    }
}