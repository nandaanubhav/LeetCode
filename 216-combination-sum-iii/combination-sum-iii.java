class Solution {

        private void backtrack(int k, int target, int index, int currentSum, LinkedList<Integer> currentList, List<List<Integer>> ans) {
        if(currentSum == target && currentList.size() == k) {
            ans.add(new ArrayList<Integer>(currentList));
            return;
        }
        for(int i=index; i<10; i++) {
            if(currentSum + i > target || currentList.size() == k) {
                continue;
            }
            currentSum += i;
            currentList.add(i);
            backtrack(k, target, i+1, currentSum, currentList, ans);
            currentSum -= i;
            currentList.removeLast();
        }
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(k, n, 1, 0, new LinkedList<>(), ans);
        return ans;
        
    }
}