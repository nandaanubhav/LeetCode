class Solution {

    private void dfs(int edge, List<Integer>[] adjList, int[] visited) {
        visited[edge] = 1;
        for(int i=0; i<adjList[edge].size(); i++) {
            if(visited[adjList[edge].get(i)] == 0) {
                dfs(adjList[edge].get(i), adjList, visited);
            }
        }
    }


    public int countComponents(int n, int[][] edges) {
        int components = 0;
        int[] visited = new int[n];
        
        List<Integer>[] adjList = new ArrayList[n]; 
        for (int i = 0; i < n; i++) {
            adjList[i] = new ArrayList<Integer>();
        }
        
        for (int i = 0; i < edges.length; i++) {
            adjList[edges[i][0]].add(edges[i][1]);
            adjList[edges[i][1]].add(edges[i][0]);
        }

        for(int i=0; i<n; i++) {
            if(visited[i] == 0) {
                components++;
                dfs(i, adjList, visited);
            }
        }

        return components;
    }
}