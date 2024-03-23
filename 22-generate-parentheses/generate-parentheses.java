class Solution {
    List<String> ans;
    private void backtrack(int n, StringBuilder currSeq, int leftCount, int rightCount) {
        if(currSeq.length() == 2 * n) {
            ans.add(currSeq.toString());
        }
        if(leftCount < n) {
            currSeq.append('(');
            backtrack(n, currSeq, leftCount + 1, rightCount);
            currSeq.deleteCharAt(currSeq.length() - 1);
        }
        if(rightCount < leftCount) {
            currSeq.append(')');
            backtrack(n, currSeq, leftCount, rightCount + 1);
            currSeq.deleteCharAt(currSeq.length() - 1);
        }
    }
    public List<String> generateParenthesis(int n) {
        ans = new ArrayList<>();
        backtrack(n, new StringBuilder(), 0, 0);
        return ans;
    }
}