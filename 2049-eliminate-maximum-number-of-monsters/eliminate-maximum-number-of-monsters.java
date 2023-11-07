class Solution {
    public int eliminateMaximum(int[] dist, int[] speed) {
        PriorityQueue<Double> arrivalTimes = new PriorityQueue<>();
        for(int i=0; i<dist.length; i++) {
            arrivalTimes.add((double)dist[i]/speed[i]);
        }
        int monsterCount = 0;
        // arrivalTimes.poll();
        while(!arrivalTimes.isEmpty()) {
            if(arrivalTimes.peek() <= monsterCount) {
                break;
            }
            arrivalTimes.poll();
            monsterCount++;

        }
        return monsterCount;
    }
}