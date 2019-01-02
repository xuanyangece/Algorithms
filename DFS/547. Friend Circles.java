class Solution {
    public int findCircleNum(int[][] M) {
        if (M == null) return 0;
        
        int n = M.length, ans = 0;
        boolean[] visited = new boolean[n];
        
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(M, i, n, visited);
                ans++;
            }
        }
        
        return ans;
    }
    
    private void dfs(int[][] M, int i, int n, boolean[] visited) {
        for (int j = 0; j < n; j++) {
            if (M[i][j] == 1 && !visited[j]) {
                visited[j] = true;
                dfs(M, j, n, visited);
            }
        }
    }
}
