class MaxStack {
    Stack<Integer> stack;
    Stack<Integer> mStack;
    
    /** initialize your data structure here. */
    public MaxStack() {
        stack = new Stack<>();
        mStack = new Stack<>();
    }
    
    public void push(int x) {
        int curtMax = mStack.isEmpty() ? Integer.MIN_VALUE : mStack.peek();
        mStack.push(curtMax > x ? curtMax : x);
        stack.push(x);
    }
    
    public int pop() {
        mStack.pop();
        return stack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int peekMax() {
        return mStack.peek();
    }
    
    public int popMax() {
        Stack<Integer> temp = new Stack<>();
        int max = mStack.peek();
        while (stack.peek() != max) temp.push(pop());
        pop();
        while (!temp.isEmpty()) push(temp.pop());
        return max;
    }
}

/**
 * Your MaxStack object will be instantiated and called as such:
 * MaxStack obj = new MaxStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.peekMax();
 * int param_5 = obj.popMax();
 */
