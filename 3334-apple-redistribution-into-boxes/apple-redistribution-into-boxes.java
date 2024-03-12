class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        Arrays.sort(capacity);
        int currApplePack = 0, boxCount = 0;
        for(int i=capacity.length - 1; i>=0; i--) {
            boxCount++;
            while(currApplePack < apple.length && apple[currApplePack] <= capacity[i]) {
                // System.out.println("Putting " + apple[currApplePack] + " to " + capacity[i]);
                capacity[i] -= apple[currApplePack];
                currApplePack++;
            }
            if(capacity[i] > 0 && currApplePack < apple.length) {
                apple[currApplePack] -= capacity[i];
                capacity[i] = 0;
            }
            if(currApplePack == apple.length) return boxCount;
        }
        return boxCount;
    }
}