class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] magazineChars = new int[26];
        for (int i=0;i<magazine.length();i++) {
            magazineChars[magazine.charAt(i) - 'a']++;
        }
        for (int i=0;i<ransomNote.length();i++) {
            int charIndex = ransomNote.charAt(i) - 'a';
            magazineChars[charIndex]--;
            if(magazineChars[charIndex] < 0) return false;
        }
        return true;
    }
}