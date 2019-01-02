class Solution {
    public int calculate(String s) {
        if (s == null || s.length() == 0) return 0;
        
        int ans = 0, sign = 1;
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                int operand = s.charAt(i) - '0';
                while (i + 1< s.length() && Character.isDigit(s.charAt(i + 1))) {
                    operand = operand * 10 + s.charAt(i + 1) - '0';
                    i++;
                }
                ans += operand * sign;
            } 
            else if (s.charAt(i) == '+') sign = 1;
            else if (s.charAt(i) == '-') sign = -1;
            else if (s.charAt(i) == '(') {
                stack.push(ans);
                stack.push(sign);
                ans = 0;
                sign = 1;
            } 
            else if (s.charAt(i) == ')') {
                ans = stack.pop() * ans + stack.pop();
            }
        }
        
        return ans;
    }
}
