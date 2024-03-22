class Solution {
    public int[] applyOperations(int[] nums) {
        int n = nums.length;
        for(int i=0; i<n-1; i++) {
            if(nums[i] == nums[i+1]) {
                nums[i] = 2 * nums[i];
                nums[i+1] = 0;
            }
        }
        // for(int i=0; i<n; i++) System.out.print(nums[i] + ", ");
        for(int left = 0; left<n; left++) {
            if(nums[left] == 0) {
                // System.out.println("Left : " + left);
                int right = left + 1;
                while(right < n && nums[right] == 0) {
                    right++;
                }
                if(right >= n) break; 
                // System.out.println("Right : " + right);
                int temp = nums[right];
                nums[right] = nums[left];
                nums[left] = temp;
            }
        }
        return nums;
    }
}