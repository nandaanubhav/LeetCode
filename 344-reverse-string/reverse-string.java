class Solution {
    public void reverseString(char[] s) {
        int n = s.length;
        for(int i=0;i<n/2; i++) {
            char c = s[n-1-i];
            s[n-1-i] = s[i];
            s[i] = c;
        }
    }
}