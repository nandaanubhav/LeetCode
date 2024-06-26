class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int L = beginWord.length();
        Map<String, List<String>> allComboDict = new HashMap<>();
        for(String word: wordList) {
            for(int i=0; i<L; i++) {
                String newWord = word.substring(0,i) + "*" + word.substring(i+1,L);
                if(!allComboDict.containsKey(newWord)) allComboDict.put(newWord, new ArrayList<>());
                allComboDict.get(newWord).add(word);                
            }
        }
        Queue<Pair<String, Integer>> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.add(new Pair<>(beginWord, 1));
        visited.add(beginWord);
        while(!queue.isEmpty()) {
            Pair<String, Integer> node = queue.remove();
            String word = node.getKey();
            int level = node.getValue();
            for(int i=0; i<L; i++) {
                String newWord = word.substring(0,i) + "*" + word.substring(i+1,L);
                for(String adjacentWord: allComboDict.getOrDefault(newWord, new ArrayList<>())) {
                    if(adjacentWord.equals(endWord)) return level + 1;
                    if(!visited.contains(adjacentWord)) {
                        queue.add(new Pair<>(adjacentWord, level + 1));
                        visited.add(adjacentWord);
                    }
                }
            }
        }
        return 0;
    }
}