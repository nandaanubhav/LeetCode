class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> Math.abs(a - x) - Math.abs(b - x) == 0 ? b - a : Math.abs(b - x) - Math.abs(a - x));
        for(int i : arr) {
            pq.add(i);
            while(pq.size() > k) {
                pq.remove();
            }
        }
        List<Integer> ans = new ArrayList<>();
        while(!pq.isEmpty()) ans.add(pq.poll());
        Collections.sort(ans);
        return ans;
    }
}