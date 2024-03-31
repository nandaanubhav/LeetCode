class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        // Arrays.sort(arr);
        // int maxElement = 1;
        // for (int i = 1; i<arr.length; i++) {
        //     if(arr[i] > maxElement) {
        //         maxElement++;
        //     }
        // }
        // return maxElement;
        int n = arr.length;
        int[] counts = new int[n+1];
        for(int i: arr) counts[Math.min(i, n)]++;
        int ans = 1;
        for(int i=2; i<=n; i++) {
            ans = Math.min(ans + counts[i], i);
        }
        return ans;
    }
}