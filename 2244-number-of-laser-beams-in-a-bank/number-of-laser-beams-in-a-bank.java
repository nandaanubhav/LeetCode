class Solution {
    public int numberOfBeams(String[] bank) {
        int n = bank.length, prevLaserCount = 0, totalBeams = 0;
        for(int i=0; i<n; i++) {
            String s = bank[i];
            int laserCount = 0;
            for(int j=0; j<s.length(); j++) {
                if(s.charAt(j) == '1') laserCount++;
            }
            if(laserCount > 0) {
                totalBeams += (laserCount * prevLaserCount);
                prevLaserCount = laserCount;
            }
        }
        return totalBeams;
    }
}