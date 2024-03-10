class TrieNode {
    private TrieNode[] links;
    private final int R = 26;
    private boolean isEnd;

    public TrieNode() {
        links = new TrieNode[R];
    }

    public TrieNode[] getLinks() {
        return links;
    }

    public boolean containsKey(char c) {
        return links[c - 'a'] != null;
    }

    public TrieNode get(char c) {
        return links[c - 'a'];
    }

    public void put(char c, TrieNode node) {
        links[c - 'a'] = node;
    }

    public void setEnd(boolean isEnd) {
        this.isEnd = isEnd;
    }

    public boolean isEnd() {
        return isEnd;
    }  
}
class WordDictionary {
    TrieNode trie;
    public WordDictionary() {
        trie = new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode node = trie;
        for(char c : word.toCharArray()) {
            if(!node.containsKey(c)) {
                node.put(c, new TrieNode());
            }
            node = node.get(c);
        }
        node.setEnd(true);
    }

    private boolean searchWord(String word, TrieNode node) {
        for(int i=0; i<word.length(); i++) {
            char c = word.charAt(i);
            if(c == '.') {
                for(TrieNode temp : node.getLinks()) {
                    if(temp == null) continue;
                    if(searchWord(word.substring(i + 1), temp)) return true;
                }
                return false;
            } else if (node.containsKey(c)) {
                node = node.get(c);
            } else return false;
        }
        return node.isEnd();
    }
    
    public boolean search(String word) {
        return searchWord(word, trie);
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */