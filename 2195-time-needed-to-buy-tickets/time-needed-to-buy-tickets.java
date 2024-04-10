class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int maxTime = tickets[k];
        int timeRequired = 0;
        for(int i=0; i<tickets.length; i++) {
            if(i <= k) {
                timeRequired += Math.min(tickets[i], maxTime);
            } else {
                timeRequired += Math.min(tickets[i], maxTime - 1);
            }
        }
        return timeRequired;
    }
}