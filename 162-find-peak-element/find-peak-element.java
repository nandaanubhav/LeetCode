class Solution {
    public int findPeakElement(int[] nums) {
        if(nums.length == 1) return 0;
        int l = 0, r = nums.length - 1;
        while(l <= r) {
            int mid = l + (r - l)/2;
            // System.out.println("Mid" + mid);
            if(mid == nums.length - 1 && nums[mid] > nums[mid - 1]) return mid;
            else if (mid == 0 && nums[mid] > nums[mid + 1]) return mid;
            else if (nums[mid] > nums[mid + 1] && nums[mid] > nums[mid - 1]) return mid;
            else if (nums[mid + 1] > nums[mid]) l = mid + 1;
            else r = mid - 1;
        }
        return -1;
    }
}