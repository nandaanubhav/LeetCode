class Solution {

    private void backtracking(List<String> ans, Map<Character, String> possibleCharList, String s, StringBuilder currentString, int index) {
        if(index == s.length()) {
            ans.add(currentString.toString());
            return;
        }

        String possibleChars = possibleCharList.get(s.charAt(index));
        for(char c : possibleChars.toCharArray()) {
            currentString.append(c);
            backtracking(ans, possibleCharList, s, currentString, index + 1);
            currentString.deleteCharAt(currentString.length() - 1);
        }
    }

    public List<String> letterCombinations(String digits) {
        Map<Character, String> possibleCharList = new HashMap<>();
        List<String> ans = new ArrayList<>();
        possibleCharList.put('2', new String("abc"));
        possibleCharList.put('3', new String("def"));
        possibleCharList.put('4', new String("ghi"));
        possibleCharList.put('5', new String("jkl"));
        possibleCharList.put('6', new String("mno"));
        possibleCharList.put('7', new String("pqrs"));
        possibleCharList.put('8', new String("tuv"));
        possibleCharList.put('9', new String("wxyz"));
        if(digits.length() == 0) return ans;
        backtracking(ans, possibleCharList, digits, new StringBuilder(), 0);
        return ans;

    }
}