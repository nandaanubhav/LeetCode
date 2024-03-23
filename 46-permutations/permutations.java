class Solution {
    List<List<Integer>> ans;
    private void backtrack(int[] nums, LinkedList<Integer> list) {
        if(list.size() == nums.length) {
            System.out.println(list.toString());
            ans.add(new ArrayList<>(list));
            return;
        }

        for(int i=0; i<nums.length; i++) {
            if(list.contains(nums[i])) continue;
            list.add(nums[i]);
            backtrack(nums, list);
            list.removeLast();
        }

    }
    public List<List<Integer>> permute(int[] nums) {
        ans = new ArrayList<>();
        backtrack(nums, new LinkedList<>());
        return ans;
    }
}