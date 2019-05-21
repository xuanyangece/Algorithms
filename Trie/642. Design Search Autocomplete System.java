class AutocompleteSystem {
    class TrieNode {
        Map<Character, TrieNode> children;
        Map<String, Integer> counts;
        boolean isWord;
        
        public TrieNode() {
            children = new HashMap<>();
            counts = new HashMap<>();
            isWord = false;
        }
    }
    
    // For comparing top 3
    class Pair {
        String s;
        int c;
        
        public Pair(String _s, int _c) {
            this.s = _s;
            this.c = _c;
        }
    }
    
    TrieNode root;
    String prefix;
    
    public AutocompleteSystem(String[] sentences, int[] times) {
        root = new TrieNode();
        prefix = "";
        
        for (int i = 0; i < sentences.length; i++) {
            add(sentences[i], times[i]);
        }
    }
    
    // help to initialize this class
    private void add(String s, int count) {
        TrieNode curt = root;
        for (char c: s.toCharArray()) {
            // update children
            TrieNode next = curt.children.get(c);
            if (next == null) {
                next = new TrieNode();
                curt.children.put(c, next);
            }
            curt = next;
            // update count
            curt.counts.put(s, curt.counts.getOrDefault(s, 0) + count);
        }
        curt.isWord = true;
    }
    
    public List<String> input(char c) {
        // #
        if (c == '#') {
            add(prefix, 1);
            prefix = "";
            return new ArrayList<String>();
        }
        
        prefix = prefix + c;
        TrieNode curt = root;
        
        // reach correct node
        for (char cc: prefix.toCharArray()) {
            TrieNode next = curt.children.get(cc);
            if (next == null) return new ArrayList<String>();
            curt = next;
        }
        
        // get top 3
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> (a.c == b.c) ? a.s.compareTo(b.s) : b.c - a.c);
        for (String s: curt.counts.keySet()) {
            pq.offer(new Pair(s, curt.counts.get(s)));
        }
        
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < 3 && !pq.isEmpty(); i++) {
            ans.add(pq.poll().s);
        }
        
        return ans;
    }
}

/**
 * Your AutocompleteSystem object will be instantiated and called as such:
 * AutocompleteSystem obj = new AutocompleteSystem(sentences, times);
 * List<String> param_1 = obj.input(c);
 */

    
