class Solution {
    class DSU {
        int count;
        int[] size;
        int[] id;
        
        public DSU(int n) {
            count = n;
            size = new int[n];
            id = new int[n];
            
            for (int i = 0; i < n; i++) {
                size[i] = 1;
                id[i] = i;
            }
        }
        
        public int find(int x) {
            if (id[x] != x) {
                id[x] = find(id[x]);
            }
            
            return id[x];
        }
        
        public void union(int x, int y) {
            int rootx = find(x);
            int rooty = find(y);
            
            if (rootx == rooty) return;
            
            if (size[rootx] < size[rooty]) {
                id[rootx] = rooty;
                size[rooty] += size[rootx];
            } else {
                id[rooty] = rootx;
                size[rootx] += size[rooty];
            }
            
            count--;
        }
    }
    public int removeStones(int[][] stones) {
        DSU dsu = new DSU(stones.length);
        
        for (int i = 0; i < stones.length; i++) {
            for (int j = i + 1; j < stones.length; j++) {
                if (stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]) {
                    dsu.union(i, j);
                }
            }
        }
        
        return stones.length - dsu.count;
    }
}
