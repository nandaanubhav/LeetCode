class Solution {
    List<List<Integer>> result;
    public void findCompliment(int[] nums, int index) {
        int l = index + 1, r = nums.length - 1;
        while(l < r) {
            int sum = nums[index] + nums[l] + nums[r];
            if(sum == 0) {
                result.add(Arrays.asList(nums[index], nums[l++], nums[r--]));
                while(l < r && nums[l] == nums[l - 1]) ++l;
            } else if (sum > 0) {
                r--;
            } else {
                l++;
            }
        }
    }

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        result = new ArrayList<>();
        for(int i=0; i<nums.length && nums[i] <= 0; i++) {
            if (i == 0 || nums[i] != nums[i-1])
                findCompliment(nums, i);
        }
        return result;
    }
}