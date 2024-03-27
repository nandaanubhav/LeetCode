class TimeMap {
    Map<String, ArrayList<Pair<Integer, String>>> map;
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!map.containsKey(key)) {
            map.put(key, new ArrayList<>());
        }
        map.get(key).add(new Pair<>(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key)) return "";
        List<Pair<Integer, String>> temp = map.get(key);
        if(timestamp < temp.get(0).getKey()) return "";
        int low = 0, high = temp.size();
        while(low < high) {
            int mid = (low + high) / 2;
            if(temp.get(mid).getKey() <= timestamp) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        if(high == 0) return "";
        return temp.get(high - 1).getValue();
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */