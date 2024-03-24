class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        Arrays.sort(arr);
        int maxElement = 1;
        for (int i = 1; i<arr.length; i++) {
            if(arr[i] > maxElement) {
                maxElement++;
            }
        }
        return maxElement;
    }
}