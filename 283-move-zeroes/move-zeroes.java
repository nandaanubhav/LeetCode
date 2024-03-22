class Solution {
    public void moveZeroes(int[] nums) {
        int nonZeroIndex = 0, n = nums.length;
        for(int i=0; i<n; i++) {
            if(nums[i] == 0) {
                nonZeroIndex = i + 1;
                while(nonZeroIndex < n && nums[nonZeroIndex] == 0) nonZeroIndex++;
                if(nonZeroIndex >= n) break;
                nums[i] = nums[nonZeroIndex];
                nums[nonZeroIndex] = 0;
            }
        }
    }
}