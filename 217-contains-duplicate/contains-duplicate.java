class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> numbers = new HashSet<>();
        for(int i : nums) {
            if(numbers.contains(i)) return true;
            numbers.add(i);
        }
        return false;
    }
}