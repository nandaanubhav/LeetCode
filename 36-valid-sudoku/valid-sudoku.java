class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Character>> rows = new HashMap<>();
        Map<Integer, Set<Character>> cols = new HashMap<>();
        Map<Integer, Set<Character>> boxes = new HashMap<>();
        for(int i=0; i<9; i++) {
            for(int j=0; j<9; j++) {
                if(board[i][j] == '.') continue;
                Set<Character> rowSet, colSet, boxSet;
                int boxNo = j / 3 + ((i / 3) * 3);
                // System.out.println("For i " + i + " j " + j + " box: " + boxNo);
                if(rows.containsKey(i)) {
                    rowSet = rows.get(i);
                } else rowSet = new HashSet<>();
                if(cols.containsKey(j)) {
                    colSet = cols.get(j);
                } else colSet = new HashSet<>();

                if(boxes.containsKey(boxNo)) {
                    boxSet = boxes.get(boxNo);
                } else boxSet = new HashSet<>();
                if(rowSet.contains(board[i][j]) || colSet.contains(board[i][j]) || boxSet.contains(board[i][j])) {
                    return false;
                }
                rowSet.add(board[i][j]);
                colSet.add(board[i][j]);
                boxSet.add(board[i][j]);
                rows.put(i, rowSet);
                cols.put(j, colSet);
                boxes.put(boxNo, boxSet);
            }
        }
        return true;
    }
}