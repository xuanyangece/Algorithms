class Solution {
    Map<String, PriorityQueue<String>> flights;
    LinkedList<String> path;
    
    public List<String> findItinerary(List<List<String>> tickets) {
        flights = new HashMap<>();
        path = new LinkedList<>();
        
        for (List<String> ticket: tickets) {
            flights.putIfAbsent(ticket.get(0), new PriorityQueue<>());
            flights.get(ticket.get(0)).add(ticket.get(1));
        }
        
        dfs("JFK");
        return path;
    }
    
    private void dfs(String departure) {
        PriorityQueue<String> arrivals = flights.get(departure);
        // null means absolute end, empty means intermediate end
        while (arrivals != null && !arrivals.isEmpty()) {
            dfs(arrivals.poll());
        }
        path.addFirst(departure);
    }
}
