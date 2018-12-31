class Solution {
    public int lengthOfLongestSubstring(String s) {
        char[] c = s.toCharArray();
        HashSet<Character> set = new HashSet();
        int i = 0, j = 0, max = 0;
        
        while (i < c.length) {
            if (set.contains(c[i])) {
                set.remove(c[j++]);
            } else {
                set.add(c[i++]);
                max = Math.max(i - j, max);
            }
        }
        
        return max;
    }
}
