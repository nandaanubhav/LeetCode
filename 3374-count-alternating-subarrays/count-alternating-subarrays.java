class Solution {
    public long countAlternatingSubarrays(int[] nums) {
        int n = nums.length;
        long count = 0, currCount = 1;
        for(int i=1; i<n; i++) {
            if(nums[i] != nums[i-1]) {
                currCount++;
            } else {
                // System.out.println(i + " - " + currCount);
                count += (currCount * (currCount+1))/2;
                currCount = 1;
            }
        }
        count += (currCount * (currCount+1))/2;
        return count;
        
    }
}