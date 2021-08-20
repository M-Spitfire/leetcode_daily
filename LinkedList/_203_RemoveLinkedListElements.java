package LinkedList;
/**
 * 在链表中移除指定的元素
 */

public class _203_RemoveLinkedListElements {
    public ListNode removeElements(ListNode head, int val) {
        ListNode res = new ListNode();
        ListNode point = res;

        while(head != null){
            if(head.val != val){
                point.next = head;
                point = head;
            }
            else{
                point.next = null;
            }
            head = head.next;
        }

        return res.next;
    }

    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
