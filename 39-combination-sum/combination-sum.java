class Solution {
    private void backtrack(int[] candidates, int target, int index, int currentSum, LinkedList<Integer> currentList, List<List<Integer>> ans) {
        if(currentSum == target) {
            System.out.println("Sum Matched: " + currentList.size());
            ans.add(new ArrayList<Integer>(currentList));
            return;
        }
        for(int i=index; i<candidates.length; i++) {
            if(currentSum + candidates[i] > target) {
                continue;
            }
            currentSum += candidates[i];
            currentList.add(candidates[i]);
            backtrack(candidates, target, i, currentSum, currentList, ans);
            currentSum -= candidates[i];
            currentList.removeLast();
        }
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(candidates, target, 0, 0, new LinkedList<Integer>(), ans);
        return ans;
    }
}