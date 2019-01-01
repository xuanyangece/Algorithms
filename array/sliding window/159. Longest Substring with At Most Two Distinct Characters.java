class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if (s == null || s.length() == 0) return 0;
        
        HashMap<Character, Integer> index = new HashMap<>();
        int max = 0, right = 0, left = 0;
        int minIndex = 0;
        
        while (right < s.length()) {
            if (index.size() <= 2) {
                index.put(s.charAt(right), right);
                right++;
            }
            if (index.size() > 2) {
                minIndex = s.length();
                for (int curt: index.values()) {
                    minIndex = Math.min(minIndex, curt);
                }
                char c = s.charAt(minIndex);
                index.remove(c);
                left = minIndex + 1;
            }
            max = Math.max(max, right - left);
        }
        
        return max;
    }
}
