class Solution {
    List<int[]> ans;
    private void dfs(int[][] land, int[] currLand, int sr, int sc, int R, int C) {
        if(sr < 0 || sr >= R || sc < 0 || sc >= C || land[sr][sc] == 0) return;
        land[sr][sc] = 0;
        if(currLand[0] + currLand[1] > sr + sc) {
            currLand[0] = sr;
            currLand[1] = sc;
        }
        if(currLand[2] + currLand[3] < sr + sc) {
            currLand[2] = sr;
            currLand[3] = sc;
        }
        dfs(land, currLand, sr + 1, sc, R, C);
        dfs(land, currLand, sr - 1, sc, R, C);
        dfs(land, currLand, sr, sc + 1, R, C);
        dfs(land, currLand, sr, sc - 1, R, C);

    }
    public int[][] findFarmland(int[][] land) {
        ans = new ArrayList<>();
        int R = land.length;
        int C = land[0].length;
        for(int i=0; i<R; i++) {
            for(int j=0; j<C; j++) {
                if(land[i][j] == 1) {
                    int[] currLand = new int[]{i, j, i, j};
                    dfs(land, currLand, i, j, R, C);
                    ans.add(currLand);
                }
            }
        }
        // int[][] result = new int[ans.size()][4];
        // int index = 0;
        // for(int[] array : ans) {
        //     result[index++] = array;
        // }
        // return result;
        return ans.stream().toArray(int[][] :: new);

    }
}