// https://www.youtube.com/watch?v=7UQ71uwQFx4
class Solution {
    public String convert(String s, int numRows) {
        int n = s.length();
        
        if (numRows >= n || numRows <= 1) {
            return s;
        }
        
        char[] res = new char[n];
        int count = 0;
        int interval = 2 * numRows - 2;
        
        for (int i = 0; i < numRows; i++) {
            int step = interval - 2 * i;
            for (int j = i; j < n; j += interval) {
                res[count] = s.charAt(j);
                count++;
                
                if (step > 0 && step < interval && j + step < n) {
                    res[count] = s.charAt(j + step);
                    count++;
                }
            }
        }
        
        return new String(res);
    }
}
