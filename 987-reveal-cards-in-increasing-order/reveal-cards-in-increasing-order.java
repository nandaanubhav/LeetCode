class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        int n = deck.length;
        Arrays.sort(deck);
        int[] ans = new int[n];
        boolean skip = false;
        int deckIndex = 0, ansIndex = 0;
        while(deckIndex < n) {
            if(ans[ansIndex] == 0) {
                if(!skip) {
                    ans[ansIndex] = deck[deckIndex];
                    deckIndex++;
                }
                skip = !skip;
            }
            ansIndex = (ansIndex + 1) % n;
        }
        return ans;
    }
}