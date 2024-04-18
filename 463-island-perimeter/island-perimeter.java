class Solution {
    public int islandPerimeter(int[][] grid) {
        int R = grid.length, C = grid[0].length, perimeter = 0;
        int up, down, left, right;
        for(int i=0; i<R; i++) {
            for(int j=0; j<C; j++) {
                if(grid[i][j] == 1) {
                    if(i == 0) up = 0;
                    else up = grid[i-1][j];
                    if(j == 0) left = 0;
                    else left = grid[i][j-1];
                    if(i == R-1) down = 0;
                    else down = grid[i+1][j];
                    if(j == C-1) right = 0;
                    else right = grid[i][j+1];
                    perimeter += 4 - (up + left + down + right);
                }
            }
        }
        return perimeter;
    }
}