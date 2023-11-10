class Solution {
    public int[] restoreArray(int[][] adjacentPairs) {
        int n = adjacentPairs.length + 1;
        Map<Integer, List<Integer>> graph = new HashMap<>();
        if(adjacentPairs.length == 1) {
            return new int[]{adjacentPairs[0][0],adjacentPairs[0][1]};
        }
        for(int i=0; i<n-1;i++) {
            int[] edge = adjacentPairs[i];
            if(!graph.containsKey(edge[0])) {
                graph.put(edge[0], new ArrayList<>());
            }
            if(!graph.containsKey(edge[1])) {
                graph.put(edge[1], new ArrayList<>());
            }
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        int root = 0;
        for(int num: graph.keySet()) {
            if(graph.get(num).size() == 1) {
                root = num;
                break;
            }
        }
        int[] ans = new int[n];
        ans[0] = root;
        int prev = Integer.MAX_VALUE, curr = root;
        int index = 1;
        while(index < n) {
            for(int adjacentEl : graph.get(curr)) {
                if(adjacentEl != prev) {
                    ans[index++] = adjacentEl;
                    prev = curr;
                    curr = adjacentEl;
                    break;
                }
            }
        }
        return ans;
    }
}