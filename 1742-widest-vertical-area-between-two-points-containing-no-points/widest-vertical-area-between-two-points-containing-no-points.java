class Solution {
    public int maxWidthOfVerticalArea(int[][] points) {
        int n = points.length;
        int[] xCordinates = new int[n];
        for(int i=0; i<n; i++) {
            xCordinates[i] = points[i][0];
        }
        Arrays.sort(xCordinates);
        int maxDiff = 0;
        for(int i=1; i<n; i++) {
            maxDiff = Math.max(maxDiff, xCordinates[i] - xCordinates[i-1]);
        }
        return maxDiff;
    }
}