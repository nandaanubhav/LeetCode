class UnionFind {
    int[] parent;
    int[] rank;

    public UnionFind(int size) {
        parent = new int[size];
        for(int i=0; i<size; i++) parent[i] = i;
        rank = new int[size];
    }

    public int find(int x) {
        if(x != parent[x]) parent[x] = find(parent[x]);
        return parent[x];
    }

    public void union(int x, int y) {
        int xSet = find(x);
        int ySet = find(y);

        if(xSet == ySet) return;
        else if (rank[xSet] > rank[ySet]) {
            parent[ySet] = xSet;
        } else if (rank[ySet] > rank[xSet]) {
            parent[xSet] = ySet;
        } else {
            parent[ySet] = xSet;
            rank[xSet]++;
        }
    }
}

class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        UnionFind dsu = new UnionFind(n);
        int noOfComponents = n;
        for(int i=0; i<n; i++) {
            for(int j=i+1; j<n; j++) {
                if(isConnected[i][j] == 1 && dsu.find(i) != dsu.find(j)) {
                    noOfComponents--;
                    dsu.union(i, j);
                }
            }
        }
        return noOfComponents;
    }
}