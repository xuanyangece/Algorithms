class MyHashMap {
    class ListNode {
        int key;
        int value;
        ListNode next;
        
        public ListNode (int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    
    final ListNode[] nodes = new ListNode[10000];
    
    private ListNode find (ListNode bucket, int key) {
        ListNode curt = bucket, prev = null;
        while (curt != null && curt.key != key) {
            prev = curt;
            curt = curt.next;
        }
        return prev;
    }

    /** Initialize your data structure here. */
    public MyHashMap() {
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        int i = key % nodes.length;
        if (nodes[i] == null) {
            nodes[i] = new ListNode(-1, -1);
        }
        ListNode prev = find(nodes[i], key);
        if (prev.next != null) {
            prev.next.value = value;
        } else {
            prev.next = new ListNode(key, value);
        }
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int i = key % nodes.length;
        if (nodes[i] == null) return -1;
        
        ListNode prev = find(nodes[i], key);
        if (prev.next == null) {
            return -1;
        } else {
            return prev.next.value;
        }
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int i = key % nodes.length;
        if (nodes[i] == null) return;
        ListNode prev= find(nodes[i], key);
        if (prev.next == null) {
            return;
        } else {
            prev.next = prev.next.next;
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
