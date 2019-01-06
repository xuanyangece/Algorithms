/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        
        ListNode mid = findMid(head);
        ListNode rvs = reverse(mid.next), ori = head;
        mid.next = null; // unnecessary
        
        while (rvs != null) {
            if (rvs.val != ori.val) return false;
            rvs = rvs.next;
            ori = ori.next;
        }
        
        return true;
    }
    
    private ListNode findMid(ListNode head) {
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    
    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curt = head;
        
        while (curt != null) {
            ListNode temp = curt.next;
            curt.next = prev;
            prev = curt;
            curt = temp;
        }

        return prev;
    }
}
