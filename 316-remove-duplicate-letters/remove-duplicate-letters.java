class Solution {
    public String removeDuplicateLetters(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        Set<Character> charUsed = new HashSet<>();
        Stack<Character> stack = new Stack<>();
        for(char c: s.toCharArray()) map.put(c, map.getOrDefault(c, 0) + 1);
        for(char c: s.toCharArray()) {
            map.put(c, map.get(c) - 1);
            if(charUsed.contains(c)) {
                continue;
            };
            while(!stack.isEmpty() && c < stack.peek() && map.get(stack.peek()) > 0) {
                char toRemove = stack.pop();
                // map.put(toRemove, map.get(toRemove) - 1);
                charUsed.remove(toRemove);
                // System.out.println("removing " + toRemove);
            }
            stack.add(c);
            charUsed.add(c);
        }
        StringBuilder ans = new StringBuilder();
        while(!stack.isEmpty()) ans.append(stack.pop());
        return ans.reverse().toString();
    }
}