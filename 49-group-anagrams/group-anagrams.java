class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        int[] charCount = new int[26];
        for(String s: strs) {
            Arrays.fill(charCount, 0);
            for(char c: s.toCharArray()) charCount[c - 'a']++;
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<26; i++) sb.append(charCount[i]).append("#");
            String key = sb.toString();
            if(!map.containsKey(key)) map.put(key, new ArrayList<>());
            map.get(key).add(s);
        }
        return new ArrayList<>(map.values());
    }
}