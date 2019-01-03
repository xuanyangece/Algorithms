class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        helper(res, s, 0, "", 0);
        return res;
    }
    
    private void helper(List res, String s, int index, String ret, int count) {
        if (count > 4) return;
        else if (count == 4 && index == s.length()) {
            res.add(ret);
            return;
        }
        for (int i = 1; i < 4; i++) {
            if (index + i > s.length()) return;
            String temp = s.substring(index, index + i);
            if ((s.charAt(index) == '0' && temp.length() > 1) || (Integer.valueOf(temp) >= 256)) return;
            helper(res, s, index + i, ret + temp + (count == 3 ? "" : "."), count + 1);
        }
    }
}
