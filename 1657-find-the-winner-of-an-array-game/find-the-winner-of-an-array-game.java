class Solution {
    public int getWinner(int[] arr, int k) {
        int maxElement = Integer.MIN_VALUE;
        for(int el : arr) {
            maxElement = Math.max(maxElement, el);
        }
        if(k > arr.length) return maxElement;
        int consecWins = 0;
        int currIndex = 1;
        int curr = arr[0];
        while(consecWins < k) {
            int opp = arr[currIndex];
            if(curr > opp) {
                consecWins++;
            } else {
                consecWins = 1;
                curr = opp;
            }
            if(maxElement == curr) break;
            currIndex++;
        }
        return curr;
    }
}