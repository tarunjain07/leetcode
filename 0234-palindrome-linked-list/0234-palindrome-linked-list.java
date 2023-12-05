/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode midNode = mid(head);
        ListNode newHead = midNode.next;
        midNode.next = null;

        newHead = reverse(newHead);

        ListNode headCopy = head;
        ListNode newHeadCopy = newHead;

        boolean result = true;
        while (newHeadCopy != null) {
            if(headCopy.val != newHeadCopy.val){
                result = false;
                break;
            }
            headCopy = headCopy.next;
            newHeadCopy = newHeadCopy.next;
            
        }

        //Restore list
        newHead = reverse(newHead);
        midNode.next = newHead;

        return result;
    }

    public ListNode mid(ListNode root){
        ListNode slow = root;
        ListNode fast = root;

        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public ListNode reverse(ListNode root){
        ListNode prev = null;
        ListNode current = root;

        while(current != null){
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        
        return prev;
        
    }
}