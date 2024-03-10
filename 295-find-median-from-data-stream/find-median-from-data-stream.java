class MedianFinder {
    PriorityQueue<Integer> lo;
    PriorityQueue<Integer> hi;
    public MedianFinder() {
        lo = new PriorityQueue<>(Collections.reverseOrder());
        hi = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        lo.add(num);
        hi.add(lo.poll());
        if(lo.size() < hi.size()) {
            lo.add(hi.poll());
        }
    }
    
    public double findMedian() {
        return lo.size() > hi.size() ? lo.peek() : ((double) (lo.peek() + hi.peek())/2);
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */