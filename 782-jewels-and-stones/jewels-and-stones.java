class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        Set<Character> jewelsSet = new HashSet<>();
        for(char c: jewels.toCharArray()) jewelsSet.add(c);
        int jewelCount = 0;
        for(char c: stones.toCharArray()) {
            if(jewelsSet.contains(c)) jewelCount++;
        }
        return jewelCount;
    }
}