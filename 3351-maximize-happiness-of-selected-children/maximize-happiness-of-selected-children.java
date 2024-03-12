class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        Arrays.sort(happiness);
        long maxHappiness = 0;
        for(int i=1; i<=k; i++) {
            int childSelected = happiness.length - i;
            maxHappiness += (happiness[childSelected] - i + 1) > 0 ? (happiness[childSelected] - i + 1) : 0;
        }
        return maxHappiness;
    }
}