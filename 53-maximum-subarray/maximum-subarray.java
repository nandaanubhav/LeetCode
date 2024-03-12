class Solution {
    public int maxSubArray(int[] nums) {
        int currntSum = nums[0], maxSum = nums[0];
        for(int i=1; i<nums.length; i++) {
            currntSum = Math.max(nums[i], currntSum + nums[i]);
            maxSum = Math.max(maxSum, currntSum);
        }
        return maxSum;
    }
}