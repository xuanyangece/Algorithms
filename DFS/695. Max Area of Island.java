class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) max = Math.max(maxArea(grid, i, j), max);
            }
        }
        
        return max;
    }
    
    private int maxArea(int[][] grid, int i, int j) {
        if (i >= 0 && i < grid.length && j >= 0 && j < grid[0].length && grid[i][j] == 1) {
            grid[i][j] = 0;
            return 1 + maxArea(grid, i - 1, j) + maxArea(grid, i + 1, j) + maxArea(grid, i, j - 1) + maxArea(grid, i, j + 1);
        }
        
        return 0;
    }
}
