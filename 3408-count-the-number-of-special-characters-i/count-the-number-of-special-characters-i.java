class Solution {
    public int numberOfSpecialChars(String word) {
        Map<Character, Integer> lowerAlphabets = new HashMap<>();
        int specialCharCount = 0;
        for(char c: word.toCharArray()) {
            if(c - 'a' >= 0) {
                lowerAlphabets.put(c, 1);
            }
        }
        for(char c: word.toCharArray()) {
            if(c - 'a' < 0) {
                char target = (char) (c + 32);
                if(lowerAlphabets.containsKey(target) && lowerAlphabets.get(target) != -1) {
                    specialCharCount++;
                    lowerAlphabets.put(target, -1);
                }
            }
        }
        return specialCharCount;
    }
}