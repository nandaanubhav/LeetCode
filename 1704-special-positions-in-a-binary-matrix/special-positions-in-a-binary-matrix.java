class Solution {
    public int numSpecial(int[][] mat) {
        int r = mat.length;
        int c = mat[0].length;
        int[] row1Count = new int[r];
        int[] col1Count = new int[c];
        for(int i=0; i<r; i++) {
            for(int j=0; j<c; j++) {
                if(mat[i][j] == 1) {
                    row1Count[i]++;
                    col1Count[j]++;
                }
            }
        }
        int specialCount = 0;
        for(int i=0; i<r; i++) {
            for(int j=0; j<c; j++) {
                if(mat[i][j] == 1 && row1Count[i] == 1 && col1Count[j] == 1) {
                    specialCount++;
                }
            }
        }
        return specialCount;
    }
}