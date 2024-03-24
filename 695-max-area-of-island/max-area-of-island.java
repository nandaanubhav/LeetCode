class Solution {
    int[][] directions = new int[][]{{0,1}, {0,-1}, {1,0}, {-1,0}};
    private int dfs(int[][] grid, int sr, int sc, int nr, int nc) {
        if(sr >= nr || sr < 0 || sc >= nc || sc < 0 || grid[sr][sc] == 0) return 0;
        int area = 1;
        grid[sr][sc] = 0;
        for(int[] direction : directions) {
            area += dfs(grid, sr + direction[0], sc + direction[1], nr, nc);
        }
        return area;
    }
    public int maxAreaOfIsland(int[][] grid) {
        int nr = grid.length;
        int nc = grid[0].length;
        int maxArea = 0;
        for(int i=0; i<nr; i++) {
            for(int j=0; j<nc; j++) {
                if(grid[i][j] == 1) {
                    maxArea = Math.max(dfs(grid, i, j, nr, nc), maxArea);
                }
            }
        }
        return maxArea;
    }
}