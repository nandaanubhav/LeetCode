class Solution {
    public boolean isSubstringPresent(String s) {
        if(s.length() == 1) return false;
        Set<String> subStrings = new HashSet<>();
        for(int i=0; i<s.length() - 1; i++) {
            String subString = s.substring(i, i+2);
            subStrings.add(subString);
        }
        for(int i=0; i<s.length() - 1; i++) {
            String reversedSubstring = new StringBuilder().append(s.charAt(i+1)).append(s.charAt(i)).toString();
            if(subStrings.contains(reversedSubstring)) return true;
        }
        return false;
    }
}