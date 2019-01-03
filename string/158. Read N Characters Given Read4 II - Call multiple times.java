/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    private int count = 0; // read4 return value
    private int pointer = 0; // current pointer in current temp
    private char[] temp = new char[4];
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        int index = 0;
        while (index < n) {
            // possibly load
            if (pointer == 0) {
                count = read4(temp);
            }
            if (count == 0) break;
            // possibly write
            while (index < n && pointer < count) {
                buf[index++] = temp[pointer++];
            }
            // full then reset
            if (pointer == count) pointer = 0;
        }
        return index;
    }
}
