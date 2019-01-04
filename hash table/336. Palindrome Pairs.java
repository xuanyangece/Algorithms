class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new ArrayList<>();
        if (words == null || words.length < 2) return res;
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            map.put(words[i], i);
        }
        
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j <= words[i].length(); j++) {
                String str1 = words[i].substring(0, j);
                String str2 = words[i].substring(j);
                if (isPalindrome(str1)) {
                    String str2vrs = new StringBuilder(str2).reverse().toString();
                    if (map.containsKey(str2vrs) && map.get(str2vrs) != i) {
                        res.add(Arrays.asList(map.get(str2vrs), i));
                    }
                }
                if (str2.length() != 0 && isPalindrome(str2)) {     // prevent abcd dcba
                    String str1vrs = new StringBuilder(str1).reverse().toString();
                    if (map.containsKey(str1vrs) && map.get(str1vrs) != i) {
                        res.add(Arrays.asList(i, map.get(str1vrs)));
                    }
                }
            }
        }
        return res;
    }
    
    private boolean isPalindrome(String s) {
        if (s.length() == 0) return true;
        
        int l = 0, r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l++) != s.charAt(r--)) return false;
        }
        return true;
        
    }
}
