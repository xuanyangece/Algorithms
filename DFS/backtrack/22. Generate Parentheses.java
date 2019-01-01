class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        dfs(ans, "", 0, 0, n);
        return ans;
    }
    
    private void dfs(List ans, String temp, int open, int close, int max) {
        if (temp.length() == max * 2) {
            ans.add(temp);
        }
        
        if (open < max) {
            dfs(ans, temp + "(", open + 1, close, max);
        }
        if (close < open) {
            dfs(ans, temp + ")", open, close + 1, max);
        }
    }
}
