class Solution {
    int diff = Integer.MAX_VALUE;
    String result = "";
    int h;
    int m;
    public String nextClosestTime(String time) {
        int[] digit = new int[4];
        int tot = 0;
        String[] val = time.split(":");
        int hour = Integer.parseInt(val[0]);
        int minu = Integer.parseInt(val[1]);
        digit[tot++] = hour / 10;
        digit[tot++] = hour % 10;
        digit[tot++] = minu / 10;
        digit[tot++] = minu % 10;
        
        h = hour;
        m = minu;
        
        dfs(digit, 0, new int[4]);
        
        return result;
    }
    
    private void dfs(int[] digit, int i, int[] ans) {
        if (i == 4) {
            int hour = 10 * ans[0] + ans[1];
            int minu = 10 * ans[2] + ans[3];
            if (0 <= hour && hour <= 23 && 0 <= minu && minu <= 59) {
                int df = diff(hour, minu);
                if (df < diff) {
                    diff = df;
                    result = valid(hour) + ":" + valid(minu);
                }
            }
        } else {
            for (int j = 0; j < 4; j++) {
                ans[i] = digit[j];
                dfs(digit, i + 1, ans);
            }
        }
    }
    
    private String valid(int num) {
        if (num < 10) return "0" + num;
        else return num + "";
    }
    
    private int diff(int hour, int minu) {
        int c2o = 24 * 60 - h * 60 - m;
        int n2o = 24 * 60 - hour * 60 - minu;
        return n2o < c2o ? c2o - n2o : c2o - n2o + 1440;
    }
}
