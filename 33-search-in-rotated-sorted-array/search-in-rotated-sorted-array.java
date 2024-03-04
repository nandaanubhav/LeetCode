class Solution {
    private int binarySearch(int[] nums, int left, int right, int target) {
        int l = left, r = right;
        while(l <= r) {
            int m = l + (r - l)/2;
            if(nums[m] == target) return m;
            else if (nums[m] > target) r = m - 1;
            else l = m + 1;
        }
        return -1;
    }

    public int search(int[] nums, int target) {
        int l = 0, n = nums.length, r = n -1;
        if(n == 1) return nums[0] == target ? 0 : -1;
        while (l <= r) {
            int m = l + (r - l)/2;
            if(nums[m] > nums[n - 1]) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        int ans = binarySearch(nums, l, n - 1, target);
        if(ans != -1) return ans;

        return binarySearch(nums, 0, l - 1, target);
    }
}