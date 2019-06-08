class Solution {
    public int compress(char[] chars) {
        int indexAns = 0, index = 0;
        while (index < chars.length) {
            char curtChar = chars[index];
            int count = 0;
            while (index < chars.length && curtChar == chars[index]) {
                index++;
                count++;
            }
            chars[indexAns++] = curtChar;
            if (count > 1) {
                for (char c : Integer.toString(count).toCharArray()) {
                    chars[indexAns++] = c;
                }
            }
        }
        return indexAns;
    }
}
