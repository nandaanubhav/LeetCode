class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> ans = new ArrayList<>();
        if(nums.length == 0) return ans; 
        int rangeStart = nums[0], rangeEnd = nums[0];
        for(int i=1; i<nums.length;i++) {
            if(nums[i] == nums[i-1] + 1) {
                rangeEnd = nums[i];
            } else {
                if(rangeStart == rangeEnd) {
                    ans.add(String.valueOf(rangeStart));
                } else {
                    ans.add(rangeStart + "->" + rangeEnd);
                }
                rangeStart = nums[i];
                rangeEnd = nums[i];
            }
        }
        if(rangeStart == rangeEnd) {
            ans.add(String.valueOf(rangeStart));
        } else {
            ans.add(rangeStart + "->" + rangeEnd);
        }
        return ans;
    }
}