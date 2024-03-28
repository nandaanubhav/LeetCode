class Solution {
    public int findMaxLength(int[] nums) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int count = 0, maxLen = 0;
        for(int i=0; i<n; i++) {
            count = count + (nums[i] == 1 ? 1 : -1);
            if(map.containsKey(count)) {
                maxLen = Math.max(maxLen, i - map.get(count));
            } else map.put(count, i);
        }
        return maxLen;
    }
}