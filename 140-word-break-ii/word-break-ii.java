class Solution {
    List<String> ans;
    private void backtrack(String s, int index, StringBuilder currSeq, Set<String> wordDict) {
        if(index == s.length()) {
            ans.add(currSeq.toString().trim());
            return;
        }

        StringBuilder sb = new StringBuilder();
        for(int i=index; i<s.length(); i++) {
            sb.append(s.charAt(i));
            if(wordDict.contains(sb.toString())) {
                currSeq.append(sb).append(" ");
                backtrack(s, i+1, currSeq, wordDict);
                currSeq.delete(currSeq.length() - sb.length() - 1, currSeq.length());
            }
        }

    }
    public List<String> wordBreak(String s, List<String> wordDict) {
        ans = new ArrayList<>();
        Set<String> wordDictSet = new HashSet<>(wordDict);
        backtrack(s, 0, new StringBuilder(), wordDictSet);
        return ans;
    }
}