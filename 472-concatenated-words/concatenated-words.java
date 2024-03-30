class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        Set<String> dictionary = new HashSet<>(Arrays.asList(words));
        List<String> ans = new ArrayList<>();
        for(String word: words) {
            int length = word.length();
            dictionary.remove(word);
            boolean[] dp = new boolean[length + 1];
            dp[0] = true;
            for(int i=1; i<=length; i++) {
                for(int j=0; !dp[i] && j < i; j++) {
                    // System.out.println("checking for " + word.substring(j, i));
                    dp[i] = dp[j] && dictionary.contains(word.substring(j, i));
                }
            }
            if(dp[length]) ans.add(word);
            dictionary.add(word);
        }
        return ans;
    }
}