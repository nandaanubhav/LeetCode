class Solution {
    public int minimumSwaps(int[] nums) {
        int n = nums.length;
        if(n == 1) return 0;
        int maxElement = nums[0], maxElementPos = 0, minElement = nums[n-1] , minElementPos = n-1;
        for(int i=0; i<n; i++) {
            if(nums[i] >= maxElement) {
                maxElement = nums[i];
                maxElementPos = i;
            }
        }
        for(int i=n-1; i>=0; i--) {
            if(nums[i] <= minElement) {
                minElement = nums[i];
                minElementPos = i;
            }
        }
        // System.out.println("maxElementPos " + maxElementPos);
        // System.out.println("minElementPos " + minElementPos);
        int maxElementSwaps = n - maxElementPos - 1;
        int minElementSwaps = minElementPos;
        if (minElementPos > maxElementPos) return maxElementSwaps + minElementSwaps - 1;
        else return maxElementSwaps + minElementSwaps;
    }
}