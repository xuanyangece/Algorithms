class Solution {
    public char[][] updateBoard(char[][] board, int[] click) {
        int n = board.length, m = board[0].length;
        int row = click[0], col = click[1];
        
        if (board[row][col] == 'M') {
            board[row][col] = 'X';
        } else {
            // calculate adjecent mines
            int count = 0;
            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    if (i == 0 && j == 0) continue;
                    int nx = row + i, ny = col + j;
                    if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                    if (board[nx][ny] == 'M' || board[nx][ny] == 'X') count++;
                }
            }
            
            if (count > 0) {
                board[row][col] = (char)(count + '0');
            } else {
                board[row][col] = 'B';
                for (int i = -1; i <= 1; i++) {
                    for (int j = -1; j <= 1; j++) {
                        if (i == 0 && j == 0) continue;
                        int nx = row + i, ny = col + j;
                        if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                        if (board[nx][ny] == 'E') updateBoard(board, new int[]{nx, ny});
                    }
                }
            }
        }
        
        return board;
    }
}

