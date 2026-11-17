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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp=head;
        int size=0;
        if(temp==null){
            return head;
        }
        if(temp.next==null && n==1){
            head=null;
            return head;
        }

        while(temp!=null){
            size++;
            temp=temp.next;
        }
        temp=head;
        for(int i=1;i<size-n;i++){
            temp=temp.next;
        }
        if(n==size){
            head=temp.next;
            return head;
        }
        if(temp.next.next==null){
            temp.next=null;
        }
        else {
            temp.next=temp.next.next;
        }

        return head;



    }
}