class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for(int[]  edge: edges) {
            if(!adjList.containsKey(edge[0])) adjList.put(edge[0], new ArrayList<>());
            if(!adjList.containsKey(edge[1])) adjList.put(edge[1], new ArrayList<>());
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }
        Queue<Integer> queue = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();
        queue.add(source);
        while(!queue.isEmpty()) {
            int node = queue.poll();
            if(node == destination) return true;
            for(int neighbor: adjList.getOrDefault(node, new ArrayList<>())) {
                if(!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
        return false;
    }
}