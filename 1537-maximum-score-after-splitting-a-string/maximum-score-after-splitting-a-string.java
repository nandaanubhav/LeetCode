class Solution {
    public int maxScore(String s) {
        int totalZeroCount = 0, totalOneCount = 0;
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) == '0') totalZeroCount++;
            else totalOneCount++;
        }
        int leftZeroCount = 0, leftOneCount = 0, maxScore = 0;
        if(s.charAt(0) == '0') leftZeroCount++;
        else leftOneCount++;
        maxScore = leftZeroCount + (totalOneCount - leftOneCount);
        for(int i=1; i<s.length() - 1; i++) {
            if(s.charAt(i) == '0') leftZeroCount++;
            else leftOneCount++;
            maxScore = Math.max(maxScore, leftZeroCount + (totalOneCount - leftOneCount));
        }
        return maxScore;
    }
}