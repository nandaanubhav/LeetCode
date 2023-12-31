class Solution {
    public int maxLengthBetweenEqualCharacters(String s) {
        Map<Character, Integer> startPosition = new HashMap<>();
        int n = s.length();
        int maxLength = -1;
        for(int i=0; i<n; i++) {
            char c = s.charAt(i);
            if(startPosition.containsKey(c)) {
                maxLength = Math.max(maxLength, i - startPosition.get(c) - 1);
            }
            startPosition.putIfAbsent(c, i);
        }
        return maxLength;
    }
}