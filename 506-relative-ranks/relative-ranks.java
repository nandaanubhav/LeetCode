class Solution {
    public String[] findRelativeRanks(int[] score) {
        String[] ans = new String[score.length];
        TreeMap<Integer, Integer> map = new TreeMap<>(Collections.reverseOrder());
        for(int i=0; i<score.length; i++) {
            map.put(score[i], i);
        }
        int rank = 1;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(rank == 1) {
                 ans[entry.getValue()] = "Gold Medal";
            } else if (rank == 2) {
                 ans[entry.getValue()] = "Silver Medal";
            } else if (rank == 3) {
                 ans[entry.getValue()] = "Bronze Medal";
            } else {
                 ans[entry.getValue()] = String.valueOf(rank);
            }
            rank++;
        }
        return ans;
    }
}