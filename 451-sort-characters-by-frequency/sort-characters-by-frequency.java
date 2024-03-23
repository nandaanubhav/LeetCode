class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> charFreq = new HashMap<>();
        for(char c : s.toCharArray()) charFreq.put(c, charFreq.getOrDefault(c, 0) + 1);
        List<Character> characters = new ArrayList<>(charFreq.keySet());
        Collections.sort(characters, (a, b) -> Integer.compare(charFreq.get(b), charFreq.get(a)));
        StringBuilder sb = new StringBuilder();
        for(char c: characters) {
            int count = charFreq.get(c);
            for(int i=0; i<count; i++) sb.append(c);
        }
        return sb.toString();
    }
}