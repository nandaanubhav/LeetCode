class Solution {
    public int maximumCount(int[] nums) {
        int positiveCount = 0, negativeCount = 0;
        for(int i=0; i<nums.length; i++) {
            if(nums[i] < 0) {
                negativeCount++;
            }
            if(nums[i] > 0) {
                positiveCount = nums.length - i;
                break;
            }
        }
        return Math.max(negativeCount, positiveCount);
    }
}