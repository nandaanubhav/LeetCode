class Solution {
    private void dfs(int[][] isConnected, int node, boolean[] seen) {
        //out of bounds condition
        seen[node] = true;
        // int[] nodeConnectedList = isConnected[node];
        for(int i=0; i<isConnected.length; i++) {
            if(isConnected[node][i] == 1 && !seen[i]) {
                dfs(isConnected, i, seen);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int noProvinces = 0;
        boolean[] seen = new boolean[n];
        for(int i=0; i<n; i++) {
            if(!seen[i]) {
                noProvinces++;
                dfs(isConnected, i, seen);
            }
        }
        return noProvinces;
    }
}