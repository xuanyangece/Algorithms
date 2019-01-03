/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        char[] temp = new char[4];
        int index = 0;
        while (true) {
            int count = read4(temp);
            count = Math.min(count, n - index); // when n < 4 and file > 4
            for (int i = 0; i < count; i++) {
                buf[index++] = temp[i];
            } 
            if (index == n || count < 4) return index;
        }
    }
}
