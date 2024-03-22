class KthLargest {
    PriorityQueue<Integer> pq;
    int maxPQSize;
    public KthLargest(int k, int[] nums) {
        pq = new PriorityQueue<>();
        maxPQSize = k;
        for(int i : nums) pq.add(i);
        while(pq.size() > maxPQSize) pq.remove();
    }
    
    public int add(int val) {
        pq.add(val);
        while(pq.size() > maxPQSize) pq.remove();
        return pq.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */