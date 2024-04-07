class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] prefixProduct = new int[n];
        int[] suffixProduct = new int[n];
        prefixProduct[0] = 1;
        suffixProduct[n - 1] = 1;
        for(int i=1, j=n-2; i<n && j>=0; i++, j--) {
            prefixProduct[i] = prefixProduct[i - 1] * nums[i - 1];
            suffixProduct[j] = suffixProduct[j + 1] * nums[j + 1];
        }
        int[] result = new int[n];
        for(int i=0; i<n; i++) {
            result[i] = prefixProduct[i] * suffixProduct[i];
        }
        return result;
    }
}