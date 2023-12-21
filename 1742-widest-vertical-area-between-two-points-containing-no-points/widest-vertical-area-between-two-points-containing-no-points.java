class Solution {
    public int maxWidthOfVerticalArea(int[][] points) {
        Arrays.sort(points, (a,b) -> Integer.compare(a[0], b[0]));
        int n = points.length;
        int maxDiff = 0;
        for(int i=1; i<n; i++) {
            maxDiff = Math.max(maxDiff, points[i][0] - points[i-1][0]);
        }
        return maxDiff;
    }
}