class Solution {
    public int minOperations(String s) {
        int n = s.length(), oddZeroCount = 0, evenZeroCount = 0;
        for(int i=0; i<n; i++) {
            if(i % 2 == 0 && s.charAt(i) == '0') evenZeroCount++;
            else if (i % 2 != 0 && s.charAt(i) == '0') oddZeroCount++; 
        }
        int totalOddCount = n / 2;
        int totalEvenCount = Math.ceilDiv(n, 2);
        return Math.min(evenZeroCount + totalOddCount - oddZeroCount, totalEvenCount - evenZeroCount + oddZeroCount);
    }
}