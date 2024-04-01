class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        List<int[]> answer = new ArrayList<>();
        answer.add(new int[]{intervals[0][0], intervals[0][1]});
        for(int i=1; i<intervals.length; i++) {
            if(intervals[i][0] > answer.getLast()[1]) {
                answer.add(new int[]{intervals[i][0], intervals[i][1]});
            } else {
                answer.getLast()[1] = Math.max(answer.getLast()[1], intervals[i][1]);
            }
        }
        return answer.toArray(new int[answer.size()][]);
    }
}