class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] res = new int[n];
        Stack<Integer> stack = new Stack<>();
        int prev = 0; // prev timestamp
        for (String log: logs) {
            String[] strs = log.split(":");
            int id = Integer.valueOf(strs[0]);
            int curt = Integer.valueOf(strs[2]);
            if (strs[1].equals("start")) {
                if (!stack.isEmpty()) {
                    res[stack.peek()] += curt - prev;
                }
                stack.push(id);
                prev = curt;
            } else {
                res[stack.pop()] += curt - prev + 1;
                prev = curt + 1;
            }
        }
        
        return res;
    }
}
