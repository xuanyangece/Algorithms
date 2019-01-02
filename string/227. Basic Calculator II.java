class Solution {
    public int calculate(String s) {
        if (s == null || s.length() == 0) return 0;
        s = s.trim().replaceAll(" +", "");
        int res = 0;
        int preVal = 0;
        int i = 0;
        char sign = '+';
        
        while (i < s.length()) {
            int curVal = 0;
            while (i < s.length() && Character.isDigit(s.charAt(i))) {
                curVal = curVal * 10 + s.charAt(i) - '0';
                i++;
            }
            if (sign == '+') {
                res += preVal;
                preVal = curVal;
            }
            if (sign == '-') {
                res += preVal;
                preVal = -curVal;
            }
            if (sign == '*') {
                preVal *= curVal;
            }
            if (sign == '/') {
                preVal /= curVal;
            }
            if (i < s.length()) {
                sign = s.charAt(i);
                i++;
            }
        }
        res += preVal;
        
        return res;
    }
}
