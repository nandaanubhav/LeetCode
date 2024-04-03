class Solution {
    private boolean canReachAll(int[] houses, int[] heaters, int radius) {
        int houseIndex = 0;
        for(int heater : heaters) {
            int leftRange = heater - radius, rightRange = heater + radius;
            while(houseIndex < houses.length && houses[houseIndex] >= leftRange && houses[houseIndex] <= rightRange) {
                houseIndex++;
            }
        }
        return houseIndex >= houses.length;
    }
    private int binarySearch(int[] houses, int[] heaters) {
        int left = 0, right = Math.max(houses[houses.length - 1], heaters[heaters.length - 1]);
        int minRadius = 0;
        while(left < right) {
            int mid = left + (right - left)/2;
            if(canReachAll(houses, heaters, mid)) {
                minRadius = mid;
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return minRadius;

    }
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        return binarySearch(houses, heaters);
    }


}