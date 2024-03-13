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
            if(i != index && candidates[i] == candidates[i-1]) continue;
            currentSum += candidates[i];
            currentList.add(candidates[i]);
            backtrack(candidates, target, i+1, currentSum, currentList, ans);
            currentSum -= candidates[i];
            currentList.removeLast();
        }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(candidates, target, 0, 0, new LinkedList<Integer>(), ans);
        return ans;

    }
}