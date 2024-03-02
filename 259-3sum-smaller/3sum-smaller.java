class Solution {
    private int twoSumSmaller(int[] nums, int index, int target) {
        int sum = 0;
        int l = index, r = nums.length - 1;
        while(l < r) {
            if(nums[l] + nums[r] < target) {
                sum += r - l;
                l++;
            } else {
                r--;
            }
        }
        return sum;
    }

    public int threeSumSmaller(int[] nums, int target) {
        Arrays.sort(nums);
        int ans = 0;
        for(int i=0; i<nums.length - 2; i++) {
            ans += twoSumSmaller(nums, i+1, target - nums[i]);
        }
        return ans;
        
    }
}