class Solution {
public:
    vector<string> fullJustify(vector<string>& words, int maxWidth) {
        vector<string> res;
        
        int i = 0, k = 0, l = 0;
        for (i = 0; i < words.size(); i += k) {
            for (k = 0; i + k < words.size() && l + words[i+k].size() <= maxWidth - k; k++) {
                l += words[i+k].size();
            }
            string temp = words[i];
            for (int j = 0; j < k - 1; j++) {
                if (i + k >= words.size()) temp += " ";
                else temp += string((maxWidth - l) / (k - 1) + (j < (maxWidth - l) % (k - 1)), ' ');
                temp += words[i + j + 1];
            }
            temp += string(maxWidth - temp.size(), ' ');
            res.push_back(temp);
            l = 0;
        }
        
        return res;
    }
};
