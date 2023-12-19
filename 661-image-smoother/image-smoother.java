class Solution {
    public int[][] imageSmoother(int[][] img) {
        int r = img.length;
        int c = img[0].length;
        int[][] smoothenedImage = new int[r][c];
        for(int i=0; i<r; i++) {
            for(int j=0; j<c; j++) {
                System.out.print(img[i][j]);
                int sum = 0, count = 0;
                for(int x=-1; x<=1; x++) {
                    for(int y=-1; y<=1; y++) {
                        if (i+x>=0 && i+x<r && j+y>=0 && j+y<c) {
                            sum += img[i+x][j+y];
                            count++;
                        }
                    }
                }
                smoothenedImage[i][j] = Math.floorDiv(sum, count);
            }
        }
        return smoothenedImage;
    }
}