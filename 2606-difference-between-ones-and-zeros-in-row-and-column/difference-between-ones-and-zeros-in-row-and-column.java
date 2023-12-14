class Solution {
    public int[][] onesMinusZeros(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        int[] oneRows = new int[r];
        int[] oneCols = new int[c];
        for(int i=0; i<r; i++) {
            for(int j=0; j<c; j++) {
                if(grid[i][j] == 1) {
                    oneRows[i]++;
                    oneCols[j]++;
                }
            }
        }
        int[][] ans = new int[r][c];
        for(int i=0; i<r; i++) {
            for(int j=0; j<c; j++) {
                ans[i][j] = oneRows[i] - (r - oneRows[i]) + oneCols[j] - (c - oneCols[j]);
            }
        }
        return ans;
    }
}