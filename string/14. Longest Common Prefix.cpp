class Solution {
public:
    string longestCommonPrefix(vector<string>& strs) {
        string res;
        if (strs.size() == 0) return res;
        if (strs.size() == 1) return strs[0];
        
        int j = 0;
        bool flag = false;
        while (j < strs[0].size()) {
            for (int i = 1; i < strs.size(); i++) {
                if (strs[i-1][j] != strs[i][j]) {
                    flag = true;
                    break;
                }
            }
            if (flag == true) break;
            j++;
        }
        for (int i = 0; i < j; i++) {
            res += strs[0][i];
        }
        return res;
    }
};
