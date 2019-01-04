/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode helpA = headA;
        ListNode helpB = headB;
        
        while (helpA != helpB) {
            helpA = helpA == null ? headB : helpA.next;
            helpB = helpB == null ? headA : helpB.next;
        }
        
        return helpA;
    }
}
