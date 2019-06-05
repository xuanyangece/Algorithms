class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        String[] words = paragraph.toLowerCase().split("[ !?',;.]+");
        Map<String, Integer> count = new HashMap<>();
        
        for (String word : words) {
            count.put(word, count.getOrDefault(word, 0) + 1);
        }
        
        for (String ban : banned) {
            count.remove(ban);
        }
        
        String ans = null;
        for (String curt : count.keySet()) {
            if (ans == null || count.get(curt) > count.get(ans)) {
                ans = curt;
            }
        }
        
        return ans;
    }
}
