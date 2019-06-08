// Author: Huahua
struct CacheNode {
    int key;
    int value;
    int freq;
    // pointer to the node in the list
    list<int>::const_iterator it;
};

class LFUCache {
public:
    
    LFUCache(int capacity): capacity_(capacity), min_freq_(0) {}
    
    int get(int key) {
        auto it = n_.find(key);
        if (it == n_.cend()) return -1;
        touch(it->second);
        return it->second.value;
    }
    
    void put(int key, int value) {
        if (capacity_ == 0) return;
        
        auto it = n_.find(key);
        if (it != n_.cend()) {
            it->second.value = value;
            touch(it->second);
            return;
        }
        
        if (n_.size() == capacity_) {
            // Full, need to remove one entry that
            // 1. has the lowest freq
            // 2. least recently used if multiple ones
            
            // Step 1: remove element from min_freq_ list
            const int key_to_evict = l_[min_freq_].back();
            l_[min_freq_].pop_back();
            
            // Step 2: remove from cache
            n_.erase(key_to_evict);
        }
        
        // New item starts with freq 1
        const int freq = 1;
        min_freq_ = freq;
        
        // Add the key to the freq list
        l_[freq].push_front(key);
        
        // Create a new node
        n_[key] = {key, value, freq, l_[freq].cbegin()};
    }
    
private:
    void touch(CacheNode& node) {
        // Step 1: update frequency
        const int prev_freq = node.freq;
        const int freq = ++(node.freq);
        
        // Step 2: remove entry from old freq list
        l_[prev_freq].erase(node.it);
        
        if (l_[prev_freq].empty() && min_freq_ == prev_freq) {
            // Delete the list
            l_.erase(prev_freq);
            
            // Increase min freq
            ++min_freq_;
        }
        
        // Step 3: insert the key into the freq list
        l_[freq].push_front(node.key);
        
        // Step 4: update pointer
        node.it = l_[freq].cbegin();
    }
    
    int capacity_;
    int min_freq_;
    
    // key -> CacheNode
    unordered_map<int, CacheNode> n_;
    
    // freq -> keys with freq
    unordered_map<int, list<int> > l_;
};

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache* obj = new LFUCache(capacity);
 * int param_1 = obj->get(key);
 * obj->put(key,value);
 */
