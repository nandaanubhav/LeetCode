class Solution {
    public boolean closeStrings(String word1, String word2) {
        if(word1.length() != word2.length()) return false;
        Map<Character, Integer> charFreq1 = new HashMap<>();
        Map<Character, Integer> charFreq2 = new HashMap<>();
        for(char c: word1.toCharArray()) charFreq1.put(c, charFreq1.getOrDefault(c, 0) + 1);
        for(char c: word2.toCharArray()) charFreq2.put(c, charFreq2.getOrDefault(c, 0) + 1);
        if(!charFreq1.keySet().equals(charFreq2.keySet())) return false;
        List<Integer> word1FrequencyList = new ArrayList<>(charFreq1.values());
        List<Integer> word2FrequencyList = new ArrayList<>(charFreq2.values());
        Collections.sort(word1FrequencyList);
        Collections.sort(word2FrequencyList);       
        return word1FrequencyList.equals(word2FrequencyList);
    }
}