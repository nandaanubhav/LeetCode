class Solution {
    int[][] directions = new int[][] {{0,1}, {0,-1}, {1,0}, {-1,0}};
    private void dfsUtil(int[][] image, int sr, int sc, int color, int newColor, int nr, int nc) {
        if(sr < 0 || sr >= nr || sc < 0 || sc >= nc || image[sr][sc] != color) return ;
        // System.out.println("Setting color of " + sr + " " + sc);
        image[sr][sc] = newColor;
        for(int[] direction : directions) {
            dfsUtil(image, sr + direction[0], sc + direction[1], color, newColor, nr, nc);
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int nr = image.length;
        int nc = image[0].length;
        if(image[sr][sc] != color) 
            dfsUtil(image, sr, sc, image[sr][sc], color, nr, nc);
        return image;
    }
}