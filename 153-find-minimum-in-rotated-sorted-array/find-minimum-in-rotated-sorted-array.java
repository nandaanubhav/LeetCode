class Solution {
    public int findMin(int[] nums) {
        int l = 0, r = nums.length - 1, n = nums.length;
        if(n == 1) return nums[0];
        if(nums[r] > nums[0]) return nums[0];
        while(l <= r) {
            int m = l + (r - l)/2;
            // System.out.println("Setting m to " + m);
            if ((m - 1) >= 0  && (m + 1) < n) {
                if(nums[m-1] > nums[m] && nums[m+1] > nums[m]) {
                    return nums[m];
                } else if (nums[m] > nums[r]) {
                    l = m+1;
                } else r = m-1;
            } else {
                // System.out.print("l " + l + " r " + r);
                return nums[l] < nums[r] ? nums[l] : nums[r];
            }
        }
        return Integer.MAX_VALUE;
    }
}