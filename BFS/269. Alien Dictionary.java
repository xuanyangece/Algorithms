class Solution {
    public String alienOrder(String[] words) {
        if (words == null || words.length == 0) return "";
        
        StringBuilder res = new StringBuilder();
        HashMap<Character, Set<Character>> map = new HashMap<>();
        int[] indegree = new int[26];
        Arrays.fill(indegree, -1);
        int count = 0;
        
        for (String word: words) {
            for (char c: word.toCharArray()) {
                if (indegree[c - 'a'] == -1) {
                    count++;
                    indegree[c - 'a'] = 0;
                }
            }
        }
        
        // construct graph
        for (int i = 0; i < words.length - 1; i++) {
            String w1 = words[i];
            String w2 = words[i + 1];
            int len = Math.min(w1.length(), w2.length());
            for (int j = 0; j < len; j++) {
                char c1 = w1.charAt(j);
                char c2 = w2.charAt(j);
                if (c1 != c2) {
                    if (!map.containsKey(c1)) map.put(c1, new HashSet<>());
                    if (map.get(c1).add(c2)) {
                        indegree[c2 - 'a']++;
                    }
                    break;
                }
            }
        }
        
        // bfs
        Queue<Character> q = new LinkedList<>();
        for (int i = 0; i < 26; i++) {
            if (indegree[i] == 0) {
                q.offer((char)('a' + i));
            }
        }
        
        while (!q.isEmpty()) {
            char c = q.poll();
            res.append(c);
            if (map.containsKey(c)) {
                for (char next: map.get(c)) {
                    if (--indegree[next - 'a'] == 0) {
                        q.offer(next);
                    }
                }
            }
        }
        
        if (count != res.length()) return "";
        
        return res.toString();
    }
}
