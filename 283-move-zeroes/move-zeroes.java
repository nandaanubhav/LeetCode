class Solution {
    public void moveZeroes(int[] nums) {
        int nonZeroIndex = 0, n = nums.length;
        for(int i=0; i<n; i++) {
            if(nums[i] != 0) {
                if(i != nonZeroIndex) {
                    nums[nonZeroIndex] = nums[i];
                    nums[i] = 0;
                }
                nonZeroIndex++;
            }
        }
    }
}