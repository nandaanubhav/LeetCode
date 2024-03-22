class Solution {
    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        int aliceSum = 0, bobSum = 0;
        Set<Integer> aliceCandies = new HashSet<>();
        for(int i=0; i<aliceSizes.length; i++) {
            aliceSum += aliceSizes[i];
            aliceCandies.add(aliceSizes[i]);
        }
        for(int i=0; i<bobSizes.length; i++) bobSum += bobSizes[i];
        int delta = (bobSum - aliceSum)/2;
        for(int i=0; i<bobSizes.length; i++) {
            if(aliceCandies.contains(bobSizes[i] - delta)) {
                return new int[]{bobSizes[i] - delta, bobSizes[i]};
            }
        }
        return new int[]{0,0};
    }
}