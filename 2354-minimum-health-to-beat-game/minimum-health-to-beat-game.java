

import static java.util.Collections.max;

class Solution {
    public long minimumHealth(int[] damage, int armor) {
        long totalDamage = 0;
        int maxDamage = 0;
        for(int currGameDamage : damage) {
            totalDamage += currGameDamage;
            maxDamage = Math.max(currGameDamage, maxDamage);
        }
        return totalDamage - Math.min(maxDamage, armor) + 1;
    }
}