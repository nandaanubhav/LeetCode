class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        int n = nums.length, maxFreq = 0;
        int[] freq = new int[n+1];
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0; i<n; i++) {
            freq[nums[i]]++;
            if (maxFreq >= freq[nums[i]]) {
                // System.out.println("Adding to previous list");
                ans.get(freq[nums[i]] - 1).add(nums[i]);
            } else {
                // System.out.println("Adding to new List");
                maxFreq = Math.max(maxFreq, freq[nums[i]]);
                List<Integer> temp = new ArrayList<>();
                temp.add(nums[i]);
                ans.add(temp);
            }
        }
        return ans;
    }
}