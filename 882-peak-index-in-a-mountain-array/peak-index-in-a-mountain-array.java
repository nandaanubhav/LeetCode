class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int l = 0, r = arr.length - 1;
        while(l <= r) {
            int m = l + (r - l)/2;
            // System.out.print("Mid " + m);
            if(m == 0) l = m + 1;
            else if(m == arr.length - 1) r = m - 1;
            else if(arr[m] > arr[m-1] && arr[m] > arr[m + 1]) return m;
            else if (arr[m] > arr[m-1]) l = m + 1;
            else r = m - 1;
        }
        return -1;
    }
}