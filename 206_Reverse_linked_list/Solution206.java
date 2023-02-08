/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution206 {
    public ListNode reverseList(ListNode head) {
        return iterativeMethod(head);
    }

    // using three pointers instead of two
    private ListNode iterativeMethod(ListNode head) {
        ListNode a = null;
        ListNode b = null;
        ListNode c = head;
        while (c != null) {
            a = b;
            b = c;
            c = c.next;
            b.next = a;
        }
        return b;
    }

    // recursive method
    private ListNode recursiveMethod(ListNode head, listNode prev) {
        if (head == null) {
            return prev;
        }
        ListNode tempNode = head.next;
        head.next = prev;
        return recursiveMethod(tempNode, prev);
    }
}