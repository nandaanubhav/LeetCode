class NumArray {
    int[] prefixSum;
    public NumArray(int[] nums) {
        int n = nums.length;
        prefixSum = new int[n];
        prefixSum[0] = nums[0];
        for(int i=1; i<n; i++) prefixSum[i] = prefixSum[i-1] + nums[i];

    }
    
    public int sumRange(int left, int right) {
        return prefixSum[right] - (left == 0 ? 0 : prefixSum[left - 1]);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */