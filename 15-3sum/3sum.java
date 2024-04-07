class Solution {
    List<List<Integer>> ans;
    private void twoSum(int[] nums, int index) {
        int left = index + 1, right = nums.length - 1;
        while(left < right) {
            int sum = nums[index] + nums[left] + nums[right];
            if(sum == 0) {
                ans.add(Arrays.asList(nums[index], nums[left++], nums[right--]));
                while(left < right && nums[left] == nums[left - 1]) ++left;
            } else if (sum > 0) {
                right--;
            } else if(sum < 0) left++;
        }
    }
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        ans = new ArrayList<>();
        for(int i = 0; i<nums.length && nums[i] <= 0; i++) {
            if(i == 0 || nums[i] != nums[i - 1]) {
                twoSum(nums, i);
            }
        }
        return ans;
    }
}