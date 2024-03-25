class Solution {
    public int removeDuplicates(int[] nums) {
        int sortedArrayIndex = 1, dupCount = 0;
        for(int i=1; i<nums.length; i++) {
            if(nums[i] == nums[i-1]) dupCount++;
            else dupCount = 0;
            if(dupCount <= 1) {
                nums[sortedArrayIndex++] = nums[i];
            }
        }
        return sortedArrayIndex;
    }
}