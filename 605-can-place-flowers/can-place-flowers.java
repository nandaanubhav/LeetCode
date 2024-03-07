class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int maxFlowers = 0;
        for(int i=0; i<flowerbed.length; i++) {
            if (flowerbed[i] == 0) {
                boolean left = (i == 0) || flowerbed[i - 1] == 0;
                boolean right = (i == flowerbed.length - 1) || flowerbed[i + 1] == 0;
                if(left && right) {
                    flowerbed[i] = 1;
                    maxFlowers++;
                }
            }
        }
        // System.out.print(maxFlowers);
        return maxFlowers >= n;
    }
}