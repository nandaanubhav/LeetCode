class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<String> numbers = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        for(int i=1; i<=n; i++) {
            numbers.add(String.valueOf(i));
        }
        Collections.sort(numbers);
        numbers.stream().mapToInt(i -> Integer.valueOf(i)).forEach(i -> ans.add(i));
        return ans;
    }
}