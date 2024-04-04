class Solution {
    private int binarySearch(int[] A, int[] B, int k, int aStart, int aEnd, int bStart, int bEnd) {
        if(aStart > aEnd) {
            return B[k - aStart];
        }
        if(bStart > bEnd) return A[k - bStart];

        int aMidIndex = (aStart + aEnd)/2, bMidIndex = (bStart + bEnd)/2;
        int aMidValue = A[aMidIndex] , bMidValue = B[bMidIndex];

        if(k > aMidIndex + bMidIndex ) {
            if(aMidValue > bMidValue) {
                return binarySearch(A, B, k, aStart, aEnd, bMidIndex + 1, bEnd);
            } else {
                return binarySearch(A, B, k, aMidIndex + 1, aEnd, bStart, bEnd);                
            }
        }  else {
            if(aMidValue > bMidValue) {
                return binarySearch(A, B, k, aStart, aMidIndex - 1, bStart, bEnd);
            } else {
                return binarySearch(A, B, k, aStart, aEnd, bStart, bMidIndex - 1);
            }
        }
    }
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int nA = nums1.length , nB = nums2.length;
        int n = nA + nB;
        if(n % 2 == 1) {
            return binarySearch(nums1, nums2, n/2, 0, nA - 1, 0, nB - 1);
        } else {
            return (double) (binarySearch(nums1, nums2, n/2, 0, nA - 1, 0, nB - 1) + binarySearch(nums1, nums2, n/2 - 1, 0, nA - 1, 0, nB - 1)) / 2;

        }
    }
}