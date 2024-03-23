class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        Map<Integer, Integer> indegree = new HashMap<>();
        Map<Integer, Integer> outdegree = new HashMap<>();
        for(int[] match: matches) {
            outdegree.put(match[0], indegree.getOrDefault(match[0], 0) + 1);
            indegree.put(match[1], indegree.getOrDefault(match[1], 0) + 1);
        }
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0; i<2; i++) ans.add(new ArrayList<>());
        for(Map.Entry<Integer, Integer> entry : outdegree.entrySet()) {
            if(!indegree.containsKey(entry.getKey())) ans.get(0).add(entry.getKey());
        }
        for(Map.Entry<Integer, Integer> entry : indegree.entrySet()) {
            if(entry.getValue() == 1) ans.get(1).add(entry.getKey());
        }
        Collections.sort(ans.get(0));
        Collections.sort(ans.get(1));
        return ans;
    }
}