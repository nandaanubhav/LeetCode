class Solution {
    private boolean canEatAll(int[] piles, int s, int h) {
        int hoursSpent = 0;
        for(int i : piles) {
            hoursSpent += Math.ceil((double) i / s);
        }
        return hoursSpent <= h;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int left = 0, right = Arrays.stream(piles).max().getAsInt();
        while(left < right) {
            int mid = left + (right - left)/2;
            if(canEatAll(piles, mid, h)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}