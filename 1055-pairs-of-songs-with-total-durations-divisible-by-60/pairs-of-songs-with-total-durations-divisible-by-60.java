class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int n = time.length, noOfPair = 0;
        int[] freqCount = new int[60];
        for(int i=0; i<n; i++) {
            int remainder = time[i] % 60;
            if (remainder == 0) {
                noOfPair += freqCount[0];
            } else noOfPair += freqCount[60 - remainder];
            freqCount[remainder]++;
        }
        return noOfPair;
    }
}