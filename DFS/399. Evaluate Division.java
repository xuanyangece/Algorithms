class Solution {
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        // preparation
        HashMap<String, ArrayList<String>> pairs = new HashMap<>();
        HashMap<String, ArrayList<Double>> results = new HashMap<>();
        
        for (int i = 0; i < equations.length; i++) {
            String[] equation = equations[i];   // "a", "b"
            if (!pairs.containsKey(equation[0])) {
                pairs.put(equation[0], new ArrayList<>());
                results.put(equation[0], new ArrayList<>());
            }
            if (!pairs.containsKey(equation[1])) {
                pairs.put(equation[1], new ArrayList<>());
                results.put(equation[1], new ArrayList<>());
            }
            pairs.get(equation[0]).add(equation[1]);
            pairs.get(equation[1]).add(equation[0]);
            results.get(equation[0]).add(values[i]);
            results.get(equation[1]).add(1 / values[i]);
        }
        
        double[] ans = new double[queries.length];
        for (int i = 0; i < ans.length; i++) {
            String[] query = queries[i];
            ans[i] = dfs(pairs, results, query[0], query[1], new HashSet<String>(), 1.0);
            if (ans[i] == 0.0) ans[i] = -1.0;
        }
        return ans;
    }
    
    private double dfs(HashMap<String, ArrayList<String>> pairs, HashMap<String, ArrayList<Double>> results, String start, String end, HashSet used, double value) {
        if (!pairs.containsKey(start)) return 0.0;
        if (used.contains(start)) return 0.0;
        if (start.equals(end)) return value;
        used.add(start);
        
        ArrayList<String> pair = pairs.get(start);
        ArrayList<Double> result = results.get(start);
        double temp = 0.0;
        for (int i = 0; i < pair.size(); i++) {
            temp = dfs(pairs, results, pair.get(i), end, used, value * result.get(i));
            if (temp != 0.0) break;
        }
        
        return temp;
    }
}
