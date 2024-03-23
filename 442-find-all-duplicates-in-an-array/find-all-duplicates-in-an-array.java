class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        for(int i=0; i<nums.length; i++) {
            int num = nums[i];
            if(nums[Math.abs(num) - 1] < 0) {
                ans.add(Math.abs(num));
            }
            nums[Math.abs(num) - 1] *= -1;
        }
        return ans;
    }
}