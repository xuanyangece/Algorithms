class Solution {
    public String reverseString(String s) {
        if (s == null || s.length() <= 1) return s;
        int n = s.length();
        char[] reversed = s.toCharArray();
        
        for (int i = 0; i < n/2; i++) {
            char temp = reversed[i];
            reversed[i] = reversed[n - 1 - i];
            reversed[n - 1 - i] = temp;
        }
        
        return String.valueOf(reversed);
    }
}
