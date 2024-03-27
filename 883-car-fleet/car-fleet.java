class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        double[] endTime = new double[target];
        for (int i = 0; i < position.length; i++) {
            endTime[position[i]] = (double)(target - position[i]) / speed[i];
        }
        double prev = 0.0;
        int count = 0;
        for(int i=target-1; i>=0; i--) {
            if(endTime[i] > prev) {
                prev = endTime[i];
                count++;
            }
        }
        return count;
        
    }
}