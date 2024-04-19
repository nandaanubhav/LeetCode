class Solution {
    int nr, nc;
    private void markIsland(char[][] grid, int row, int col) {
        if(row < 0 || row >= nr || col < 0 || col >= nc) {
            return;
        }
        if(grid[row][col] == '0') return;
        grid[row][col] = '0';
        markIsland(grid, row + 1, col); // down
        markIsland(grid, row - 1, col); // up
        markIsland(grid, row, col + 1); // right
        markIsland(grid, row, col - 1); // left

    }
    public int numIslands(char[][] grid) {
        nr = grid.length;
        nc = grid[0].length;
        int numIslands = 0;
        for(int i=0; i<nr; i++) {
            for(int j=0; j<nc; j++) {
                if (grid[i][j] == '1') {
                    numIslands++;
                    markIsland(grid, i, j);
                }
            }
        }
        return numIslands;
    }
}