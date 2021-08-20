package LinkedList;

/**
 * 思路一: 哈希存储
 * - 遍历其中一条链表, 并将所有节点都存在一个集合中, 然后遍历另一条链表, 第一个存在于集合中的节点就是相交的节点
 * 
 * 思路二: 双指针
 * 这个比较难想, 整体思路类似寻找链表中的循环点
 * - Pa从链表A的头节点出发, Pb从链表B的头节点出发
 * - 当Pa到达末尾时, 移动到链表B的头节点继续移动; 当Pb到达末尾时, 移动到链表A的头节点继续移动
 * - 这样就构造了两个节点数相同且有共同部分的链表(确实有交点的情况), 其形状类似爱心❤, 
 *   这样两个指针相交的节点就是我们要找的节点了
 * - 如果两个链表没有公共部分, 那么两个指针最终会停在末尾的null处
 */

public class _160_IntersectionOfTwoLinkedList {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;
        ListNode a = headA;
        ListNode b = headB;

        while(a != b){
            if(a == null)a = headB;
            else a = a.next;
            if(b == null)b = headA;
            else b = b.next;
        }

        //出循环时两个指针一定相等, 返回任意一个即可
        return a;
    }
}

/**
 * Definition for singly-linked list.
 * 在这里创建完整链表非常麻烦, 这个只是为了不报错
 */
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}