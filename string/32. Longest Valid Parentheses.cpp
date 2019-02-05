class Solution {
public:
    int longestValidParentheses(string s) {
        int leftmost = -1, maxV = 0;
        stack<int> pairs;
        
        for (int i = 0; i < s.size(); i++) {
            if (s[i] == '(') {
                pairs.push(i);
            }
            else {
                if (pairs.empty()) {
                    leftmost = i;
                }
                else {
                    pairs.pop();
                    if (pairs.empty()) maxV = max(maxV, i - leftmost);
                    else maxV = max(maxV, i - pairs.top());
                }
            }
        }
        
        return maxV;
    }
};
