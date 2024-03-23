class Solution {
    private boolean isVowel(char c) {
        if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') return true;
        return false;
    }
    public String reverseVowels(String s) {
        int l = 0, r = s.length() - 1;
        char[] sArray = s.toCharArray();
        while(l < r) {
            while(l < sArray.length && !isVowel(sArray[l])) l++;
            while(r >= 0 && !isVowel(sArray[r])) r--;
            if(l >= sArray.length || r < 0 || l >= r ) break;
            char c = sArray[l];
            sArray[l++] = sArray[r];
            sArray[r--] = c;
        }
        return new String(sArray);
    }
}