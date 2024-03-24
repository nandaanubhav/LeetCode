class Solution {
    public int longestSubarray(int[] nums) {
        int l = 0, r = 0, n = nums.length, longestSubarray =  0, zeroIndex = -1;
        while(r < n) {
            if(nums[r] == 0) {
                if(zeroIndex < 0) {
                    zeroIndex = r;
                } else {
                    l = zeroIndex + 1;
                    zeroIndex = r;
                }
            }
            // System.out.println("L: " + l + " R: " + r);
            longestSubarray = Math.max(longestSubarray, r - l + 1);
            r++;
        }
        return longestSubarray - 1;
    }
}