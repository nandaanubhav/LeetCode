class Solution {
    public boolean validTree(int n, int[][] edges) {
        boolean[] visited = new boolean[n];
        List<List<Integer>> adjList = new ArrayList<>();
        Map<Integer, Integer> parent = new HashMap<>();
        for(int i=0; i<n; i++) adjList.add(new ArrayList<>());
        for (int i = 0; i < edges.length; i++) {
            adjList.get(edges[i][0]).add(edges[i][1]);
            adjList.get(edges[i][1]).add(edges[i][0]);
        }
        int components = 1;
        Stack<Integer> stack = new Stack<>();
        stack.add(0);
        parent.put(0, -1);
        while(!stack.isEmpty()) {
            int node = stack.pop();
            visited[node] = true;
            for(int neighbor : adjList.get(node)) {
                if(parent.get(node) == neighbor) continue;
                if(parent.containsKey(neighbor)) return false;
                if(!visited[neighbor]) {
                    components++;
                    stack.add(neighbor);
                    parent.put(neighbor, node);
                    // adjList.get(neighbor).remove(node);
                }
            }
        }
        System.out.print(components);
        return components == n;


    }
}