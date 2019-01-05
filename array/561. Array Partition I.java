class Solution {
    public int arrayPairSum(int[] nums) {
        final int MAX = 10000;
        int[] map = new int[2*MAX + 1];
        for (int num: nums) {
            map[num + MAX]++;
        }
        
        boolean odd = true;
        int res = 0;
        for (int i = 0; i < map.length; i++) {
            if (map[i] == 0) continue;
            while (map[i] > 0) {
                if (odd) {
                    res += i - MAX;
                }
                odd = !odd;
                map[i]--;
            }
        }
        
        return res;
    }
}
