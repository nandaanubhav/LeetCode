class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int childSatisfied = 0, childIndex = 0;
        for(int i=0; i<s.length && childIndex < g.length; i++) {
            if(s[i] >= g[childIndex]) {
                childIndex++;
                childSatisfied++;
            }
        }
        return childSatisfied;
    }
}