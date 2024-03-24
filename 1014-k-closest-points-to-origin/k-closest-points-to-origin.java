class Solution {
    private int getEuclidienDistante(int[] p1, int[] p2) {
        double xDistance = Math.pow(p1[0] - p2[0], 2);
        double yDistance = Math.pow(p1[1] - p2[1], 2);
        return (int) (xDistance + yDistance);

    }
    public int[][] kClosest(int[][] points, int k) {
        Arrays.sort(points, (a,b) -> getEuclidienDistante(a, new int[]{0,0}) - getEuclidienDistante(b, new int[]{0,0}));
        return Arrays.copyOf(points, k);  
    }
}