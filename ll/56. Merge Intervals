/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        if (intervals == null || intervals.size() <= 1) return intervals;
        
        intervals.sort((i1, i2) -> i1.start - i2.start);
        
        List<Interval> answer = new LinkedList<>();
        int start = intervals.get(0).start, end = intervals.get(0).end;
        
        for (Interval itv: intervals) {
            if (itv.start <= end) {
                end = Math.max(end, itv.end);
            } else {
                answer.add(new Interval(start, end));
                start = itv.start;
                end = itv.end;
            }
        }
        
        answer.add(new Interval(start, end));
        
        return answer;
    }
}
