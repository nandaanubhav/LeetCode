
import java.util.Hashtable;class Solution {
    public int maxLengthBetweenEqualCharacters(String s) {
        Map<Character, Integer> startPosition = new HashMap<>();
        int n = s.length();
        int maxLength = -1;
        for(int i=0; i<n; i++) {
            char c = s.charAt(i);
            int prevPosition = startPosition.getOrDefault(c, -1);
            if(prevPosition >= 0) {
                maxLength = Math.max(maxLength, i - prevPosition - 1);
            }
            startPosition.putIfAbsent(s.charAt(i), i);
        }
        return maxLength;
    }
}