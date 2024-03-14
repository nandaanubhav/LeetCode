class Solution {
    int nr , nc;
    private static final int[][] DIRECTIONS = new int[][]{{0,1}, {0,-1}, {1,0}, {-1,0}};
    private int[][] createGrid(int rowConstant, int colConstant) {
        int[][] grid = new int[nr][nc];
        for(int i=0; i<nr; i++) grid[i][colConstant] = 1;
        for(int j=0; j<nc; j++) grid[rowConstant][j] = 1;
        return grid;
    }

    private void dfs(int[][] grid, int row, int col, int[][] heights) {
        if(row < 0 || row >= nr || col < 0 || col >= nc) return;
        grid[row][col] = 1;

        for(int[] direction : DIRECTIONS) {
            int newRow = row + direction[0];
            int newCol = col + direction[1];

            if(newRow < 0 || newRow >= nr || newCol < 0 || newCol >= nc) continue;

            if(grid[newRow][newCol] == 1) continue;

            if(heights[newRow][newCol] >= heights[row][col]) {
                dfs(grid, newRow, newCol, heights);
            }
        }
    }

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        nr = heights.length;
        nc = heights[0].length;
        int[][] pacificGrid = createGrid(0, 0);
        int[][] atlanticGrid = createGrid(nr - 1, nc  - 1);

        for(int i=0; i<nr; i++) {
            dfs(pacificGrid, i, 0, heights);
            dfs(atlanticGrid, i, nc - 1, heights);
        }

        for(int i=0; i<nc; i++) {
            dfs(pacificGrid, 0, i, heights);
            dfs(atlanticGrid, nr - 1, i, heights);
        }

        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0; i<nr; i++) {
            for(int j=0; j<nc; j++) {
                if(atlanticGrid[i][j] == 1 && pacificGrid[i][j] == 1) {
                    ans.add(Arrays.asList(i,j));
                }
            }
        }
        return ans;
    }
}