class Solution {
    public int openLock(String[] deadends, String target) {
        Queue<Pair<String, Integer>> queue = new LinkedList<>();
        Map<Character, Character> nextSlot = Map.of(
            '0', '1', 
            '1', '2', 
            '2', '3', 
            '3', '4', 
            '4', '5', 
            '5', '6', 
            '6', '7', 
            '7', '8', 
            '8', '9', 
            '9', '0'
        );
        // Map the previous slot digit for each current slot digit.
        Map<Character, Character> prevSlot = Map.of(
            '0', '9', 
            '1', '0', 
            '2', '1', 
            '3', '2', 
            '4', '3', 
            '5', '4', 
            '6', '5', 
            '7', '6', 
            '8', '7', 
            '9', '8'
        );
        Set<String> visited = new HashSet<>(Arrays.asList(deadends));
        if (visited.contains("0000")) {
            return -1;
        }
        queue.add(new Pair<>("0000", 0));
        visited.add("0000");
        while(!queue.isEmpty()) {
            Pair<String, Integer> node = queue.poll();
            String key = node.getKey();
            if(key.equals(target)) return node.getValue();
            for(int i=0; i<4; i++) {
                StringBuilder newKey = new StringBuilder(key);
                newKey.setCharAt(i, nextSlot.get(key.charAt(i)));
                if(!visited.contains(newKey.toString())) {
                    visited.add(newKey.toString());
                    queue.add(new Pair<>(newKey.toString(), node.getValue() + 1));
                }
                newKey.setCharAt(i, prevSlot.get(key.charAt(i)));
                if(!visited.contains(newKey.toString())) {
                    visited.add(newKey.toString());
                    queue.add(new Pair<>(newKey.toString(), node.getValue() + 1));
                }
            }
        }
        return -1;
    }
}