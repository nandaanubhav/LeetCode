class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> ans = new ArrayList<>();
        for(int i=1; i<=9; i++) {
            String temp = String.valueOf(i);
            for(int j=i+1; j<=9; j++) {
                temp += j;
                int tempNumber = Integer.valueOf(temp);
                if(tempNumber >= low && tempNumber <= high) ans.add(tempNumber);
            }
        }
        ans.sort((a, b) -> Integer.compare(a, b));
        return ans;
    }
}