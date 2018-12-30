class Solution {
    public int totalFruit(int[] tree) {
        if (tree == null || tree.length == 0) return 0;
        
        HashMap<Integer, Integer> counter = new HashMap<Integer, Integer>();
        int sum = 0, start = 0, end = 0;
        while (end < tree.length) {
            counter.put(tree[end], counter.getOrDefault(tree[end], 0) + 1);
            while (counter.size() > 2) {
                if (counter.put(tree[start], counter.get(tree[start]) - 1) == 1) {
                    counter.remove(tree[start]);
                    start++;
                    break;
                } else {
                    start++;
                }
            }
            sum = Math.max(sum, end - start + 1);
            end++;
        }
        
        return sum;
    }
}
