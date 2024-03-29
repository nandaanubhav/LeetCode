

import static java.lang.Integer.numberOfLeadingZeros;

class Solution {
    public int singleNonDuplicate(int[] nums) {
        int l = 0, r = nums.length - 1;
        while(l < r) {
            int m = l + (r - l)/2;
            if(m % 2 != 0) m--;
            if(nums[m] != nums[m + 1]) {
                r = m;
            } else {
                l = m + 2;
            }
        }
        return nums[l];
        
    }
}