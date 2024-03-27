class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        Map<Character, Integer> pMap = new HashMap<>();
        Map<Character, Integer> sMap = new HashMap<>();
        List<Integer> ans = new ArrayList<>();
        int pSize = p.length();
        for(char c: p.toCharArray()) pMap.put(c, pMap.getOrDefault(c, 0) + 1);
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            sMap.put(c, sMap.getOrDefault(c, 0) + 1);
            if(i - pSize >= 0) {
                sMap.put(s.charAt(i - pSize), sMap.getOrDefault(s.charAt(i - pSize), 0) - 1);
                if(sMap.get(s.charAt(i - pSize)) == 0) sMap.remove(s.charAt(i - pSize));
            }
            // System.out.println(sMap);
            if(pMap.equals(sMap)) ans.add(i - pSize + 1);

        }
        return ans;
    }
}