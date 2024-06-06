class Solution {
    public boolean isPossibleDivide(int[] nums, int k) {
        int size = nums.length;
        if(size % k != 0) return false;
        Map<Integer, Integer> map = new TreeMap<>();
        for(int currHand : nums) {
            map.put(currHand, map.getOrDefault(currHand, 0) + 1);
        }
        while(map.size() > 0) {
            int key = map.entrySet().iterator().next().getKey();
            for(int i=0; i<k; i++) {
                if(!map.containsKey(key + i)) return false;
                map.put(key + i, map.get(key + i) - 1);
                if(map.get(key + i) == 0) map.remove(key + i);
            }
        }
    return true;        
    }
}