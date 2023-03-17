package Medium;

/**
 * 2. 两数相加
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 */
public class M2 {
}

/**
 * Definition for singly-linked list.
 */
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode resList = new ListNode(0);
        ListNode pres = resList;
        int flag = 0;
        ListNode p1 = l1;
        ListNode p2 = l2;
        while(p1 != null && p2 != null) {
            int sum = p1.val + p2.val + flag;
            if(sum >= 10) {
                flag = 1;
                sum = sum - 10;
            }
            else {
                flag = 0;
            }
            pres.val = sum;
            pres.next = new ListNode(flag);
            pres = pres.next;
            p1 = p1.next;
            p2 = p2.next;
        }
        while(p1 != null) {
            int sum = p1.val + flag;
            if(sum >= 10) {
                flag = 1;
                sum = sum - 10;
            }
            else {
                flag = 0;
            }
            pres.val = sum;
            pres.next = new ListNode(flag);
            pres = pres.next;
            p1 = p1.next;
        }
        while(p2 != null) {
            int sum = p2.val + flag;
            if(sum >= 10) {
                flag = 1;
                sum = sum - 10;
            }
            else {
                flag = 0;
            }
            pres.val = sum;
            pres.next = new ListNode(flag);
            pres = pres.next;
            p2 = p2.next;
        }
        pres = resList;
        ListNode pnext = pres.next;
        if(pnext.next == null && pnext.val == 0){
            pres.next = null;
        }
        while (pnext.next != null) {
            pres = pnext;
            pnext = pnext.next;
        }
        if(pnext.val == 0){
            pres.next = null;
        }
        return resList;
    }
}