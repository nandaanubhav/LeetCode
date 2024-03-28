class Solution {
    private static final int[][] directions = new int[][]{{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0] != 0 || grid[grid.length - 1][grid[0].length - 1] != 0) return -1;
        int r = grid.length, c = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        grid[0][0] = 1;
        queue.add(new int[]{0,0});
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i=0; i<size; i++) {
                int[] cell = queue.poll();
                int row = cell[0];
                int col = cell[1];
                int distance = grid[row][col];
                if(row == r - 1 && col == c - 1) return distance;
                for(int[] direction : directions) {
                    int newRow = row + direction[0];
                    int newCol = col + direction[1];
                    if(newRow < 0 || newCol < 0 || newRow >= r || newCol >= c || grid[newRow][newCol] != 0) continue;
                    queue.add(new int[]{newRow, newCol});
                    grid[newRow][newCol] = distance + 1;
                }
            }
        }
        return -1;
    }
}