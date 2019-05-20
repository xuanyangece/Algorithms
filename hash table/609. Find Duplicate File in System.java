// Time: O(n * s) 
// Space: O(n * s)
class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        HashMap<String, List<String> > map = new HashMap<>();
        
        for (String str: paths) {
            String[] values = str.split(" ");
            String path = values[0];
            
            for (int i = 1; i < values.length; i++) {
                String content = values[i].substring(values[i].indexOf("("), values[i].indexOf(")"));
                List<String> list = map.getOrDefault(content, new ArrayList<String>());
                list.add(path + "/" + values[i].substring(0, values[i].indexOf("(")));
                map.put(content, list);
            }
        }
        
        List<List<String> > ans = new ArrayList<>();
        for (String key: map.keySet()) {
            if (map.get(key).size() > 1) {
                ans.add(map.get(key));
            }
        }
        
        return ans;
    }
}


