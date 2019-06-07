class Solution {
    class TrieNode {
        TrieNode[] next = new TrieNode[26];
        String word;
    }
    
    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        
        for (String word: words) {
            TrieNode curt = root;
            for (char c: word.toCharArray()) {
                int index = c - 'a';
                if (curt.next[index] == null) curt.next[index] = new TrieNode();
                curt = curt.next[index];
            }
            curt.word = word;
        }
        
        return root;
    }
    
    private void dfs(char[][] board, TrieNode node, int x, int y, List<String> res) {
        char curt = board[x][y];
        if (curt == '#' || node.next[curt - 'a'] == null) return;
        node = node.next[curt - 'a'];
        
        if (node.word != null) {
            res.add(node.word);
            node.word = null;
        }
        
        // for backtrack
        board[x][y] = '#';
        
        if (x > 0) dfs(board, node, x - 1, y, res);
        if (y > 0) dfs(board, node, x, y - 1, res);
        if (x < board.length - 1) dfs(board, node, x + 1, y, res);a
        if (y < board[0].length - 1) dfs(board, node, x, y + 1, res);

        board[x][y] = curt;
    }
    
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new LinkedList<>();
        if (board == null || words == null || board.length == 0 || words.length == 0) {
            return res;
        }
        
        TrieNode root = buildTrie(words);
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, root, i, j, res);
            }
        }
        
        return res;
    }
}
