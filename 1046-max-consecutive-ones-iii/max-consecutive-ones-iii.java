class Solution {
    public int longestOnes(int[] nums, int k) {
        int l = 0, r = 0, longestOnes = 0;
        Queue<Integer> queue = new LinkedList<>();
        while(r < nums.length) {
            if(nums[r] == 0) {
                queue.add(r);
                if(queue.size() > k) l = queue.poll() + 1;
            }
            longestOnes = Math.max(longestOnes, r - l + 1);
            r++;
        }
        return longestOnes;
    }
}