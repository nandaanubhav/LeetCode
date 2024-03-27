class Solution {
    public int carFleet(int target, int[] p, int[] s) {
        int[][] combo = new int[p.length][2]; 
        for(int i=0;i<p.length;i++){
            combo[i][0]=p[i];
            combo[i][1]=s[i];
        } 
        Arrays.sort(combo, Comparator.comparingInt(o -> o[0]));
        int count = 0;
        double prev = 0.0;
        for(int i=combo.length-1;i>=0;i--){
            double curr = (double) (target-combo[i][0])/combo[i][1];
            if(curr > prev) {
                prev = curr;
                count++;
            }
        }
        return count;
    }
}