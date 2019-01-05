class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> map = new HashMap<>();
        for (String cd: cpdomains) {
            int i = cd.indexOf(' ');
            int n = Integer.valueOf(cd.substring(0, i));
            String s = cd.substring(i + 1);
            map.put(s, map.getOrDefault(s, 0) + n);
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == '.') {
                    String subdomain = s.substring(j + 1);
                    map.put(subdomain, map.getOrDefault(subdomain, 0) + n);
                }
            }
        }
        
        List<String> res = new ArrayList();
        for (String d : map.keySet()) res.add(map.get(d) + " " + d);
        return res;
    }
}
