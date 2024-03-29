class TrieNode {
    private final int R = 26;
    private TrieNode[] links;
    private boolean isEnd;

    public TrieNode() {
        links = new TrieNode[R];
        isEnd = false;
    }

    public boolean containsKey(char ch) {
        return links[ch - 'a'] != null;
    }

    public TrieNode get(char ch) {
        return links[ch - 'a'];
    }

    public void put(char ch, TrieNode node) {
        links[ch - 'a'] = node;
    }

    public boolean isEnd() {
        return isEnd;
    }

    public void setEnd(boolean isEnd) {
        this.isEnd = isEnd;
    }
}
class Solution {
    TrieNode root;

    private void save(String s) {
        int r = s.length() - 1;
        TrieNode node = root;
        while(r >= 0) {
            char ch = s.charAt(r);
            if(!node.containsKey(ch)) node.put(ch, new TrieNode());
            node = node.get(ch);
            r--;
        }
        node.setEnd(true);;
    }

    private int findLeft(String word, int left, int right) {
        int index = right;
        TrieNode node = root;
        while(index >= left) {
            char ch = word.charAt(index);
            if(!node.containsKey(ch)) return left;
            node = node.get(ch);
            if(node.isEnd()) return index + 1;
            index--;
        }
        return left;
    }

    public int longestValidSubstring(String word, List<String> forbidden) {
        root = new TrieNode();
        for(String s: forbidden) save(s);
        int l = 0, maxLength = 0;
        for(int r = 0; r < word.length(); r++) {
            l = findLeft(word, l, r);
            maxLength = Math.max(maxLength, r - l + 1);
        }
        return maxLength;
    }
}