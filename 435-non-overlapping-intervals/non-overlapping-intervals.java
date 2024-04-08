class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int intervalsErased = 0;
        Stack<Integer> stack = new Stack<>();
        for(int[] interval: intervals) {
            if(!stack.isEmpty() && stack.peek() > interval[0]) {
                intervalsErased++;
                stack.add(Math.min(stack.pop(), interval[1]));
                continue;
            }
            stack.add(interval[1]);
        }
        return intervalsErased;
    }
}