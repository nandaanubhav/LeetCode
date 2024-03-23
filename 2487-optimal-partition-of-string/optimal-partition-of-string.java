class Solution {
    public int partitionString(String s) {
        int subStrings = 1;
        Set<Character> set = new HashSet<>();
        for(char c : s.toCharArray()) {
            if(set.contains(c)) {
                subStrings++;
                set.clear();
            }
            set.add(c);
        }
        return subStrings;
    }
}