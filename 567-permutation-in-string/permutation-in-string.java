class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int s1Length = s1.length();
        int s2Length = s2.length();
        int[] s1Chars = new int[26];
        int[] s2Chars = new int[26];
        int left = 0, right = 0;
        for(char c: s1.toCharArray()) s1Chars[c - 'a']++;
        while(right < s2Length) {
            s2Chars[s2.charAt(right) - 'a']++;
            // System.out.println("Added " + s2.charAt(right));
            while(right - left + 1 > s1Length) {
                // System.out.println("Removing " + s2.charAt(left));
                s2Chars[s2.charAt(left) - 'a']--;
                left++;
            }
            if(Arrays.equals(s1Chars, s2Chars)) return true;
            right++;
        }
        return false;
    }
}