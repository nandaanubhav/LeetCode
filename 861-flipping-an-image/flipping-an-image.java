class Solution {
    public int[][] flipAndInvertImage(int[][] image) {
        int n = image.length;
        for(int i=0; i<n; i++) {
            for(int j=0; j<(n+1)/2; j++) {
                int temp = image[i][n-1-j];
                image[i][n-1-j] = image[i][j] == 0 ? 1 : 0;
                image[i][j] = temp == 0 ? 1 : 0;
            }
        }
        return image;
    }
}