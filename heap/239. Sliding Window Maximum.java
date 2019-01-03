class Solution {
    class MonotonicQueue {
        private Deque<Integer> deque;
        MonotonicQueue() {
            deque = new LinkedList<>();
        }
        
        public void push(int i) {
            while (deque.size() > 0 && deque.peekLast() < i) deque.removeLast();
            deque.addLast(i);
        }
        
        public void pop() {
            deque.removeFirst();
        }
        
        public int max() {
            return deque.peekFirst();
        }
    }
    
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) return nums;
        
        MonotonicQueue mq = new MonotonicQueue();
        int[] res = new int[nums.length - k + 1];
        
        for (int i = 0; i < nums.length; i++) {
            mq.push(nums[i]);
            if (i - k + 1 >= 0) {
                res[i - k + 1] = mq.max();
                if (mq.max() == nums[i - k + 1]) mq.pop();
            }
        }
        
        return res;
    }
}
