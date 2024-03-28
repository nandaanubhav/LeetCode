class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) set.add(num);
        int largetSeq = 0;
        for (int i=0; i<nums.length; i++) {
            int num = nums[i];
            if (!set.contains(num - 1)) {
                int j = num + 1;
                while(set.contains(j)) {
                    j++;
                }
                largetSeq = Math.max(largetSeq, j - num);
            }
        }
        return largetSeq;
    }
}