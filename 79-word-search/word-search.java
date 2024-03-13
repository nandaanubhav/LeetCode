class Solution {
    private int m;
    private int n;

    private boolean backtrack(int row, int col, int index, char[][] board, String word) {
        if(index >= word.length()) {
            System.out.print("Match Found");
            return true;
        }

        if(row < 0 || col < 0 || row == m || col == n || board[row][col] != word.charAt(index)) {
            return false;
        }

        board[row][col] = '.';

        int[] rowOffsets = {0, 1, 0, -1};
        int[] colOffsets = {1, 0, -1, 0};

        for (int d = 0; d < 4; ++d) {
            int currRow = row + rowOffsets[d];
            int currCol = col + colOffsets[d];
            
            if(backtrack(currRow, currCol, index+1, board, word)) return true;
        }
        board[row][col] = word.charAt(index);
        return false;
    }
    public boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(backtrack(i, j, 0, board, word)) return true;
            }
        }
        return false;
    }
}