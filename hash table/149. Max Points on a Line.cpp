class Solution {
private:
    std::pair<int, int> getSlope(const vector<int>& p1, const vector<int>& p2) {
        const int dx = p1[0] - p2[0];
        const int dy = p1[1] - p2[1];
        
        if (dy == 0) {
            return { p1[1], 0 };
        }
        if (dx == 0) {
            return { 0, p1[0] };
        }
        
        int d = gcd(dx, dy);
        return { dy/d, dx/d };
    }
    
    int gcd(int x, int y) {
        return y == 0 ? x :gcd(y, x % y);
    }
    
public:
    int maxPoints(vector<vector<int>>& points) {
        int n = points.size();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            std::map<std::pair<int, int>, int> count;
            int same_points = 1;
            int max_points = 0;
            const vector<int>& p1 = points[i];
            for (int j = i + 1; j < n; j++) {
                const vector<int>& p2 = points[j];
                if (p1[0] == p2[0] && p1[1] == p2[1]) {
                    same_points++;
                }
                else {
                    max_points = max(max_points, ++count[getSlope(p1, p2)]);
                }
            }
            ans = max(ans, max_points + same_points);
        }
        return ans;
    }


};
