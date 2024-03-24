class Solution {
    int[][] directions = new int[][]{{0,1},{0,-1},{1,0},{-1,0},{1,1},{-1,-1},{-1,1},{1,-1}};
    public void gameOfLife(int[][] board) {
        int r = board.length, c = board[0].length;
        int[][] ans = new int[r][c];
        for(int i=0; i<r; i++) {
            for(int j=0; j<c; j++) {
                int countLiveNeighbors = 0;
                for(int[] direction : directions) {
                    if(i + direction[0] < 0 || i + direction[0] >= r || j + direction[1] < 0 || j + direction[1] >= c) continue;
                    if(board[i + direction[0]][j + direction[1]] == 1) countLiveNeighbors++;
                }
                if(board[i][j] == 0) {
                    ans[i][j] = countLiveNeighbors == 3 ? 1 : 0;
                } else {
                    if(countLiveNeighbors < 2) ans[i][j] = 0;
                    else if(countLiveNeighbors >= 2 && countLiveNeighbors < 4) ans[i][j] = 1;
                    else ans[i][j] = 0;
                }
            }
        }
        for(int i=0; i<r; i++) {
            for(int j=0; j<c; j++) {
                board[i][j] = ans[i][j];
            }
        }
    }
}