class Solution {
    List<List<Integer>> ans;
    private void twoSum(int[] nums, int index) {
        HashSet<Integer> values = new HashSet<>();
        for(int i=index+1; i<nums.length; i++) {
            int complement = -nums[index] - nums[i];
            if(values.contains(complement)) {
                ans.add(Arrays.asList(nums[index], nums[i], complement));
                while (i + 1 < nums.length && nums[i] == nums[i + 1]) {
                    ++i;
                }
            }
            values.add(nums[i]);
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