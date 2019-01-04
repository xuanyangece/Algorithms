class Solution {
    public String multiply(String num1, String num2) {
        if (num1 == null || num2 == null) return "0";
        
        int[] res = new int[num1.length() + num2.length()];
        for (int i = num1.length() - 1; i >= 0; i--) {
            for (int j = num2.length() - 1; j >= 0; j--) {
                int product = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int p1 = i + j;
                int p2 = i + j + 1;
                int sum = product + res[p2];
                res[p1] += sum / 10;
                res[p2] = sum % 10;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for (int digit: res) {
            if (digit == 0 && sb.length() == 0) continue;
            sb.append(digit);
        }
        
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
