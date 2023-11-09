class TrieNode {
    Map<Character, TrieNode> children;
    Map<String, Integer> sentences;

    public TrieNode() {
        children = new HashMap<>();
        sentences = new HashMap<>();
    }
}

class AutocompleteSystem {

    TrieNode root;
    TrieNode currNode;
    StringBuilder currSentence;

    public AutocompleteSystem(String[] sentences, int[] times) {
        root = new TrieNode();
        for(int i=0; i<sentences.length; i++) {
            addToTrie(sentences[i], times[i]);
        }
        currSentence = new StringBuilder();
        currNode = root;
    }
    
    public List<String> input(char c) {
        if(c == '#') {
            addToTrie(currSentence.toString(), 1);
            currSentence.setLength(0);
            currNode = root;
            return new ArrayList<String>();
        }

        currSentence.append(c);
        if(!currNode.children.containsKey(c)) {
            currNode = new TrieNode();
            return new ArrayList<String>();
        }

        currNode = currNode.children.get(c);
        List<String> sentences = new ArrayList<>(currNode.sentences.keySet());
        Collections.sort(sentences, (a,b) -> {
            int hotA = currNode.sentences.get(a);
            int hotB = currNode.sentences.get(b);
            if(hotA == hotB) {
                return a.compareTo(b);
            }
            return hotB - hotA;
        });
        List<String> ans = new ArrayList<>();
        for(int i=0; i<Math.min(sentences.size(), 3); i++) ans.add(sentences.get(i));
        return ans;
    }

    private void addToTrie(String sentence, int count) {
        TrieNode node = root;
        for(int i=0; i<sentence.length(); i++) {
            char c = sentence.charAt(i);
            if(!node.children.containsKey(c)) {
                node.children.put(c, new TrieNode());
            }
            node = node.children.get(c);
            node.sentences.put(sentence, node.sentences.getOrDefault(sentence, 0) + count);
        }
    }
}

/**
 * Your AutocompleteSystem object will be instantiated and called as such:
 * AutocompleteSystem obj = new AutocompleteSystem(sentences, times);
 * List<String> param_1 = obj.input(c);
 */