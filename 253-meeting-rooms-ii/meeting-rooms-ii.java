class Solution {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });
        // for(int i=0; i<intervals.length; i++) System.out.println(intervals[i][1]);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i=0; i<intervals.length; i++) {
            if (!pq.isEmpty() && intervals[i][0] >= pq.peek()) pq.poll();
            pq.add(intervals[i][1]);
        }
        return pq.size();
    }
}