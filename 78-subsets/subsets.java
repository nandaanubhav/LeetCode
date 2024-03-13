class Solution {
    private int[] nums;
    private List<List<Integer>> ans;
    private void backtrack(int index, LinkedList<Integer> currList) {
        ans.add(new ArrayList<Integer>(currList));
        if(currList.size() == nums.length) return;
        for(int i=index; i<nums.length; i++) {
            currList.add(nums[i]);
            backtrack(i+1, currList);
            currList.removeLast();
        }
    }
    public List<List<Integer>> subsets(int[] nums) {
        this.nums = nums;
        ans = new ArrayList<>();
        backtrack(0, new LinkedList<Integer>());
        return ans;
    }
}