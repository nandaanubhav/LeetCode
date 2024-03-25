class Solution {
    private void backtrack(int index, List<List<Integer>> ans, LinkedList<Integer> seq, int[] nums) {
        ans.add(new ArrayList<Integer>(seq));
        if(seq.size() == nums.length) return;
        for(int i=index; i<nums.length;i++) {
            if(i != index && nums[i] == nums[i-1]) continue;
            seq.add(nums[i]);
            backtrack(i + 1, ans, seq, nums);
            seq.removeLast();
        }
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(0, ans, new LinkedList<>(), nums);
        return ans;
    }
}