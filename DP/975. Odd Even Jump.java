// time: nlog(n)
// space: n
class Solution {
    public int oddEvenJumps(int[] A) {
        int n = A.length;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        boolean[][] dp = new boolean[n][2];
        dp[n - 1][0] = true;
        dp[n - 1][1] = true;
        map.put(A[n-1], n-1);
        int ans = 1;
        
        for (int i = n - 2; i >= 0; i--) {
            // odd step
            Integer nextGreat = map.ceilingKey(A[i]);
            if (nextGreat != null) {
                dp[i][0] = dp[map.get(nextGreat)][1];
            }
            // even step
            Integer nextSmall = map.floorKey(A[i]);
            if (nextSmall != null) {
                dp[i][1] = dp[map.get(nextSmall)][0];
            }
            map.put(A[i], i);
            
            ans += dp[i][0] ? 1 : 0;
        }
        
        return ans;
    }
}
