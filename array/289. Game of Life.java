class Solution {
    public void gameOfLife(int[][] board) {
        if (board == null || board.length == 0) return;
        
        int n = board.length;
        int m = board[0].length;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int lives = 0;
                for (int x = Math.max(0, i - 1); x < Math.min(n, i + 2); x++) {
                    for (int y = Math.max(0, j - 1); y < Math.min(m, j + 2); y++) {
                        lives += board[x][y] & 0b1;
                    }
                }
                if (lives == 3 || lives - board[i][j] == 3) board[i][j] |= 0b10;
            }
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                board[i][j] >>= 1;
            }
        }
    }
}
