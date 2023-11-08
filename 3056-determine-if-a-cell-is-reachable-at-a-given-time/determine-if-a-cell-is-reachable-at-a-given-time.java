class Solution {
    public boolean isReachableAtTime(int sx, int sy, int fx, int fy, int t) {
        int diagonalSteps = Math.min(Math.abs(fx - sx), Math.abs(fy - sy));
        int horizontalSteps = Math.abs(fx - sx) - diagonalSteps;
        int verticalSteps = Math.abs(fy - sy) - diagonalSteps;
        if (sx == fx && sy == fy && t == 1) {
            return false;
        }
        // System.out.println("diagonalSteps " + diagonalSteps);
        // System.out.println("horizontalSteps " + horizontalSteps);
        // System.out.println("verticalSteps " + verticalSteps);
        int totalSteps = diagonalSteps + horizontalSteps + verticalSteps;
        return totalSteps <= t;
    }
}