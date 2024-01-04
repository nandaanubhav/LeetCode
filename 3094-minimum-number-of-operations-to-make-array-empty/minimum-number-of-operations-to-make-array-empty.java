class Solution {
    public int minOperations(int[] nums) {
        Map<Integer, Integer> freqCounter = new HashMap<>();
        int operations = 0;
        for(int i=0; i<nums.length; i++) {
            freqCounter.put(nums[i], freqCounter.getOrDefault(nums[i], 0) + 1);
        }
        for(Map.Entry<Integer, Integer> entry: freqCounter.entrySet()) {
            int val = entry.getValue();
            if(val == 1) return -1;
            operations += Math.ceilDiv(val, 3);
        }
        return operations;
    }
}