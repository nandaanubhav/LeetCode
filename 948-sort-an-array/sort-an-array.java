class Solution {
    private void merge(int[] nums, int l, int m, int r) {
        int l1 = m - l + 1, l2 = r - m;
        int[] A1 = new int[l1];
        int[] A2 = new int[l2];
        for(int i=0; i<l1; i++) A1[i] = nums[l+i];
        for(int i=0; i<l2; i++) A2[i] = nums[m+1+i];
        int curr = l, i = 0, j = 0;
        while(i < l1 && j < l2) {
            if(A1[i] <= A2[j]) {
                nums[curr++] = A1[i++];
            } else nums[curr++] = A2[j++];
        }
        while(i < l1) {
            nums[curr++] = A1[i++];
        }
        while(j < l2) {
            nums[curr++] = A2[j++];
        }

    }

    private void mergeSort(int[] nums, int l, int r) {
        if(l >= r) return ;
        int m = l + (r - l)/2;
        mergeSort(nums, l, m);
        mergeSort(nums, m + 1, r);
        merge(nums, l, m, r);
    }

    public int[] sortArray(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }
}