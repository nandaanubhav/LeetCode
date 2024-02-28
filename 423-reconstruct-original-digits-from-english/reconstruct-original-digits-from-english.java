class Solution {
    public String originalDigits(String s) {
        int[] charSet = new int[26];
        for(char c : s.toCharArray()) {
            charSet[c - 'a']++;
        }
        int[] out = new int[10];
        out[0] = charSet['z' - 'a'];
        out[2] = charSet['w' - 'a'];
        out[4] = charSet['u' - 'a'];
        out[6] = charSet['x' - 'a'];
        out[8] = charSet['g' - 'a'];
        out[3] = charSet['h' - 'a'] - out[8];
        out[5] = charSet['f' - 'a'] - out[4];
        out[7] = charSet['s' - 'a'] - out[6];
        out[9] = charSet['i' - 'a'] - out[5] - out[6] - out[8];
        out[1] = charSet['n' - 'a'] - out[7] - (2 * out[9]);
        StringBuilder ans = new StringBuilder();
        for(int i=0; i<10; i++) {
            for(int j=0; j<out[i]; j++) {
                ans.append(i);
            }
        }
        return ans.toString();
    }
}