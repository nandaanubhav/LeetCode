class Solution {
    List<String> ans;
    private void backtrack(int leftCount, int rightCount, StringBuilder s, int size) {
        if(s.length() == size) {
            ans.add(s.toString());
            return;
        }

        if(rightCount > leftCount) return;

        if(leftCount < size/2) {
            s.append('(');
            backtrack(leftCount + 1, rightCount, s, size);
            s.deleteCharAt(s.length() - 1);
        }
        if(rightCount <= leftCount) {
            s.append(')');
            backtrack(leftCount, rightCount + 1, s, size);
            s.deleteCharAt(s.length() - 1);
        }
    }
    public List<String> generateParenthesis(int n) {
        ans = new ArrayList<>();
        backtrack(0, 0, new StringBuilder(), 2 *n);
        return ans;
    }
}