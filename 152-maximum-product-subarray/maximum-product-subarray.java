class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        if(n == 0) return 0;
        int minProduct = nums[0];
        int maxProduct = nums[0];
        int result = maxProduct;
        for(int i=1; i<n; i++) {
            int tempMax = Math.max(nums[i], Math.max(maxProduct * nums[i], minProduct * nums[i]));
            minProduct = Math.min(nums[i], Math.min(maxProduct * nums[i], minProduct * nums[i]));
            maxProduct = tempMax;
            result = Math.max(maxProduct, result);
        }
        return result;
    }
}