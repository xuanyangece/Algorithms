class Solution {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s == "" || t == "" || s.length() < t.length()) return "";
        
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c: t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        int count = 0, left = 0, right = 0, dis = Integer.MAX_VALUE, head = 0;
        
        while (right < s.length()) {
            char rightc = s.charAt(right++);
            
            if (map.containsKey(rightc)) {
                if (map.put(rightc, map.get(rightc) - 1) > 0)
                    count++;
                
                while (count == t.length()) {
                    if (right - left < dis) {
                        dis = right - left;
                        head = left;
                    }
                    
                    char leftc;
                    if (map.containsKey(leftc = (s.charAt(left++)))) {
                        if (map.put(leftc, map.get(leftc) + 1) == 0) {
                            count--;
                        }
                    }
                }
            }
        }
        
        if (dis == Integer.MAX_VALUE) return "";
        
        else return s.substring(head, head + dis);
    }
}
