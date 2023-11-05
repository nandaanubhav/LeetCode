class Leaderboard {

    Map<Integer, Integer> map;
    public Leaderboard() {
        map = new HashMap<>();
    }
    
    public void addScore(int playerId, int score) {
        map.put(playerId, map.getOrDefault(playerId, 0) + score);
    }
    
    public int top(int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
            pq.add(entry.getValue());
            if(pq.size() > K) pq.remove();
        }
        int sum = 0;
        Iterator val = pq.iterator();
        while(val.hasNext()) {
            sum += (int) val.next();
        }
        return sum;
    }
    
    public void reset(int playerId) {
        map.put(playerId, 0);
    }
}

/**
 * Your Leaderboard object will be instantiated and called as such:
 * Leaderboard obj = new Leaderboard();
 * obj.addScore(playerId,score);
 * int param_2 = obj.top(K);
 * obj.reset(playerId);
 */