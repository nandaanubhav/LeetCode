class Solution {
    public int minimumSwaps(int[] nums) {
        int maxElement = Integer.MIN_VALUE, maxElementIndex = 0;
        int minElement = Integer.MAX_VALUE, minElementIndex = 0;
        for(int i=0; i<nums.length; i++) {
            if(nums[i] >= maxElement) {
                maxElement = nums[i];
                maxElementIndex = i;
            }
            if(nums[i] < minElement) {
                minElement = nums[i];
                minElementIndex = i;
            }
        }
        int leftSwaps = minElementIndex;
        int rightSwaps = nums.length - maxElementIndex - 1;
        return minElementIndex > maxElementIndex ? rightSwaps + leftSwaps - 1 : rightSwaps + leftSwaps;
    }
}