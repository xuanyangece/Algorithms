/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode curt = head;
        int count = 0;
        while (count < k && curt != null) {
            count++;
            curt = curt.next;
        }
        if (k == count) {
            curt = reverseKGroup(curt, k);
            while (count-- > 0) {
                ListNode temp = head.next;
                head.next = curt;
                curt = head;
                head = temp;
            }
            head = curt;
        }
        return head;
    }
}
