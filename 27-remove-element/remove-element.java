class Solution {
    public int removeElement(int[] nums, int val) {
        int nonValIndex = 0;
        for(int i=0; i<nums.length; i++) {
            if(nums[i] != val) {
                if(i != nonValIndex) {
                    nums[nonValIndex] = nums[i];
                    nums[i] = val;
                }
                nonValIndex++;
            }
        }
        return nonValIndex;
    }
}