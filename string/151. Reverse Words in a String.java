// time O(n), space O(n)
public class Solution {
    public String reverseWords(String s) {
        String[] words = s.trim().split("\\s+"); // \\s means whitespace, enter or \n
        StringBuilder sb = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            sb.append(words[i] + " ");
        }
        
        return sb.toString().trim();
    }
}

// time O(n), space O(n)
public class Solution {
    public String reverseWords(String s) {
        if (s == null || s.length() == 0) return s;
        
        char[] ch = s.toCharArray();
        reverse(ch, 0, ch.length - 1);
        reverseWord(ch, ch.length);
        return cleanSpace(ch, ch.length);
    }
    
    private void reverse(char[] ch, int i, int j) {
        while (i < j) {
            char temp = ch[i];
            ch[i++] = ch[j];
            ch[j--] = temp;
        }
    }
    
    private void reverseWord(char[] ch, int len) {
        int i = 0;
        int j = 0;
        while (j < len) {
            while (i < j || i < len && ch[i] == ' ') i++;
            while (j < i || j < len && ch[j] != ' ') j++;
            reverse(ch, i, j - 1);
        }
    }
    
    private String cleanSpace(char[] ch, int len) {
        int i = 0;
        int j = 0;
        while (j < len) {
            while (j < len && ch[j] == ' ') j++;
            while (j < len && ch[j] != ' ') ch[i++] = ch[j++];
            while (j < len && ch[j] == ' ') j++;
            if (j < len) ch[i++] = ' ';
        }
        
        return String.valueOf(ch).substring(0, i);
    }
}
